package com.core.computism.assasa.service.impl;

import com.core.computism.assasa.exception.BrainBusinessException;
import com.core.computism.assasa.persistence.entity.ticket.Agent;
import com.core.computism.assasa.persistence.entity.ticket.Ticket;
import com.core.computism.assasa.persistence.entity.ticket.TicketHistory;
import com.core.computism.assasa.persistence.repository.ticket.TicketHistoryRepository;
import com.core.computism.assasa.service.AgentService;
import com.core.computism.assasa.service.TicketHistoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.PersistenceException;

/**
 * Created by Venturedive on 11/26/2015.
 */
@Service(value = "ticketHistoryService")
public class TicketHistoryServiceImpl extends BaseService implements TicketHistoryService {

    @Autowired private TicketHistoryRepository ticketHistoryRepository;
    @Autowired private AgentService agentService;

    @Override
    public void logActivity(Ticket ticket) {
        Agent changedByAgent = agentService.getSystemAgent();
        this.saveHistory(ticket, changedByAgent);
    }

    @Transactional(propagation = Propagation.REQUIRED, readOnly = false, rollbackFor = BrainBusinessException.class)
    private void saveHistory(Ticket ticket, Agent changedBy) {
        try {
            TicketHistory ticketHistory = new TicketHistory();
            ticketHistory.setTicket(ticket);
            ticketHistory.setChangedBy(changedBy);
            ticketHistory.setTicketStatus(ticket.getTicketStatus());

            ticketHistoryRepository.save(ticketHistory);
            ticket.getTicketHistories().add(ticketHistory);

        } catch (PersistenceException e) {
            new BrainBusinessException("Unable to saveHistory Ticket History for ticket Id [" + ticket.getId() + "]"
                    + "], Ticket Status [" + ticket.getTicketStatus()
                    + "], Changed By [" + changedBy.getId() + "]", e);
        }
    }
}
