package com.core.computism.assetmanagementsystem.service.impl;

import com.core.computism.assetmanagementsystem.domain.IssueDTO;
import com.core.computism.assetmanagementsystem.gateway.ProblemIdentifierGateway;
import com.core.computism.assetmanagementsystem.persistence.entity.ticket.Ticket;
import com.core.computism.assetmanagementsystem.service.BookingDetailService;
import com.core.computism.assetmanagementsystem.service.TicketResolverService;
import com.core.computism.assetmanagementsystem.service.TicketService;
import com.core.computism.assetmanagementsystem.util.builder.IssueBuilder;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Venturedive on 9/10/2015.
 */
@Service(value = "ticketResolverService")
public class TicketResolverServiceImpl implements TicketResolverService {

    private static final Logger LOGGER = Logger.getLogger(TicketResolverServiceImpl.class);

    @Autowired private ProblemIdentifierGateway problemIdentifierGateway;

    @Autowired private TicketService ticketService;

    @Autowired private BookingDetailService bookingService;

    @Override
    @Transactional
    public void autoResolveTickets() {
        LOGGER.info("Auto-Resolving Tickets...");
        IssueBuilder issueBuilder = new IssueBuilder();

        List<Ticket> tickets = ticketService.findTicketsReadyToAutoResolve();
        List<IssueDTO> issues = issueBuilder.buildIssuesFromTickets(tickets);
        List<IssueDTO> problemIssues = problemIdentifierGateway.verifyIssues(issues);

        List<Ticket> autoExpireTickets = new ArrayList<>(tickets);
        if (problemIssues != null && problemIssues.size() > 0) {
            for (IssueDTO problemIssue : problemIssues) {
                for (int i = 0; i < autoExpireTickets.size(); i++) {
                    Ticket ticket = autoExpireTickets.get(i);
                    if (isTicketMatched(ticket, problemIssue)) {
                        autoExpireTickets.remove(i);
                        break;
                    }
                }
            }
        }


        if(autoExpireTickets.size()>0) {
            /*Remove tickets from the autoresolve List where booking of ticket is Ended or Cancelled*/
            autoExpireTickets = checkResolvedAndCancelledBookings(autoExpireTickets);
            if (autoExpireTickets.size() > 0) {
                ticketService.markTicketsAsSystemResolved(autoExpireTickets);
            }
        }
        LOGGER.info("Marked [" + autoExpireTickets.size() + "] Tickets as System Resolved.");
    }

    private boolean isTicketMatched(Ticket ticket, IssueDTO problemIssue) {

        return (ticket.getBookingInfo().getBookingId().intValue() == problemIssue.getBookingId().intValue()
                && ticket.getRobotName().equals(problemIssue.getRobotName())
                && ticket.getProblemType().getTypeCode().equals(problemIssue.getProblemType()));
    }

    private List<Ticket> checkResolvedAndCancelledBookings(List<Ticket> ticketsToResolve){

        List<Integer> bookingIds = new ArrayList<>();
        List<Ticket> resultTickets = new ArrayList<>(ticketsToResolve);

        for (Ticket ticket : ticketsToResolve) {
            bookingIds.add(ticket.getBookingInfo().getBookingId());
        }
        bookingIds = bookingService.getCancelledAndCompletedBookings(bookingIds);

        if (bookingIds.size() > 0) {
            for (Ticket ticket : ticketsToResolve) {
                if (bookingIds.contains(ticket.getBookingInfo().getBookingId())) {
                    resultTickets.remove(ticket);
                }
            }
        }

        return resultTickets;

    }



}
