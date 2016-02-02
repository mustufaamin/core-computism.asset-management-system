package com.core.computism.assetmanagementsystem.service;

import com.core.computism.assetmanagementsystem.BaseUnitTest;
import com.core.computism.assetmanagementsystem.persistence.entity.booking.BookingDetail;
import com.core.computism.assetmanagementsystem.persistence.entity.booking.BookingWaypoint;
import com.core.computism.assetmanagementsystem.persistence.repository.booking.BookingRepository;
import com.core.computism.assetmanagementsystem.service.impl.BookingDetailServiceImpl;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Spy;

import java.util.*;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.hasKey;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.hasSize;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.times;


/**
 * Created by Venturedive on 8/25/2015.
 */
public class BookingDetailServiceTest extends BaseUnitTest {

    @Mock
    private BookingRepository bookingRepository;

    @Spy
    @InjectMocks
    private BookingDetailService bookingDetailService = new BookingDetailServiceImpl();

    @Mock
    Calendar calendar;

    @Test
    public void testFindByBookingIds() {
        List<Integer> bookingIds = Arrays.asList(123, 456);
        List<BookingDetail> expected = Arrays.asList(getBookingDetail(123), getBookingDetail(456));

        doReturn(expected).when(bookingRepository).getBookingDetail(bookingIds);

        HashMap<Integer, BookingDetail> actual = bookingDetailService.findByBookingIds(bookingIds);
        assertThat(actual.size(), equalTo(bookingIds.size()));
        assertThat(actual, hasKey(bookingIds.get(0)));
        assertThat(actual, hasKey(bookingIds.get(1)));

        verify(bookingRepository, times(1)).getBookingDetail(bookingIds);
    }

    @Test
    public void testFindByBookingIdsWithWaypoints() {
        List<Integer> bookingIds = Arrays.asList(123);
        /*With Waypoints*/
        List<BookingDetail> expected = Arrays.asList(getBookingDetailWithWaypoints(123));

        List<BookingWaypoint> waypoints = Arrays.asList(getBookingWaypoints(123));


        doReturn(expected).when(bookingRepository).getBookingDetail(bookingIds);
        doReturn(waypoints).when(bookingRepository).getBookingWaypoints(bookingIds.get(0));


        HashMap<Integer, BookingDetail> actual = bookingDetailService.findByBookingIds(bookingIds);
        assertThat(actual.size(), equalTo(bookingIds.size()));
        assertThat(actual, hasKey(bookingIds.get(0)));

        verify(bookingRepository, times(1)).getBookingDetail(bookingIds);
        verify(bookingRepository, times(1)).getBookingWaypoints(bookingIds.get(0));
    }

    @Test
    public void testCustomerVerified() {
        Integer userId = 12412;
        Integer blockageType = 2;

        /*Test Mock Data*/
        Long unverified = 0L;
        Long clientTrips = 20L;

        doReturn(unverified).when(bookingRepository).unverifiedCustomerTrips(userId,blockageType);
        doReturn(clientTrips).when(bookingRepository).fetchClientTrips(userId);

        Integer result = bookingDetailService.isCustomerVerified(userId, blockageType);
        assertThat(result, equalTo(1));
    }

    @Test
    public void testCustomerNotVerified() {
        Integer userId = 12412;
        Integer blockageType = 2;

        /*Test Mock Data*/
        Long unverified = 3L;
        Long clientTrips = 20L;

        doReturn(unverified).when(bookingRepository).unverifiedCustomerTrips(userId,blockageType);
        doReturn(clientTrips).when(bookingRepository).fetchClientTrips(userId);

        Integer result = bookingDetailService.isCustomerVerified(userId, blockageType);
        assertThat(result, equalTo(0));
    }

    @Test
    public void testFindCancelAndEndedBookingsByBookingId_IfNullInput(){

        List<Integer> bookingIds = new ArrayList<>(0);
        doReturn(bookingIds).when(bookingDetailService).getCancelledAndCompletedBookings(null);
        List<Integer> resulList = bookingDetailService.getCancelledAndCompletedBookings(null);

        assertThat(resulList,hasSize(0));
        verify(bookingDetailService,times(1)).getCancelledAndCompletedBookings(null);
    }

    @Test
    public void testFindCancelAndEndedBookingsByBookingIdWithOutResults(){

        List<Integer> bookingIds = Arrays.asList(124564,124569);
        List<Integer> responseIds = new ArrayList<>(0);

        doReturn(responseIds).when(bookingRepository).getCancelledAndCompletedBookings(bookingIds);

        List<Integer> result = bookingDetailService.getCancelledAndCompletedBookings(bookingIds);

        assertThat(result,hasSize(0));
        verify(bookingDetailService,times(1)).getCancelledAndCompletedBookings(bookingIds);
    }

    @Test
    public void testFindCancelAndEndedBookingsByBookingIdWithResults(){

        List<Integer> bookingIds = Arrays.asList(124564);
        List<Integer> responseIds = Arrays.asList(124564);

        doReturn(responseIds).when(bookingRepository).getCancelledAndCompletedBookings(bookingIds);

        List<Integer> result = bookingDetailService.getCancelledAndCompletedBookings(bookingIds);

        assertThat(result,hasSize(1));
        verify(bookingDetailService,times(1)).getCancelledAndCompletedBookings(bookingIds);
    }


    private BookingDetail getBookingDetail(Integer bookingId) {
        BookingDetail detail = new BookingDetail();
        detail.setBookingId(bookingId);
        detail.setTotalWayPoint(0);
        return detail;
    }
    private BookingDetail getBookingDetailWithWaypoints(Integer bookingId) {
        BookingDetail detail = new BookingDetail();
        detail.setBookingId(bookingId);
        detail.setTotalWayPoint(3);
        return detail;
    }
    private BookingWaypoint getBookingWaypoints(Integer bookingId){

        BookingWaypoint bookingWaypoint = new BookingWaypoint();

        bookingWaypoint.setId(1245);
        bookingWaypoint.setBookingId(bookingId);

        return bookingWaypoint;
    }
}
