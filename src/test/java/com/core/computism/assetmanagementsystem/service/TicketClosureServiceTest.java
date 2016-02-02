package com.core.computism.assetmanagementsystem.service;

import com.core.computism.assetmanagementsystem.BaseUnitTest;
import com.core.computism.assetmanagementsystem.domain.type.TicketStatus;
import com.core.computism.assetmanagementsystem.persistence.entity.ticket.BookingInfo;
import com.core.computism.assetmanagementsystem.persistence.entity.ticket.ProblemType;
import com.core.computism.assetmanagementsystem.persistence.entity.ticket.Ticket;
import com.core.computism.assetmanagementsystem.service.impl.TicketClosureServiceImpl;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyZeroInteractions;


/**
 * Created by M.Mustafa Amin Shah on 11/26/2015.
 */
public class TicketClosureServiceTest extends BaseUnitTest {

    @Mock
    private TicketService ticketService;
    @Mock
    private BookingDetailService bookingService;

    @InjectMocks
    private TicketClosureService ticketClosureService = new TicketClosureServiceImpl();

    @Test
    public void testCloseTicket_NoUnclosedTicket(){
        List<Ticket> tickets = new ArrayList<>(0);
        List<Integer> bookingIds = new ArrayList<>(0);

        doReturn(tickets).when(ticketService).findTicketsReadyToClose();
        doReturn(bookingIds).when(ticketService).findBookingIdsOfUnclosedTickets();
        doReturn(bookingIds).when(bookingService).getCancelledAndCompletedBookings(bookingIds);
        doReturn(tickets).when(ticketService).findByBookingIds(bookingIds);
        doNothing().when(ticketService).markTicketsAsClosed(tickets);

        ticketClosureService.closeTicket();

        verify(ticketService, times(1)).findTicketsReadyToClose();
        verify(ticketService, times(1)).findBookingIdsOfUnclosedTickets();
        verifyZeroInteractions(bookingService);
        verify(ticketService, times(0)).findByBookingIds(bookingIds);
        verify(ticketService, times(0)).markTicketsAsClosed(tickets);
    }

    @Test
    public void testCloseTicket_WithUnclosedTicketAndEndedBookings(){
        List<Integer> openTicketsBookingIds = Arrays.asList(123, 235, 2135);
        List<Integer> closeEndedBookingIds = Arrays.asList(123,235);
        List<Ticket> tickets = getTickets();

        doReturn(tickets).when(ticketService).findTicketsReadyToClose();
        doReturn(openTicketsBookingIds).when(ticketService).findBookingIdsOfUnclosedTickets();
        doReturn(closeEndedBookingIds).when(bookingService).getCancelledAndCompletedBookings(openTicketsBookingIds);
        doReturn(tickets).when(ticketService).findByBookingIds(closeEndedBookingIds);
        doNothing().when(ticketService).markTicketsAsClosed(tickets);

        ticketClosureService.closeTicket();

        verify(ticketService, times(1)).findTicketsReadyToClose();
        verify(ticketService, times(1)).findBookingIdsOfUnclosedTickets();
        verify(bookingService, times(1)).getCancelledAndCompletedBookings(openTicketsBookingIds);
        verify(ticketService, times(1)).findByBookingIds(closeEndedBookingIds);
        verify(ticketService, times(2)).markTicketsAsClosed(tickets);
    }

    @Test
    public void testCloseTicket_WithUnclosedTicketAndActiveBookings(){
        List<Integer> openTicketsBookingIds = Arrays.asList(123, 235, 2135);
        List<Integer> closeEndedBookingIds = new ArrayList<>(0);
        List<Ticket> tickets = getTickets();

        doReturn(tickets).when(ticketService).findTicketsReadyToClose();
        doReturn(openTicketsBookingIds).when(ticketService).findBookingIdsOfUnclosedTickets();
        doReturn(closeEndedBookingIds).when(bookingService).getCancelledAndCompletedBookings(openTicketsBookingIds);
        doReturn(tickets).when(ticketService).findByBookingIds(closeEndedBookingIds);
        doNothing().when(ticketService).markTicketsAsClosed(tickets);

        ticketClosureService.closeTicket();

        verify(ticketService, times(1)).findTicketsReadyToClose();
        verify(ticketService, times(1)).findBookingIdsOfUnclosedTickets();
        verify(bookingService, times(1)).getCancelledAndCompletedBookings(openTicketsBookingIds);
        verify(ticketService, times(0)).findByBookingIds(closeEndedBookingIds);
        verify(ticketService, times(1)).markTicketsAsClosed(tickets);
    }

    private Ticket getTicket(Integer bookingId){
        Ticket ticket =  new Ticket();
        ticket.setBookingInfo(new BookingInfo());
        ticket.getBookingInfo().setBookingId(bookingId);
        ticket.setProblemType(getProblemType());
        ticket.setRobotName("Captain Not Assigned - Dubai");
        ticket.setTicketStatus(TicketStatus.NEW);
        return ticket;
    }

    private ProblemType getProblemType(){
        ProblemType problemType = new ProblemType();
        problemType.setId(125L);
        problemType.setTypeCode("CAPTAIN_NOT_ASSIGNED");
        problemType.setDescr("Captain Not Assigned");
        problemType.setCreationDate(new Date());
        return problemType;
    }

    private List<Ticket> getTickets(){
        Ticket ticket1 = getTicket(123);
        Ticket ticket2 = getTicket(235);
        return Arrays.asList(ticket1, ticket2);
    }
}
