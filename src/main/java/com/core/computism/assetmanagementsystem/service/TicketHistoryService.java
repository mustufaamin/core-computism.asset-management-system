package com.core.computism.assetmanagementsystem.service;

import com.core.computism.assetmanagementsystem.persistence.entity.ticket.Ticket;

/**
 * Created by Venturedive on 11/26/2015.
 */
public interface TicketHistoryService {

    void logActivity(Ticket ticket);
}
