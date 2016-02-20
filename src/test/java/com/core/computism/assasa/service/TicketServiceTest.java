package com.core.computism.assasa.service;

import com.core.computism.assasa.BaseUnitTest;
import com.core.computism.assasa.domain.IssueDTO;
import com.core.computism.assasa.domain.type.TicketPriority;
import com.core.computism.assasa.domain.type.TicketStatus;
import com.core.computism.assasa.exception.BrainBusinessException;
import com.core.computism.assasa.persistence.entity.ticket.Agent;
import com.core.computism.assasa.persistence.entity.ticket.BookingInfo;
import com.core.computism.assasa.persistence.entity.ticket.ProblemType;
import com.core.computism.assasa.persistence.entity.ticket.Ticket;
import com.core.computism.assasa.persistence.entity.ticket.TicketConfig;
import com.core.computism.assasa.persistence.repository.ticket.TicketRepository;
import com.core.computism.assasa.service.impl.TicketServiceImpl;
import org.hamcrest.Matchers;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Spy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.CoreMatchers.nullValue;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.hasSize;
import static org.mockito.Matchers.any;
import static org.mockito.Matchers.anyList;
import static org.mockito.Matchers.anyLong;
import static org.mockito.Matchers.anyString;
import static org.mockito.Matchers.eq;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyZeroInteractions;
import static org.mockito.Mockito.when;

/**
 * Created by Venturedive on 10/16/2015.
 */
public class TicketServiceTest extends BaseUnitTest {

    @Mock private TicketRepository ticketRepository;
    @Mock private ProblemTypeService problemTypeService;
    @Mock private TicketConfigService ticketConfigService;
    @Mock private TicketPrioritizationService ticketPrioritizationService;
    @Mock private TicketHistoryService ticketHistoryService;
    @Mock private AgentService agentService;

    @Spy
    @InjectMocks
    private TicketServiceImpl ticketService = new TicketServiceImpl();

    @Test(expected = BrainBusinessException.class)
    public void testPersistTicketIssueDTOInstanceNull() throws BrainBusinessException {
        ticketService.persistTicket(null, null);
    }

    @Test
    public void testPersistTicket_NullInstance() throws Exception {
        IssueDTO testIssueDTO = getIssueDTO();
        BookingInfo testBookingInfo = new BookingInfo();
        ProblemType testProblemType = getProblemType();
        TicketConfig config = getTicketConfig();
        Ticket expected = getTicket();

        doReturn(null).when(ticketRepository).findByProblemTypeAndBookingId(testIssueDTO.getProblemType(), testIssueDTO.getBookingId());
        doReturn(testProblemType).when(problemTypeService).getProblemTypeByCode(testIssueDTO.getProblemType());
        doReturn(config).when(ticketConfigService).findByProblemTypeAndRobot(eq(testProblemType.getId()), any(String.class));
        doNothing().when(ticketHistoryService).logActivity(any(Ticket.class));
        doReturn(TicketPriority.NORMAL).when(ticketPrioritizationService).calculate(testBookingInfo, testProblemType);
        doReturn(expected).when(ticketService).persistTicket(any(Ticket.class));

        ticketService.persistTicket(testIssueDTO, testBookingInfo);

        verify(ticketRepository, times(1)).findByProblemTypeAndBookingId(testIssueDTO.getProblemType(), testIssueDTO.getBookingId());
        verify(problemTypeService, times(1)).getProblemTypeByCode(testIssueDTO.getProblemType());
        verify(ticketConfigService, times(1)).findByProblemTypeAndRobot(testProblemType.getId(), testIssueDTO.getRobotName());
        verify(ticketHistoryService, times(1)).logActivity(any(Ticket.class));
        verify(ticketPrioritizationService, times(1)).calculate(testBookingInfo, testProblemType);
        verify(ticketService, times(2)).persistTicket(any(Ticket.class));
    }

    @Test
    public void testPersistTicket_NotNullInstance() throws Exception {
        IssueDTO testIssueDTO = getIssueDTO();
        BookingInfo testBookingInfo = new BookingInfo();
        Ticket expected = getTicket();
        ProblemType problemType = getProblemType();
        expected.setProblemType(problemType);

        doReturn(expected).when(ticketRepository).findByProblemTypeAndBookingId(testIssueDTO.getProblemType(), testIssueDTO.getBookingId());
        doReturn(TicketPriority.NORMAL).when(ticketPrioritizationService).calculate(testBookingInfo, problemType);
        doReturn(expected).when(ticketService).persistTicket(any(Ticket.class));

        ticketService.persistTicket(testIssueDTO, testBookingInfo);

        verify(ticketRepository, times(1)).findByProblemTypeAndBookingId(testIssueDTO.getProblemType(), testIssueDTO.getBookingId());
        verify(ticketPrioritizationService, times(1)).calculate(testBookingInfo, problemType);
        verifyZeroInteractions(problemTypeService);
        verifyZeroInteractions(ticketConfigService);
        verifyZeroInteractions(ticketHistoryService);
        verify(ticketService, times(1)).persistTicket(any(Ticket.class));
    }

    @Test
    public void testPersistTicket_reopenExistingNewStatus() throws Exception {
        IssueDTO testIssueDTO = getIssueDTO();
        BookingInfo testBookingInfo = new BookingInfo();
        testBookingInfo.setBookingId(1234);
        ProblemType problemType = getProblemType();
        Ticket testTicket = getTicket();
        testTicket.setProblemType(problemType);
        Ticket expected = getExpectedReopenFailedTicket(testTicket);

        doReturn(testTicket).when(ticketRepository).findByProblemTypeAndBookingId(testIssueDTO.getProblemType(),testIssueDTO.getBookingId());
        doReturn(TicketPriority.NORMAL).when(ticketPrioritizationService).calculate(testBookingInfo, problemType);
        doReturn(testTicket).when(ticketService).persistTicket(testTicket);

        ticketService.persistTicket(testIssueDTO,testBookingInfo);

        assertReopen(testTicket,expected);

        verify(ticketRepository, times(1)).findByProblemTypeAndBookingId(testIssueDTO.getProblemType(), testIssueDTO.getBookingId());
        verify(ticketPrioritizationService, times(1)).calculate(testBookingInfo, problemType);
        verify(ticketService,times(1)).persistTicket(testTicket);
        verifyZeroInteractions(problemTypeService);
        verifyZeroInteractions(ticketConfigService);
        verifyZeroInteractions(ticketHistoryService);
    }
    @Test
    public void testPersistTicket_reopenClosedTicket() throws Exception {

        IssueDTO testIssueDTO = getIssueDTO();
        BookingInfo testBookingInfo = new BookingInfo();
        testBookingInfo.setBookingId(1234);
        ProblemType problemType = getProblemType();
        Ticket testTicket = getTicket();
        testTicket.setTicketStatus(TicketStatus.CLOSED);
        testTicket.setAgent(new Agent());
        testTicket.getAgent().setId(248L);
        testTicket.setProblemType(problemType);
        Ticket expected = getExpectedReopenFailedTicket(testTicket);

        doReturn(testTicket).when(ticketRepository).findByProblemTypeAndBookingId(testIssueDTO.getProblemType(),testIssueDTO.getBookingId());
        doReturn(TicketPriority.NORMAL).when(ticketPrioritizationService).calculate(testBookingInfo, problemType);
        doReturn(testTicket).when(ticketService).persistTicket(testTicket);

        ticketService.persistTicket(testIssueDTO,testBookingInfo);

        assertReopen(testTicket,expected);

        verify(ticketRepository, times(1)).findByProblemTypeAndBookingId(testIssueDTO.getProblemType(), testIssueDTO.getBookingId());
        verify(ticketPrioritizationService, times(1)).calculate(testBookingInfo, problemType);
        verify(ticketService,times(1)).persistTicket(testTicket);
        verifyZeroInteractions(problemTypeService);
        verifyZeroInteractions(ticketConfigService);
        verifyZeroInteractions(ticketHistoryService);
    }

    @Test
    public void testPersistTicket_reopenSystemResolved() throws Exception {
        IssueDTO testIssueDTO = getIssueDTO();
        BookingInfo testBookingInfo = new BookingInfo();
        testBookingInfo.setBookingId(1234);
        ProblemType problemType = getProblemType();
        Ticket testTicket = getTicket();
        testTicket.setTicketStatus(TicketStatus.SYSTEM_RESOLVED);
        testTicket.setAgent(new Agent());
        testTicket.getAgent().setId(248L);
        testTicket.setProblemType(problemType);

        Ticket expected = getExpectedReopenSuccessTicket(testTicket);

        doReturn(testTicket).when(ticketRepository).findByProblemTypeAndBookingId(testIssueDTO.getProblemType(),testIssueDTO.getBookingId());
        doReturn(TicketPriority.NORMAL).when(ticketPrioritizationService).calculate(testBookingInfo, problemType);
        doReturn(testTicket).when(ticketService).persistTicket(testTicket);
        doNothing().when(ticketHistoryService).logActivity(testTicket);

        ticketService.persistTicket(testIssueDTO,testBookingInfo);

        assertReopen(testTicket, expected);

        verify(ticketRepository, times(1)).findByProblemTypeAndBookingId(testIssueDTO.getProblemType(), testIssueDTO.getBookingId());
        verify(ticketPrioritizationService, times(1)).calculate(testBookingInfo, problemType);
        verify(ticketService,times(1)).persistTicket(testTicket);
        verify(ticketHistoryService, times(1)).logActivity(any(Ticket.class));
        verifyZeroInteractions(problemTypeService);
        verifyZeroInteractions(ticketConfigService);
    }

    @Test
    public void testPersistTicket_reopenAgentResolvedMoreThan5Min() throws Exception {

        IssueDTO testIssueDTO = getIssueDTO();
        BookingInfo testBookingInfo = new BookingInfo();
        testBookingInfo.setBookingId(1234);
        ProblemType problemType = getProblemType();
        Ticket testTicket = getTicket();
        testTicket.setTicketStatus(TicketStatus.AGENT_RESOLVED);
        testTicket.setAgent(new Agent());
        testTicket.getAgent().setId(248L);
        testTicket.setResolvedDate(new Date(System.currentTimeMillis() - (6 * 60000))); // Resolved Date of more than 5 minutes before
        testTicket.setProblemType(problemType);
        Ticket expected = getExpectedReopenSuccessTicket(testTicket);

        doReturn(testTicket).when(ticketRepository).findByProblemTypeAndBookingId(testIssueDTO.getProblemType(),testIssueDTO.getBookingId());
        doReturn(TicketPriority.NORMAL).when(ticketPrioritizationService).calculate(testBookingInfo, problemType);
        doReturn(testTicket).when(ticketService).persistTicket(testTicket);
        doNothing().when(ticketHistoryService).logActivity(testTicket);

        ticketService.persistTicket(testIssueDTO,testBookingInfo);

        assertReopen(testTicket, expected);

        verify(ticketRepository, times(1)).findByProblemTypeAndBookingId(testIssueDTO.getProblemType(), testIssueDTO.getBookingId());
        verify(ticketPrioritizationService, times(1)).calculate(testBookingInfo, problemType);
        verify(ticketService,times(1)).persistTicket(testTicket);
        verify(ticketHistoryService, times(1)).logActivity(any(Ticket.class));
        verifyZeroInteractions(problemTypeService);
        verifyZeroInteractions(ticketConfigService);
    }

    @Test
    public void testPersistTicket_reopenAgentResolvedLessThan5Min() throws Exception {

        IssueDTO testIssueDTO = getIssueDTO();
        BookingInfo testBookingInfo = new BookingInfo();
        testBookingInfo.setBookingId(1234);
        Ticket testTicket = getTicket();

        testTicket.setTicketStatus(TicketStatus.AGENT_RESOLVED);
        testTicket.setAgent(new Agent());
        testTicket.getAgent().setId(248L);
        testTicket.setResolvedDate(new Date(System.currentTimeMillis())); // Resolved Date Equal to Now

        Ticket expected = getExpectedReopenFailedTicket(testTicket);

        doReturn(testTicket).when(ticketRepository).findByProblemTypeAndBookingId(testIssueDTO.getProblemType(),testIssueDTO.getBookingId());
        doReturn(testTicket).when(ticketService).persistTicket(testTicket);
        doNothing().when(ticketHistoryService).logActivity(testTicket);

        ticketService.persistTicket(testIssueDTO,testBookingInfo);

        assertReopen(testTicket, expected);

        verify(ticketService,times(1)).persistTicket(testTicket);
        verifyZeroInteractions(ticketHistoryService);
        verifyZeroInteractions(problemTypeService);
        verifyZeroInteractions(ticketConfigService);
    }

    @Test
    public void testPersistTicket_reopenNewTicket() throws Exception {

        IssueDTO testIssueDTO = getIssueDTO();
        BookingInfo testBookingInfo = new BookingInfo();
        testBookingInfo.setBookingId(1234);
        TicketConfig ticketConfig = getTicketConfig();
        ProblemType problemType = getProblemType();
        Ticket testTicket = getTicket();

        doReturn(null).when(ticketRepository).findByProblemTypeAndBookingId(testIssueDTO.getProblemType(),testIssueDTO.getBookingId());
        doReturn(problemType).when(problemTypeService).getProblemTypeByCode(anyString());
        doReturn(ticketConfig).when(ticketConfigService).findByProblemTypeAndRobot(anyLong(),anyString());
        doReturn(testTicket).when(ticketService).persistTicket(any(Ticket.class));

        ticketService.persistTicket(testIssueDTO,testBookingInfo);

        verify(ticketService,times(2)).persistTicket(any(Ticket.class));
        verify(problemTypeService,times(1)).getProblemTypeByCode(anyString());
        verify(ticketConfigService,times(1)).findByProblemTypeAndRobot(anyLong(),anyString());
        verify(ticketHistoryService,times(1)).logActivity(any(Ticket.class));
    }

    @Test
    public void testFindTicketsReadyToAutoExpire_NoTickets() throws Exception {
        List<Ticket> tickets = new ArrayList<>(0);
        doReturn(tickets).when(ticketRepository).findTicketsReadyToAutoResolve();

        List<Ticket> actualList = ticketService.findTicketsReadyToAutoResolve();
        assertThat(actualList, hasSize(0));
        verify(ticketRepository, times(1)).findTicketsReadyToAutoResolve();
    }

    @Test
    public void testFindTicketsReadyToAutoExpire_WithTickets() throws Exception {
        List<Ticket> tickets = Arrays.asList(getTicket());
        doReturn(tickets).when(ticketRepository).findTicketsReadyToAutoResolve();

        List<Ticket> actualList = ticketService.findTicketsReadyToAutoResolve();
        assertThat(actualList, hasSize(1));
        verify(ticketRepository, times(1)).findTicketsReadyToAutoResolve();
    }

    @Test
    public void testFindTicketsReadyToClose_NoTickets() throws Exception {
        List<Ticket> tickets = new ArrayList<>(0);
        doReturn(tickets).when(ticketRepository).findTicketsReadyToClose();

        List<Ticket> actualList = ticketService.findTicketsReadyToClose();
        assertThat(actualList, hasSize(0));
        verify(ticketRepository, times(1)).findTicketsReadyToClose();
    }

    @Test
    public void testFindTicketsReadyToClose_WithTickets() throws Exception {
        List<Ticket> tickets = Arrays.asList(getTicket());
        doReturn(tickets).when(ticketRepository).findTicketsReadyToClose();

        List<Ticket> actualList = ticketService.findTicketsReadyToClose();
        assertThat(actualList, hasSize(1));
        verify(ticketRepository, times(1)).findTicketsReadyToClose();
    }

    @Test
    public void testPersistTicket() throws Exception {
        Ticket testTicket = getTicket();
        doReturn(testTicket).when(ticketRepository).save(testTicket);
        assertThat(testTicket.getLastModifiedDate(), nullValue());

        ticketService.persistTicket(testTicket);
        assertThat(testTicket.getLastModifiedDate(), notNullValue());
        verify(ticketRepository, times(1)).save(testTicket);
    }

    @Test
    public void testMarkTicketsAsSystemResolved() throws Exception {
        Ticket testTicket = getTicket();
        List<Ticket> tickets = Arrays.asList(testTicket);

        doReturn(getMockAgent()).when(agentService).getSystemAgent();
        doNothing().when(ticketHistoryService).logActivity(any(Ticket.class));
        doReturn(testTicket).when(ticketRepository).save(testTicket);

        Ticket expected = getTicket();
        expected.setTicketStatus(TicketStatus.SYSTEM_RESOLVED);
        expected.setAgent(getMockAgent());
        expected.setResolvedDate(new Date());
        expected.setLastModifiedDate(new Date());

        ticketService.markTicketsAsSystemResolved(tickets);
        Ticket actual = tickets.get(0);

        assertThat(actual.getTicketStatus(), equalTo(expected.getTicketStatus()));
        assertThat(actual.getAgent().getId(), Matchers.equalTo(expected.getAgent().getId()));
        assertThat(actual.getResolvedDate(), notNullValue());
        assertThat(actual.getLastModifiedDate(), notNullValue());

        verify(agentService, times(1)).getSystemAgent();
        verify(ticketHistoryService, times(1)).logActivity(any(Ticket.class));
        verify(ticketRepository, times(1)).save(testTicket);
    }

    @Deprecated
    @Test(expected = BrainBusinessException.class)
    public void testUnsnoozedTicketsWithNoTicketsInstance() throws BrainBusinessException {
        List<Ticket> testTicket = new ArrayList<>(0);
        when(ticketRepository.findTicketsToUnsnoozed()).thenReturn(testTicket);
        ticketService.unsnoozedTickets();
    }

    @Deprecated
    @Test
    public void testUnsnoozedTickets() throws Exception {
        List<Ticket> tickets = new ArrayList<>();
        Ticket testTicket = getTicket();
        tickets.add(testTicket);
        when(ticketRepository.findTicketsToUnsnoozed()).thenReturn(tickets);
        ticketService.unsnoozedTickets();
        verify(ticketService, times(1)).persistTicket(testTicket);

    }

    private Agent getMockAgent() {
        Agent agent = new Agent();
        agent.setId(11L);
        agent.setFirstName("TEST");
        agent.setLastName("SYSTEM");
        return agent;
    }

    @Test
    public void testFindBookingIdsOfTicketsToClose_NoTickets() throws Exception {

        List<Integer> bookingIds = new ArrayList<>(0);
        doReturn(bookingIds).when(ticketRepository).findBookingIdsOfUnclosedTickets();

        List<Integer> actualList = ticketService.findBookingIdsOfUnclosedTickets();
        assertThat(actualList, hasSize(0));
        verify(ticketRepository, times(1)).findBookingIdsOfUnclosedTickets();

    }

    @Test
    public void testFindBookingIdsOfTicketsToClose_WithTickets() throws Exception {

        List<Integer> bookingIds = Arrays.asList(124145);
        doReturn(bookingIds).when(ticketRepository).findBookingIdsOfUnclosedTickets();

        List<Integer> actualList = ticketService.findBookingIdsOfUnclosedTickets();
        assertThat(actualList, hasSize(1));
        verify(ticketRepository, times(1)).findBookingIdsOfUnclosedTickets();
    }


    @Test
    public void testFindTicketByBookingIds_IfEmptyPassed(){
        List<Integer> bookingIds = new ArrayList<>(0);
        List<Ticket> tickets = new ArrayList<>(0);

        doReturn(tickets).when(ticketRepository).findByBookingId(bookingIds);
        List<Ticket> result = ticketService.findByBookingIds(bookingIds);

        assertThat(result, Matchers.equalTo(tickets));
    }

    @Test
    public void testFindTicketByBookingIdsIfTicketExist(){

        List<Integer> bookingIds = Arrays.asList(124145);
        List<Ticket> tickets = new ArrayList<>();
        Ticket ticket = new Ticket();

        ticket.setBookingInfo(new BookingInfo());
        ticket.getBookingInfo().setBookingId(124145);

        tickets.add(ticket);

        Ticket expected = new Ticket();
        expected.setBookingInfo(new BookingInfo());
        expected.getBookingInfo().setBookingId(124145);

        doReturn(tickets).when(ticketRepository).findByBookingId(bookingIds);
        List<Ticket> result = ticketService.findByBookingIds(bookingIds);

        Ticket actual = result.get(0);

        assertThat(actual.getBookingInfo().getBookingId(), Matchers.equalTo(expected.getBookingInfo().getBookingId()));

        verify(ticketRepository,times(1)).findByBookingId(anyList());
    }

    @Test
    public void testFindTicketByBookingIdsIfTicketNotExist(){

        List<Integer> bookingIds = Arrays.asList(124145);
        List<Ticket> tickets = new ArrayList<>(0);

        doReturn(tickets).when(ticketRepository).findByBookingId(bookingIds);
        List<Ticket> result = ticketService.findByBookingIds(bookingIds);

        assertThat(result, hasSize(0));
        verify(ticketRepository,times(1)).findByBookingId(bookingIds);

    }

    @Test
    public void testMarkTicketsAsClosed()  {
        Ticket ticket = getTicket();
        ticket.setProblemType(getProblemType());
        List<Ticket> tickets = Arrays.asList(ticket);

        doNothing().when(ticketHistoryService).logActivity(ticket);
        doReturn(ticket).when(ticketRepository).save(ticket);

        Ticket expected = new Ticket();
        expected.setTicketStatus(TicketStatus.CLOSED);
        expected.setLastModifiedDate(new Date());

        ticketService.markTicketsAsClosed(tickets);

        Ticket resultTicket = tickets.get(0);

        assertThat(resultTicket.getTicketStatus(), is(expected.getTicketStatus()));
        assertThat(resultTicket.getLastModifiedDate(), notNullValue());

        verify(ticketService, times(1)).persistTicket(ticket);
    }

    @Test
    public void testMarkTicketsAsClosed_CaptainNeedsHelp()  {
        Ticket ticket = getTicket();
        ticket.setProblemType(getProblemType());
        ticket.getProblemType().setTypeCode("CAPTAIN_NEEDS_HELP");

        List<Ticket> tickets = Arrays.asList(ticket);

        doNothing().when(ticketHistoryService).logActivity(ticket);
        doReturn(ticket).when(ticketRepository).save(ticket);

        ticketService.markTicketsAsClosed(tickets);

        Ticket resultTicket = tickets.get(0);

        assertThat(resultTicket.getTicketStatusType(), is(TicketStatus.NEW));
        assertThat(resultTicket.getLastModifiedDate(), nullValue());

        verify(ticketService, times(0)).persistTicket(ticket);
    }

    private IssueDTO getIssueDTO() {
        IssueDTO issueDTO = new IssueDTO();
        issueDTO.setBookingId(215);
        issueDTO.setProblemType("SomeProblemType");
        issueDTO.setRobotName("Test Problem");
        return issueDTO;
    }

    private Ticket getTicket() {
        Ticket ticket = new Ticket();
        ticket.setId(215L);
        ticket.setTicketStatus(TicketStatus.NEW);
        ticket.setVersion(0L);
        ticket.setBookingInfo(new BookingInfo());
        ticket.getBookingInfo().setBookingId(123);

        return ticket;
    }


    private TicketConfig getTicketConfig() {
        TicketConfig config = new TicketConfig();
        config.setActionRequired("Action");
        Integer autoExpireMin = new Integer(15);
        config.setAutoExpireMin(autoExpireMin);
        return config;
    }

    private ProblemType getProblemType() {
        ProblemType testProblemType = new ProblemType();
        testProblemType.setTypeCode("DESC");
        testProblemType.setDescr("Desc");
        testProblemType.setId(1L);
        return testProblemType;
    }

    private Ticket getExpectedReopenSuccessTicket(Ticket ticket){
        Ticket expected = new Ticket();

        expected.setId(ticket.getId());
        expected.setAgent(null);
        expected.setTicketStatus(TicketStatus.NEW);
        expected.setResolvedDate(null);
        expected.setAcceptedDate(null);
        expected.setAssignedDate(null);
        return expected;
    }
    private Ticket getExpectedReopenFailedTicket(Ticket ticket){
        Ticket expected = new Ticket();

        expected.setId(ticket.getId());
        expected.setAgent(ticket.getAgent());
        expected.setTicketStatus(ticket.getTicketStatusType());
        expected.setResolvedDate(ticket.getResolvedDate());
        expected.setAssignedDate(ticket.getAssignedDate());
        expected.setAcceptedDate(ticket.getAcceptedDate());
        return expected;
    }
    private void assertReopen(Ticket actual,Ticket expected){

        assertThat(actual.getTicketStatusType(),equalTo(expected.getTicketStatusType()));
        assertThat(actual.getAgent(), equalTo(expected.getAgent()));
        assertThat(actual.getResolvedDate(), equalTo(expected.getResolvedDate()));
        assertThat(actual.getAssignedDate(), equalTo(expected.getAssignedDate()));
        assertThat(actual.getAcceptedDate(), equalTo(expected.getAcceptedDate()));

    }

}
