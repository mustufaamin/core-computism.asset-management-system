package com.core.computism.assetmanagementsystem.service;

import com.core.computism.assetmanagementsystem.persistence.entity.booking.BookingDetail;

import java.util.HashMap;
import java.util.List;

/**
 * Created by Venturedive on 8/18/2015.
 */
public interface BookingDetailService {

    HashMap<Integer, BookingDetail> findByBookingIds(List<Integer> bookingIds);
    Integer isCustomerVerified(Integer userId, Integer blockageType);

    List<Integer> getCancelledAndCompletedBookings(List<Integer> bookingIds);

}
