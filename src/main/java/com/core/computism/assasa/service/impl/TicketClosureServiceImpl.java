package com.core.computism.assasa.service.impl;

import com.core.computism.assasa.persistence.entity.ticket.Ticket;
import com.core.computism.assasa.service.BookingDetailService;
import com.core.computism.assasa.service.TicketClosureService;
import com.core.computism.assasa.service.TicketService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Venture Dive on 11/24/2015.
 */
@Service(value = "ticketClosureService")
public class TicketClosureServiceImpl implements TicketClosureService {
    private static final Logger LOGGER = Logger.getLogger(TicketClosureServiceImpl.class);

    @Autowired
    private TicketService ticketService;

    @Autowired
    private BookingDetailService bookingService;

    @Override
    @Transactional
    public void closeTicket() {
        LOGGER.info("Closing Completed and Cancelled Booking Tickets...");

        List<Ticket> tickets = ticketService.findTicketsReadyToClose();
        if (tickets != null && tickets.size() > 0) {
            ticketService.markTicketsAsClosed(tickets);
            LOGGER.info("Round 1: Closed [" + tickets.size() + "] Tickets.");
        }

        List<Integer> bookingIds = ticketService.findBookingIdsOfUnclosedTickets();
        if (bookingIds != null && bookingIds.size() > 0) {
            bookingIds = bookingService.getCancelledAndCompletedBookings(bookingIds);
            if (bookingIds != null && bookingIds.size() > 0) {
                tickets = ticketService.findByBookingIds(bookingIds);
                if (tickets != null && tickets.size() > 0) {
                    ticketService.markTicketsAsClosed(tickets);
                    LOGGER.info("Round 2: Closed [" + tickets.size() + "] Tickets.");
                }
            }
        }
    }
}
