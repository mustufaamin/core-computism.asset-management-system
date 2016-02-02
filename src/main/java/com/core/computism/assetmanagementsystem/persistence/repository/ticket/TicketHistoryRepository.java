package com.core.computism.assetmanagementsystem.persistence.repository.ticket;

import com.core.computism.assetmanagementsystem.persistence.entity.ticket.TicketHistory;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by Venturedive on 11/27/2015.
 */
public interface TicketHistoryRepository extends JpaRepository<TicketHistory, Long> {
}
