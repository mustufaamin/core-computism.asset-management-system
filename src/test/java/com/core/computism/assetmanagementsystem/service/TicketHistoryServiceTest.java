package com.core.computism.assetmanagementsystem.service;

import com.core.computism.assetmanagementsystem.BaseUnitTest;
import com.core.computism.assetmanagementsystem.domain.type.TicketStatus;
import com.core.computism.assetmanagementsystem.persistence.entity.ticket.Agent;
import com.core.computism.assetmanagementsystem.persistence.entity.ticket.BookingInfo;
import com.core.computism.assetmanagementsystem.persistence.entity.ticket.ProblemType;
import com.core.computism.assetmanagementsystem.persistence.entity.ticket.Ticket;
import com.core.computism.assetmanagementsystem.persistence.entity.ticket.TicketHistory;
import com.core.computism.assetmanagementsystem.persistence.repository.ticket.TicketHistoryRepository;
import com.core.computism.assetmanagementsystem.service.impl.TicketHistoryServiceImpl;
import org.joda.time.Instant;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import java.sql.Timestamp;
import java.util.Date;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.verify;

/**
 * Created by Venturedive on 11/26/2015.
 */
public class TicketHistoryServiceTest extends BaseUnitTest {

    @Mock private TicketHistoryRepository ticketHistoryRepository;
    @Mock private AgentService agentService;

    @InjectMocks
    private TicketHistoryService ticketHistoryService = new TicketHistoryServiceImpl();

    @Test
    public void testLogActivity_NewTicket() {
        Ticket ticket = getMockTicket();
        ticket.setTicketStatus(TicketStatus.NEW);
        TicketHistory expectedHistory = getMockHistory();

        doReturn(getMockAgent()).when(agentService).getSystemAgent();
        doReturn(expectedHistory).when(ticketHistoryRepository).save(any(TicketHistory.class));

        assertThat(ticket.getTicketHistories().size(), equalTo(0));

        ticketHistoryService.logActivity(ticket);
        assertThat(ticket.getTicketHistories().size(), equalTo(1));

        TicketHistory actualHistory = ticket.getTicketHistories().iterator().next();
        assertThat(actualHistory, notNullValue());
        assertThat(actualHistory.toString(), is(expectedHistory.toString()));

        verify(ticketHistoryRepository).save(any(TicketHistory.class));
    }

    @Test
    public void testLogActivity_SystemResolvedTicket() {
        Ticket ticket = getMockTicket();
        ticket.setTicketStatus(TicketStatus.SYSTEM_RESOLVED);
        ticket.setAgent(getMockAgent());
        ticket.setResolvedDate(new Date());

        TicketHistory expectedHistory = getMockHistory();
        expectedHistory.setTicketStatusType(TicketStatus.SYSTEM_RESOLVED);

        doReturn(getMockAgent()).when(agentService).getSystemAgent();
        doReturn(expectedHistory).when(ticketHistoryRepository).save(any(TicketHistory.class));

        assertThat(ticket.getTicketHistories().size(), equalTo(0));

        ticketHistoryService.logActivity(ticket);
        assertThat(ticket.getTicketHistories().size(), equalTo(1));

        TicketHistory actualHistory = ticket.getTicketHistories().iterator().next();
        assertThat(actualHistory, notNullValue());
        assertThat(actualHistory.toString(), is(expectedHistory.toString()));

        verify(ticketHistoryRepository).save(any(TicketHistory.class));
    }

    private TicketHistory getMockHistory() {
        TicketHistory history = new TicketHistory();
        history.setTicket(getMockTicket());
        history.setTicketStatusType(TicketStatus.NEW);
        history.setChangedBy(getMockAgent());
        return history;
    }

    private Ticket getMockTicket() {
        Ticket ticket = new Ticket();
        ticket.setId(987L);
        ticket.setBookingInfo(new BookingInfo());
        ticket.getBookingInfo().setBookingId(1234);
        ticket.setRobotName("Captain Not Assigned - Dubai");
        ticket.setProblemType(getMockProblemType());

        return ticket;
    }

    private ProblemType getMockProblemType() {
        ProblemType problemType = new ProblemType();
        problemType.setId(1L);
        problemType.setTypeCode("CAPTAIN_NOT_ASSIGNED");
        problemType.setDescr("Captain Not Assigned");
        problemType.setCreationDate(new Timestamp(Instant.now().getMillis()));
        return problemType;
    }

    private Agent getMockAgent() {
        Agent agent = new Agent();
        agent.setId(11L);
        agent.setFirstName("TEST");
        agent.setLastName("SYSTEM");
        return agent;
    }
}
