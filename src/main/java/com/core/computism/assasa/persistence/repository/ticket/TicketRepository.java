package com.core.computism.assasa.persistence.repository.ticket;

import com.core.computism.assasa.persistence.entity.ticket.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * Created by Venturedive on 8/18/2015.
 */
public interface TicketRepository extends JpaRepository<Ticket, Long> {

    @Query("from Ticket t where t.problemType.typeCode = :problemTypeCode and t.bookingInfo.bookingId = :bookingId and t.ticketStatus < 8")
    Ticket findByProblemTypeAndBookingId(@Param("problemTypeCode") String problemTypeCode, @Param("bookingId") Integer bookingId);

    @Query(value = "select * from ticket where ticket_status < 3 AND auto_expire_min > -1 and date_add(last_modified_date, interval auto_expire_min minute) < now() limit 0,500"
            , nativeQuery = true)
    List<Ticket> findTicketsReadyToAutoResolve();

    @Query(value = "select * from ticket where ticket_status = 4 and date_add(snoozed_date, interval snoozed_min minute) < now() "
            , nativeQuery = true)
    List<Ticket> findTicketsToUnsnoozed();

    @Query(value = " SELECT b.booking_id  FROM booking_info b JOIN ticket t ON b.id = t.booking_info_id " +
            " WHERE t.ticket_status < 8 AND t.problem_type_id <> 9 LIMIT 0, 500 "
         ,nativeQuery = true)
    List<Integer> findBookingIdsOfUnclosedTickets();

    @Query("from Ticket t where t.bookingInfo.bookingId in :bookingIds")
    List<Ticket> findByBookingId(@Param("bookingIds") List<Integer> bookingIds);

    @Query(value = "select * FROM ticket t JOIN booking_info b ON t.booking_info_id = b.id " +
            " WHERE t.ticket_status < 8 " +
            " AND b.booking_status IN (6, 7) " +
            " AND t.problem_type_id <> 9 "
            , nativeQuery = true)
    List<Ticket> findTicketsReadyToClose();

}
