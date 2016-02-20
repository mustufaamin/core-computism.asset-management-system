package com.core.computism.assasa.service;

import com.core.computism.assasa.domain.IssueDTO;
import com.core.computism.assasa.exception.BrainBusinessException;
import com.core.computism.assasa.persistence.entity.ticket.BookingInfo;
import com.core.computism.assasa.persistence.entity.ticket.Ticket;

import java.util.List;

/**
 * Created by Venturedive on 8/18/2015.
 */
public interface TicketService {

    void persistTicket(IssueDTO issueDTO, BookingInfo bookingInfo) throws BrainBusinessException;
    List<Ticket> findTicketsReadyToAutoResolve();
    void unsnoozedTickets() throws BrainBusinessException;

    Ticket persistTicket(Ticket ticket);
    void markTicketsAsSystemResolved(List<Ticket> tickets);

    List<Integer> findBookingIdsOfUnclosedTickets();

    List<Ticket> findByBookingIds(List<Integer> bookingIds);

    void markTicketsAsClosed(List<Ticket> tickets);

    List<Ticket> findTicketsReadyToClose();
}
