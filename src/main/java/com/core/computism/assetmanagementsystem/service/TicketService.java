package com.core.computism.assetmanagementsystem.service;

import com.core.computism.assetmanagementsystem.domain.IssueDTO;
import com.core.computism.assetmanagementsystem.exception.BrainBusinessException;
import com.core.computism.assetmanagementsystem.persistence.entity.ticket.BookingInfo;
import com.core.computism.assetmanagementsystem.persistence.entity.ticket.Ticket;

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
