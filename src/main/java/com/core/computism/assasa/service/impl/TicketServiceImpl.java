package com.core.computism.assasa.service.impl;

import com.core.computism.assasa.domain.IssueDTO;
import com.core.computism.assasa.domain.type.TicketStatus;
import com.core.computism.assasa.exception.BrainBusinessException;
import com.core.computism.assasa.persistence.entity.ticket.BookingInfo;
import com.core.computism.assasa.persistence.entity.ticket.ProblemType;
import com.core.computism.assasa.persistence.entity.ticket.Ticket;
import com.core.computism.assasa.persistence.entity.ticket.TicketConfig;
import com.core.computism.assasa.persistence.repository.ticket.TicketRepository;
import com.core.computism.assasa.service.AgentService;
import com.core.computism.assasa.service.ProblemTypeService;
import com.core.computism.assasa.service.TicketConfigService;
import com.core.computism.assasa.service.TicketHistoryService;
import com.core.computism.assasa.service.TicketPrioritizationService;
import com.core.computism.assasa.service.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.PersistenceException;
import java.util.Date;
import java.util.List;

/**
 * Created by Venturedive on 8/18/2015.
 */
@Service(value = "ticketService")
public class TicketServiceImpl extends BaseService implements TicketService {

    @Autowired private TicketRepository ticketRepository;
    @Autowired private ProblemTypeService problemTypeService;
    @Autowired private TicketConfigService ticketConfigService;
    @Autowired private TicketPrioritizationService ticketPrioritizationService;
    @Autowired private TicketHistoryService ticketHistoryService;
    @Autowired private AgentService agentService;


    @Override
    @Transactional(propagation = Propagation.REQUIRED, readOnly = false, rollbackFor = BrainBusinessException.class)
    public void persistTicket(IssueDTO issueDTO, BookingInfo bookingInfo) throws BrainBusinessException {
        if (issueDTO == null) {
            throw new BrainBusinessException("Unable to persist Ticket");
        }
        Ticket ticketInstance = ticketRepository.findByProblemTypeAndBookingId(issueDTO.getProblemType(), issueDTO.getBookingId());
        try {
            if (ticketInstance == null) {
                ticketInstance = createTicket(issueDTO, bookingInfo);
                ticketHistoryService.logActivity(ticketInstance);
            } else {
                ticketInstance.setTicketPriority(ticketPrioritizationService.calculate(bookingInfo, ticketInstance.getProblemType()));

                if(ticketInstance.getTicketStatus() > 4) {
                    reopenTicket(ticketInstance);
                }
            }

            ticketInstance = persistTicket(ticketInstance);
            logger.debug("Saved Ticket with id [" + ticketInstance.getId() + "]");
        } catch (PersistenceException e) {
            throw new BrainBusinessException("Unable to save Ticket for booking Id [" + issueDTO.getBookingId() + "]", e);
        }
    }

    private Ticket createTicket(IssueDTO issueDTO, BookingInfo bookingInfo) {
        Ticket ticketInstance = new Ticket();
        ticketInstance.setBookingInfo(bookingInfo);
        ticketInstance.setRobotName(issueDTO.getRobotName());

        ProblemType problemType = problemTypeService.getProblemTypeByCode(issueDTO.getProblemType());
        ticketInstance.setProblemType(problemType);

        ticketInstance.setTicketStatus(TicketStatus.NEW);
        ticketInstance.setTitle(problemType.getDescr());

        TicketConfig config = ticketConfigService.findByProblemTypeAndRobot(problemType.getId(), ticketInstance.getRobotName());
        ticketInstance.setActionRequired(config.getActionRequired());
        ticketInstance.setAutoExpireMin(config.getAutoExpireMin());

        ticketInstance.setTicketPriority(ticketPrioritizationService.calculate(bookingInfo, problemType));

        ticketInstance = persistTicket(ticketInstance);
        return ticketInstance;
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, readOnly = true)
    public List<Ticket> findTicketsReadyToAutoResolve() {
        return ticketRepository.findTicketsReadyToAutoResolve();
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, readOnly = false, rollbackFor = BrainBusinessException.class)
    public Ticket persistTicket(Ticket ticket) {
        ticket.setLastModifiedDate(new Date()); // to assure we have this updated to help with Auto-resolution
        return ticketRepository.save(ticket);
    }

    @Override
    public void markTicketsAsSystemResolved(List<Ticket> tickets) {
        for (Ticket ticket : tickets) {
            ticket.setAgent(agentService.getSystemAgent());
            ticket.setTicketStatus(TicketStatus.SYSTEM_RESOLVED);
            ticket.setResolvedDate(new Date());

            ticketHistoryService.logActivity(ticket);
            persistTicket(ticket);
        }
    }

    @Deprecated
    public void unsnoozedTickets() throws BrainBusinessException {
        List<Ticket> ticketInstances = ticketRepository.findTicketsToUnsnoozed();

        if(!(ticketInstances.size() > 0)){
            throw new BrainBusinessException("No Tickets to snooze");
        }
        try{
            for(Ticket ticket : ticketInstances){
                // TODO: Should set the last ticket state from history
                ticket.setSnoozedMin(null);
                persistTicket(ticket);
            }
        } catch (PersistenceException e){
            throw new BrainBusinessException("Unexpected Error Occurred",e);
        }
    }


    @Override
    @Transactional(propagation = Propagation.REQUIRED, readOnly = true)
    public List<Integer> findBookingIdsOfUnclosedTickets() {
        return ticketRepository.findBookingIdsOfUnclosedTickets();
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, readOnly = true)
    public List<Ticket> findByBookingIds(List<Integer> bookingIds) {
        return ticketRepository.findByBookingId(bookingIds);
    }

    @Override
    public void markTicketsAsClosed(List<Ticket> tickets) {
        for(Ticket ticket: tickets){
            if (isAutoCloseEnabled(ticket.getProblemType().getTypeCode())) {
                ticket.setTicketStatus(TicketStatus.CLOSED);
                ticketHistoryService.logActivity(ticket);
                persistTicket(ticket);
            }
        }
    }

    private boolean isAutoCloseEnabled(String problemTypeCode) {
        if ("CAPTAIN_NEEDS_HELP".equals(problemTypeCode)) {
            return false;
        }
        return true;
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, readOnly = true)
    public List<Ticket> findTicketsReadyToClose() {
        return ticketRepository.findTicketsReadyToClose();
    }
    private void reopenTicket(Ticket ticket) {
        if (TicketStatus.SYSTEM_RESOLVED == ticket.getTicketStatusType() ) {
          doReopen(ticket);
        } else if ( TicketStatus.AGENT_RESOLVED == ticket.getTicketStatusType() || TicketStatus.FALSE_ALARM ==ticket.getTicketStatusType()) {
            long dateDiffInMinutes = (System.currentTimeMillis() - ticket.getResolvedDate().getTime()) / 60000;
            if (dateDiffInMinutes > 5) {
               doReopen(ticket);
            }
        }
    }

    private void doReopen(Ticket ticket){
        ticket.setTicketStatus(TicketStatus.NEW);
        ticket.setAgent(null);
        ticket.setResolvedDate(null);
        ticket.setAssignedDate(null);
        ticket.setAcceptedDate(null);

        ticketHistoryService.logActivity(ticket);
    }
}
