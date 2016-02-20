package com.core.computism.assasa.service.impl;

import com.core.computism.assasa.domain.type.CustomerVerification;
import com.core.computism.assasa.persistence.entity.booking.BookingDetail;
import com.core.computism.assasa.persistence.repository.booking.BookingRepository;
import com.core.computism.assasa.service.BookingDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;

/**
 * Created by Venturedive on 8/19/2015.
 */
@Service(value = "bookingDetailService")
public class BookingDetailServiceImpl extends BaseService implements BookingDetailService {

    @Autowired
    private BookingRepository bookingRepository;

    @Override
    public HashMap<Integer, BookingDetail> findByBookingIds(List<Integer> bookingIds) {
        logger.debug("Querying Booking Repository to fetch Booking Details for [" + bookingIds.size() + "] bookings");

        List<BookingDetail> bookingDetails = bookingRepository.getBookingDetail(bookingIds);
        HashMap<Integer, BookingDetail> result = new HashMap<>(bookingDetails.size());

        for (BookingDetail bookingDetail : bookingDetails) {

            /*Fetching the Booking Waypoints from the DB if waypoints exists*/
            if(bookingDetail.getTotalWayPoint() > 0 ){
                bookingDetail.setBookingWaypoints(bookingRepository.getBookingWaypoints(bookingDetail.getBookingId()));
            }
            result.put(bookingDetail.getBookingId(), bookingDetail);
        }
        return result;
    }
    @Override
    public Integer isCustomerVerified(Integer userId,Integer blockageType){

        Long unverifiedCustomerRatings = bookingRepository.unverifiedCustomerTrips(userId,blockageType);
        Long clientTrips = bookingRepository.fetchClientTrips(userId);
        if(unverifiedCustomerRatings == 0 && clientTrips >= 5L){
            return CustomerVerification.VERIFIED.getCode();
        }
        return CustomerVerification.UNVERIFIED.getCode();
    }

    @Override
    public List<Integer> getCancelledAndCompletedBookings(List<Integer> bookingIds) {
        return bookingRepository.getCancelledAndCompletedBookings(bookingIds);
    }
}
