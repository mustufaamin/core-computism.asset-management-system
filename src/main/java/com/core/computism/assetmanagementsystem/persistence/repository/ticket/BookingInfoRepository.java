package com.core.computism.assetmanagementsystem.persistence.repository.ticket;

import com.core.computism.assetmanagementsystem.persistence.entity.ticket.BookingInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

/**
 * Created by Venturedive on 8/19/2015.
 */
public interface BookingInfoRepository extends JpaRepository<BookingInfo, Long> {

    @Query("from BookingInfo where bookingId = :bookingId")
    BookingInfo findByBookingId(@Param("bookingId") Integer bookingId);
}
