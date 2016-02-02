package com.core.computism.assetmanagementsystem.persistence.repository.booking;

import com.core.computism.assetmanagementsystem.persistence.entity.booking.BookingDetail;
import com.core.computism.assetmanagementsystem.persistence.entity.booking.BookingWaypoint;

import java.util.List;

/**
 * Created by Venturedive on 8/10/2015.
 */
public interface BookingRepository {

    List<BookingDetail> getBookingDetail(List<Integer> bookingIds);
    List<BookingWaypoint> getBookingWaypoints(Integer bookingId);
    Long unverifiedCustomerTrips(Integer userId, Integer blockageType);
    Long fetchClientTrips(Integer clientId);
    List<Integer> getCancelledAndCompletedBookings(List<Integer> bookingIds);
}
