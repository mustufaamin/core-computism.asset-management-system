package com.core.computism.assasa.service.impl;

import com.core.computism.assasa.domain.IssueDTO;
import com.core.computism.assasa.exception.BrainBusinessException;
import com.core.computism.assasa.persistence.entity.booking.BookingDetail;
import com.core.computism.assasa.persistence.entity.ticket.BookingInfo;
import com.core.computism.assasa.service.BookingDetailService;
import com.core.computism.assasa.service.BookingInfoService;
import com.core.computism.assasa.service.TicketService;
import com.core.computism.assasa.service.TrackerService;
import com.core.computism.assasa.util.BrainUtil;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;

/**
 * Created by Venturedive on 8/5/2015.
 */
@Service(value = "trackerService")
public class TrackerServiceImpl implements TrackerService {

    private static final Logger LOGGER = Logger.getLogger(TrackerServiceImpl.class);

    private HashMap<Integer, BookingDetail> bookingDetailsByBookingId = new HashMap<>(0);
    private HashMap<Integer, BookingInfo> cachedBookingInfo = new HashMap<>(0);

    @Autowired private TicketService ticketService;
    @Autowired private BookingDetailService bookingDetailService;
    @Autowired private BookingInfoService bookingInfoService;

    @Override
    public void inspect(List<IssueDTO> issues) {
        LOGGER.info("Inspecting [" + issues.size() + "] Issues...");

        fetchBookingDetails(issues);
        processProblemBookings(issues);
        clear();

        LOGGER.info("Inspection Completed.");
    }

    private void processProblemBookings(List<IssueDTO> issueDTOs) {
        LOGGER.debug("Processing Problem bookings");

        for (IssueDTO issueDTO : issueDTOs) {
            try {
                BookingInfo bookingInfo = getBookingInfo(issueDTO.getBookingId());
                ticketService.persistTicket(issueDTO, bookingInfo);

            } catch (BrainBusinessException e) {
                LOGGER.error("Unable to create ticket for booking Id [" + issueDTO.getBookingId() + "]");
            }
        }
    }

    private BookingInfo getBookingInfo(Integer bookingId) throws BrainBusinessException {
        BookingInfo bookingInfo = this.cachedBookingInfo.get(bookingId);

        if (bookingInfo == null) {
            LOGGER.info("Saving booking details for Id [" + bookingId + "]");
            BookingDetail bookingDetail = this.bookingDetailsByBookingId.get(bookingId);
            bookingInfo = bookingInfoService.save(bookingDetail);
            this.cachedBookingInfo.put(bookingId, bookingInfo);
        }
        return bookingInfo;
    }

    private void fetchBookingDetails(List<IssueDTO> issueDTOs) {
        List<Integer> bookingIds = BrainUtil.getBookingIds(issueDTOs);
        bookingDetailsByBookingId = bookingDetailService.findByBookingIds(bookingIds);
    }

    private void clear() {
        LOGGER.debug("Resetting Tracker Service...");
        this.bookingDetailsByBookingId.clear();
        this.cachedBookingInfo.clear();
    }

}
