package com.core.computism.assasa.service;

import com.core.computism.assasa.persistence.entity.ticket.Ticket;

/**
 * Created by Venturedive on 11/26/2015.
 */
public interface TicketHistoryService {

    void logActivity(Ticket ticket);
}
