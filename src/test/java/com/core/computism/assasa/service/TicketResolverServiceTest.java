package com.core.computism.assasa.service;

import com.core.computism.assasa.BaseUnitTest;
import com.core.computism.assasa.domain.IssueDTO;
import com.core.computism.assasa.gateway.ProblemIdentifierGateway;
import com.core.computism.assasa.persistence.entity.ticket.BookingInfo;
import com.core.computism.assasa.persistence.entity.ticket.ProblemType;
import com.core.computism.assasa.persistence.entity.ticket.Ticket;
import com.core.computism.assasa.service.impl.TicketResolverServiceImpl;
import org.joda.time.Instant;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.mockito.Matchers.anyList;
import static org.mockito.Matchers.anyListOf;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;


/**
 * Created by Venture Dive on 9/21/2015.
 */
public class TicketResolverServiceTest extends BaseUnitTest {

    @Mock private TicketService ticketService;
    @Mock private ProblemIdentifierGateway problemIdentifierGateway;
    @Mock private BookingDetailService bookingService;

    @InjectMocks
    private TicketResolverService ticketResolverService = new TicketResolverServiceImpl();

    @Test
    public void testAutoExpireTicket_NoValidProblem(){
        List<Ticket> testTickets = getTickets();
        List<IssueDTO> testIssues = new ArrayList<>(0);

        doReturn(testTickets).when(ticketService).findTicketsReadyToAutoResolve();
        doReturn(testIssues).when(problemIdentifierGateway).verifyIssues(anyListOf(IssueDTO.class));

        ticketResolverService.autoResolveTickets();
        verify(ticketService, times(1)).markTicketsAsSystemResolved(anyListOf(Ticket.class));
    }

    @Test
    public void testAutoExpireTicket_FewValidProblems(){
        List<Ticket> testTickets = getTickets();
        List<IssueDTO> testIssues = Arrays.asList(getIssues().get(1));

        doReturn(testTickets).when(ticketService).findTicketsReadyToAutoResolve();
        doReturn(testIssues).when(problemIdentifierGateway).verifyIssues(anyListOf(IssueDTO.class));

        ticketResolverService.autoResolveTickets();
        verify(ticketService, times(1)).markTicketsAsSystemResolved(anyListOf(Ticket.class));
    }

    @Test
    public void testAutoExpireTicket_AllValidProblems(){
        List<Ticket> testTickets = getTickets();
        List<IssueDTO> testIssues = getIssues();

        doReturn(testTickets).when(ticketService).findTicketsReadyToAutoResolve();
        doReturn(testIssues).when(problemIdentifierGateway).verifyIssues(anyListOf(IssueDTO.class));

        ticketResolverService.autoResolveTickets();
        verify(ticketService, times(0)).markTicketsAsSystemResolved(anyListOf(Ticket.class));
    }


    @Test
    public void testValidCaseWithCancelStatus(){
        List<Ticket> tickets = getTickets();
        List<IssueDTO> issues = new ArrayList<>(0);
        List<Integer> cancelledBookingIds = Arrays.asList(5678);

        tickets.get(1).getBookingInfo().setBookingStatus(7);

        List<Ticket> ticketsRemovedCancelledBooking = new ArrayList<>(tickets);

        for(Ticket ticket: tickets){
            if(cancelledBookingIds.contains(ticket.getBookingInfo().getBookingId())){
                ticketsRemovedCancelledBooking.remove(ticket);
            }
        }

        doReturn(tickets).when(ticketService).findTicketsReadyToAutoResolve();
        doReturn(issues).when(problemIdentifierGateway).verifyIssues(anyListOf(IssueDTO.class));
        doReturn(cancelledBookingIds).when(bookingService).getCancelledAndCompletedBookings(anyList());

        ticketResolverService.autoResolveTickets();

        verify(ticketService, times(1)).markTicketsAsSystemResolved(ticketsRemovedCancelledBooking);
    }

    private List<Ticket> getTickets() {
        Ticket ticket1 = new Ticket();
        ticket1.setBookingInfo(new BookingInfo());
        ticket1.getBookingInfo().setBookingId(1234);
        ticket1.setRobotName("Captain Not Assigned - Dubai");
        ticket1.setProblemType(getProblemType1());

        Ticket ticket2 = new Ticket();
        ticket2.setBookingInfo(new BookingInfo());
        ticket2.getBookingInfo().setBookingId(5678);
        ticket2.setRobotName("Captain Not Assigned - Dubai");
        ticket2.setProblemType(getProblemType1());

        Ticket ticket3 = new Ticket();
        ticket3.setBookingInfo(new BookingInfo());
        ticket3.getBookingInfo().setBookingId(1234);
        ticket3.setRobotName("45 mins Check");
        ticket3.setProblemType(getProblemType2());

        return Arrays.asList(ticket1, ticket2, ticket3);
    }
    private List<IssueDTO> getIssues() {
        IssueDTO issueDTO1 = new IssueDTO();
        issueDTO1.setBookingId(1234);
        issueDTO1.setRobotName("Captain Not Assigned - Dubai");
        issueDTO1.setProblemType("CAPTAIN_NOT_ASSIGNED");

        IssueDTO issueDTO2 = new IssueDTO();
        issueDTO2.setBookingId(5678);
        issueDTO2.setRobotName("Captain Not Assigned - Dubai");
        issueDTO2.setProblemType("CAPTAIN_NOT_ASSIGNED");

        IssueDTO issueDTO3 = new IssueDTO();
        issueDTO3.setBookingId(1234);
        issueDTO3.setRobotName("45 mins Check");
        issueDTO3.setProblemType("CHECK_45_MINS");

        return Arrays.asList(issueDTO1, issueDTO2, issueDTO3);
    }

    private ProblemType getProblemType1() {
        ProblemType problemType = new ProblemType();
        problemType.setId(1L);
        problemType.setTypeCode("CAPTAIN_NOT_ASSIGNED");
        problemType.setDescr("Captain Not Assigned");
        problemType.setCreationDate(new Timestamp(Instant.now().getMillis()));
        return problemType;
    }

    private ProblemType getProblemType2() {
        ProblemType problemType = new ProblemType();
        problemType.setId(2L);
        problemType.setTypeCode("CHECK_45_MINS");
        problemType.setDescr("45 mins Check");
        problemType.setCreationDate(new Timestamp(Instant.now().getMillis()));
        return problemType;
    }
}
