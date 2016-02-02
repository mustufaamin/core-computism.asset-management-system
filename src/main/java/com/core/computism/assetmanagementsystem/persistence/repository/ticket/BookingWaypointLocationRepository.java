package com.core.computism.assetmanagementsystem.persistence.repository.ticket;

import com.core.computism.assetmanagementsystem.persistence.entity.ticket.BookingWaypointLocation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * Created by Venture Dive on 10/5/2015.
 */
public interface BookingWaypointLocationRepository extends JpaRepository<BookingWaypointLocation, Long> {

    @Query("from BookingWaypointLocation bwp where bwp.bookingInfo.id = :bookingInfoId" )
    List<BookingWaypointLocation> findBookingWaypointsByBookingInfoId(@Param("bookingInfoId") Long bookingInfoId);
}
