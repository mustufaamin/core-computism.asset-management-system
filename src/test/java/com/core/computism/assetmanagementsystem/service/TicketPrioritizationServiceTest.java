package com.core.computism.assetmanagementsystem.service;

import com.core.computism.assetmanagementsystem.BaseUnitTest;
import com.core.computism.assetmanagementsystem.domain.type.TicketPriority;
import com.core.computism.assetmanagementsystem.persistence.entity.ticket.BookingInfo;
import com.core.computism.assetmanagementsystem.persistence.entity.ticket.ProblemType;
import com.core.computism.assetmanagementsystem.service.impl.TicketPrioritizationServiceImpl;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Spy;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.mockito.Mockito.doReturn;


/**
 * Created by Venture Dive on 9/8/2015.
 */
public class TicketPrioritizationServiceTest extends BaseUnitTest {

    @Mock private ProblemTypeService problemTypeService;

    @Spy
    @InjectMocks
    TicketPrioritizationServiceImpl ticketPrioritizationService = new TicketPrioritizationServiceImpl();

    @Test
    public void testTicketPriorityAfterCaptainArrives(){
        BookingInfo bookingInfo = getBookingInfo();
        Timestamp currentTime = getTimestamp("2015-09-30 16:00:00"); //11 min
        ProblemType problemType = getProblemType();

        doReturn(currentTime.getTime()).when(ticketPrioritizationService).getCurrentTimeInMills();
        doReturn(true).when(problemTypeService).isCriticalProblemType(problemType);

        TicketPriority result = ticketPrioritizationService.calculate(bookingInfo, problemType);
        assertThat(result, equalTo(TicketPriority.NORMAL));
    }

    /**
     * Case: Booking Status = Driver Assigned; Time to pickup < 20mins
     * Booking Type = Later, Problem Type = Critical
     */
    @Test
    public void testTicketPriorityLater_AssignedLessThan20_critical(){
        BookingInfo bookingInfo = getBookingInfo();
        bookingInfo.setBookingStatus(2);
        ProblemType problemType = getProblemType();
        Timestamp currentTime = getTimestamp("2015-09-30 16:00:00"); // < 20 min

        doReturn(currentTime.getTime()).when(ticketPrioritizationService).getCurrentTimeInMills();
        doReturn(true).when(problemTypeService).isCriticalProblemType(problemType);

        TicketPriority result = ticketPrioritizationService.calculate(bookingInfo, problemType);
        assertThat(result, equalTo(TicketPriority.CRITICAL));
    }

    /**
     * Case: Booking Status = Driver Assigned; Time to pickup < 20mins
     * Booking Type = Later, Problem Type = Non Critical
     */
    @Test
    public void testTicketPriorityLater_AssignedLessThan20_NonCritical(){
        BookingInfo bookingInfo = getBookingInfo();
        bookingInfo.setBookingStatus(2);
        ProblemType problemType = getProblemType();
        problemType.setTypeCode("CHECK_45_MINS");
        Timestamp currentTime = getTimestamp("2015-09-30 16:00:00"); // < 20 min

        doReturn(currentTime.getTime()).when(ticketPrioritizationService).getCurrentTimeInMills();
        doReturn(false).when(problemTypeService).isCriticalProblemType(problemType);

        TicketPriority result = ticketPrioritizationService.calculate(bookingInfo, problemType);
        assertThat(result, equalTo(TicketPriority.URGENT));
    }

    /**
     * Case: Booking Status = Driver Assigned; Time to pickup < 20mins
     * Booking Type = Now, Problem Type = Any
     */
    @Test
    public void testTicketPriorityNow_AssignedLessThan20(){
        BookingInfo bookingInfo = getBookingInfo();
        bookingInfo.setBookingStatus(2);
        bookingInfo.setBookingType(2);
        ProblemType problemType = getProblemType();
        Timestamp currentTime = getTimestamp("2015-09-30 16:00:00"); // < 20 min

        doReturn(currentTime.getTime()).when(ticketPrioritizationService).getCurrentTimeInMills();
        doReturn(true).when(problemTypeService).isCriticalProblemType(problemType);

        TicketPriority result = ticketPrioritizationService.calculate(bookingInfo, problemType);
        assertThat(result, equalTo(TicketPriority.URGENT));
    }

    /**
     * Case: Booking Status = Driver Assigned; Time to pickup between 20 to 120 mins
     * Booking Type = Later, Problem Type = Any
     */
    @Test
    public void testTicketPriorityLater_AssignBetween20To120(){
        BookingInfo bookingInfo = getBookingInfo();
        bookingInfo.setBookingStatus(2);
        ProblemType problemType = getProblemType();
        Timestamp currentTime = getTimestamp("2015-09-30 15:30:00"); // 20 to 120 mins

        doReturn(currentTime.getTime()).when(ticketPrioritizationService).getCurrentTimeInMills();
        doReturn(true).when(problemTypeService).isCriticalProblemType(problemType);

        TicketPriority result = ticketPrioritizationService.calculate(bookingInfo, problemType);
        assertThat(result, equalTo(TicketPriority.URGENT));
    }

    /**
     * Case: Booking Status = Driver Assigned; Time to pickup > 120
     * Booking Type = Later, Problem Type = Any
     */
    @Test
    public void testTicketPriority_AssignGreaterThan120(){
        BookingInfo bookingInfo = getBookingInfo();
        bookingInfo.setBookingStatus(2);
        ProblemType problemType = getProblemType();
        Timestamp currentTime = getTimestamp("2015-09-30 11:30:00"); // > 120 min

        doReturn(currentTime.getTime()).when(ticketPrioritizationService).getCurrentTimeInMills();
        doReturn(true).when(problemTypeService).isCriticalProblemType(problemType);

        TicketPriority result = ticketPrioritizationService.calculate(bookingInfo, problemType);
        assertThat(result, equalTo(TicketPriority.NORMAL));
    }

    private BookingInfo getBookingInfo(){
        BookingInfo bookingInfo = new BookingInfo();
        bookingInfo.setBookingStatus(4);
        bookingInfo.setPickupTime(getTimestamp("2015-09-30 16:11:00"));
        bookingInfo.setBookingType(1);

        return bookingInfo;
    }

    private Timestamp getTimestamp (String dateTime) {
        Calendar calendar = Calendar.getInstance();
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        try {
            calendar.setTime(formatter.parse(dateTime));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return new Timestamp(calendar.getTimeInMillis());
    }

    private ProblemType getProblemType() {
        ProblemType testProblemType = new ProblemType();
        testProblemType.setTypeCode("DESC");
        testProblemType.setDescr("Desc");
        testProblemType.setId(1L);
        return testProblemType;
    }

}
