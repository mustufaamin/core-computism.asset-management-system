package com.core.computism.assasa.service.impl;

import com.core.computism.assasa.domain.Location;
import com.core.computism.assasa.domain.type.BlockageType;
import com.core.computism.assasa.exception.BrainBusinessException;
import com.core.computism.assasa.persistence.cache.RedisRepository;
import com.core.computism.assasa.persistence.entity.booking.BookingDetail;
import com.core.computism.assasa.persistence.entity.ticket.BookingInfo;
import com.core.computism.assasa.persistence.entity.ticket.BookingWaypointLocation;
import com.core.computism.assasa.persistence.repository.ticket.BookingInfoRepository;
import com.core.computism.assasa.persistence.repository.ticket.BookingWaypointLocationRepository;
import com.core.computism.assasa.service.BookingDetailService;
import com.core.computism.assasa.service.BookingInfoService;
import com.core.computism.assasa.util.builder.BookingInfoBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.PersistenceException;
import java.util.List;

/**
 * Created by Venturedive on 8/19/2015.
 */
@Service(value = "bookingInfoService")
public class BookingInfoServiceImpl extends BaseService implements BookingInfoService {

    @Autowired private BookingInfoRepository bookingInfoRepository;

    @Autowired
    private RedisRepository redisRepository;

    @Autowired
    private BookingDetailService bookingDetailService;

    @Autowired
    private BookingWaypointLocationRepository bookingWaypointLocationRepository;

    @Override
    @Transactional(propagation = Propagation.REQUIRED, readOnly = false, rollbackFor = BrainBusinessException.class)
    public BookingInfo save(BookingDetail bookingDetail) throws BrainBusinessException {

        if (bookingDetail == null) {
            throw new BrainBusinessException("Unable to save [null] Booking Detail");
        }

        // Fetch Entity Instance, if exists
        BookingInfo bookingInfoInstance =  bookingInfoRepository.findByBookingId(bookingDetail.getBookingId());
        try {
            if (bookingInfoInstance == null){
                bookingInfoInstance = new BookingInfo();

            } else if(bookingInfoInstance.getTotalWayPoint() > 0)  {
                removeAttachedWaypoints(bookingInfoInstance.getId());
            }

            bookingInfoInstance = BookingInfoBuilder.setBookingInfo(bookingDetail, bookingInfoInstance);

            //Setting the current location of the Car
            Location location = redisRepository.getCaptainLatestLocation(bookingInfoInstance.getCaptainId());
            if(location != null) {
                bookingInfoInstance.setVehicleCurrentLatitude(location.getLatitude());
                bookingInfoInstance.setVehicleCurrentLongitude(location.getLongitude());
            }

            // Set the TripRating Verified(1) or unverified(0)
            bookingInfoInstance.setTripRating(bookingDetailService.isCustomerVerified(bookingDetail.getUserId(), BlockageType.BlOCKED_BY_DRIVER.getCode()));

            bookingInfoInstance = bookingInfoRepository.save(bookingInfoInstance);
            logger.debug("Saved Booking Info with id [" + bookingInfoInstance.getId() + "]");

        } catch (PersistenceException e) {
            throw new BrainBusinessException("Unable to save Booking Detail for booking Id [" + bookingDetail.getBookingId() + "]", e);
        }
        return bookingInfoInstance;
    }
    private void removeAttachedWaypoints(Long bookingInfoId){
        List<BookingWaypointLocation> waypointLocations = bookingWaypointLocationRepository.findBookingWaypointsByBookingInfoId(bookingInfoId);

        for(BookingWaypointLocation bookingWaypointLocation: waypointLocations){
            bookingWaypointLocationRepository.delete(bookingWaypointLocation);
        }

    }
}
