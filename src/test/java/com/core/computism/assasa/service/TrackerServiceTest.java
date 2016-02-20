package com.core.computism.assasa.service;

import com.core.computism.assasa.BaseUnitTest;
import com.core.computism.assasa.domain.IssueDTO;
import com.core.computism.assasa.exception.BrainBusinessException;
import com.core.computism.assasa.persistence.entity.booking.BookingDetail;
import com.core.computism.assasa.persistence.entity.ticket.BookingInfo;
import com.core.computism.assasa.service.impl.TrackerServiceImpl;
import com.core.computism.assasa.util.BrainUtil;
import org.joda.time.Instant;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import java.sql.Timestamp;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import static org.mockito.Matchers.anyObject;
import static org.mockito.Mockito.*;

/**
 * Created by Venturedive on 8/25/2015.
 */
public class TrackerServiceTest extends BaseUnitTest {

    @Mock
    private TicketService ticketService;

    @Mock
    private BookingDetailService bookingDetailService;

    @Mock
    private BookingInfoService bookingInfoService;

    @InjectMocks
    private TrackerService trackerService = new TrackerServiceImpl();

    @Test
    public void testInspectIssues() throws BrainBusinessException {
        List<IssueDTO> testIssues = getIssues();
        List<Integer> bookingIds = BrainUtil.getBookingIds(testIssues);
        BookingInfo bookingInfo = getBookingInfo(bookingIds.get(0));

        doReturn(getBookingDetails()).when(bookingDetailService).findByBookingIds(bookingIds);
        doReturn(bookingInfo).when(bookingInfoService).save((BookingDetail)anyObject());
        doNothing().when(ticketService).persistTicket((IssueDTO) anyObject(), (BookingInfo) anyObject());

        trackerService.inspect(testIssues);

        verify(bookingDetailService, times(1)).findByBookingIds(bookingIds);
        verify(bookingInfoService, times(2)).save((BookingDetail) anyObject());
        verify(ticketService, times(4)).persistTicket((IssueDTO) anyObject(), (BookingInfo) anyObject());
    }

    private List<IssueDTO> getIssues() {
        IssueDTO issueDTO1 = new IssueDTO();
        issueDTO1.setBookingId(1234);
        issueDTO1.setRobotName("Captain Not Assigned - Dubai");
        issueDTO1.setProblemType("CAPTAIN_NOT_ASSIGNED");

        IssueDTO issueDTO2 = new IssueDTO();
        issueDTO2.setBookingId(5678);
        issueDTO2.setRobotName("Captain Not Assigned - Dubai");
        issueDTO2.setProblemType("CAPTAIN_NOT_ASSIGNED");

        // Repeated Issue
        IssueDTO issueDTO3 = new IssueDTO();
        issueDTO3.setBookingId(1234);
        issueDTO3.setRobotName("Captain Not Assigned - Dubai");
        issueDTO3.setProblemType("CAPTAIN_NOT_ASSIGNED");

        // Same Booking with Different Problem Type
        IssueDTO issueDTO4 = new IssueDTO();
        issueDTO4.setBookingId(5678);
        issueDTO4.setRobotName("Now Booking Not Arrived");
        issueDTO4.setProblemType("NOW_BOOKING_NOT_ARRIVED");

        return Arrays.asList(issueDTO1, issueDTO2, issueDTO3, issueDTO4);
    }

    private HashMap<Integer, BookingDetail> getBookingDetails() {
        HashMap<Integer, BookingDetail> data = new HashMap<>(2);
        data.put(1234, getBookingDetail(1234));
        data.put(5678, getBookingDetail(5678));
        return data;
    }

    private BookingDetail getBookingDetail(Integer bookingId) {
        BookingDetail detail = new BookingDetail();
        detail.setBookingId(bookingId);
        return detail;
    }

    private BookingInfo getBookingInfo(Integer bookingId) {
        BookingInfo info = new BookingInfo();
        info.setId(1234L);
        info.setBookingId(bookingId);
        info.setCreationDate(new Timestamp(Instant.now().getMillis()));
        info.setLastModifiedDate(info.getCreationDate());
        return info;
    }
}
