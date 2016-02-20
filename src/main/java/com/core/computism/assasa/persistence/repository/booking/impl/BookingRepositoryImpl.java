package com.core.computism.assasa.persistence.repository.booking.impl;

import com.core.computism.assasa.persistence.entity.booking.BookingDetail;
import com.core.computism.assasa.persistence.entity.booking.BookingWaypoint;
import com.core.computism.assasa.persistence.repository.booking.BookingRepository;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Venturedive on 8/10/2015.
 */
@Repository(value = "bookingRepository")
@Transactional(readOnly = true, propagation = Propagation.NOT_SUPPORTED)
public class BookingRepositoryImpl implements BookingRepository {

    private static final Logger LOGGER = Logger.getLogger(BookingRepositoryImpl.class);

    @PersistenceContext(unitName = "bookingPersistenceUnit")
    private EntityManager entityManager;

    @Override
    public List<BookingDetail> getBookingDetail(List<Integer> bookingIds) {
        List<BookingDetail> bookingDetails = new ArrayList<>(0);
        try {
            StringBuilder queryBuilder = new StringBuilder(
                   " SELECT "  +
                   "  b.id                                                                      AS booking_id," +
                   "  b.creation_date                                                           AS booking_creation_date," +
                   "  bd.last_updated                                                           AS booking_modified_date," +
                   "  b.booking_type," +
                   "  b.pick_up_time," +
                   "  b.driver_pick_up_time," +
                   "  bd.booking_source," +
                   "  bd.total_waypoint," +
                   "  bd.booking_status," +
                   "  p.id                                                                      AS customer_id," +
                   "  p.first_name                                                              AS customer_fname," +
                   "  p.last_name                                                               AS customer_lname," +
                   "  p.phone_number                                                            AS customer_phone," +
                   "  p.email                                                                   AS customer_email," +
                   "  GREATEST(u.service_level_agreement, IFNULL(c.service_level_agreement, 1)) AS customer_type," +
                   "  c.name                                                                    AS customer_company," +
                   "  d.id                                                                      AS captain_id," +
                   "  d.name                                                                    AS captain_name," +
                   "  dp.phone_number                                                           AS captain_phone," +
                   "  d.email                                                                   AS captain_email," +
                   "  bd.notes_to_driver                                                        AS notes_to_captain," +
                   "  d.approved_for_vip                                                        AS captain_for_vip," +
                   "  bp.first_name                                                             AS booker_fname," +
                   "  bp.last_name                                                              AS booker_lname," +
                   "  bp.phone_number                                                           AS booker_phone," +
                   "  cct.id                                                                    AS car_type, " +
                   "  cct.display_name                                                          AS car_type_display_name," +
                   "  car.license_plate                                                         AS car_license_plate," +
                   "  car.make                                                                  AS car_make," +
                   "  car.model                                                                 AS car_model," +
                   "  car.color                                                                 AS car_color," +
                   "  pl.latitude                                                               AS pickup_latitude," +
                   "  pl.longitude                                                              AS pickup_longitude," +
                   "  dl.latitude                                                               AS dropoff_latitude," +
                   "  dl.longitude                                                              AS dropoff_longitude," +
                   "  sa.id                                                                     AS service_area_id," +
                   "  sa.service_area_name                                                      AS service_area," +
                   "  sa.short_display_name                                                     AS service_area_shortname," +
                   "  cntry.id                                                                  AS country_id," +
                   "  cntry.country_name                                                        AS country," +
                   "  tr.rating                                                                 AS customer_rating," +
                   "  bd.total_waypoint, " +
                   "  b.recurring_code, " +
                   "  u.id                                                                      AS user_id," +
                   "  btd.google_adjusted_duration_driver_coming_date                           AS expected_arrival_date " +
                   " FROM booking b" +
                   "  JOIN booking_detail bd ON b.id = bd.booking_id" +
                   "  JOIN passenger p ON b.user_passenger_id = p.id" +
                   "  JOIN careem.user u ON b.client_id = u.id" +
                   "  LEFT OUTER JOIN company c ON u.works_for_id = c.id" +
                   "  LEFT OUTER JOIN drivers d ON bd.assigned_driver_id = d.id" +
                   "  LEFT OUTER JOIN driver_phone dp ON d.prefered_phone_id = dp.id" +
                   "  JOIN careem.user bu ON b.booker_id = bu.id" +
                   "  JOIN passenger bp ON bp.id = bu.user_passenger_id" +
                   "  JOIN location pl ON b.pick_up_location_id = pl.id" +
                   "  JOIN location dl ON b.drop_off_location_id = dl.id" +
                   "  LEFT OUTER JOIN customer_car_type cct ON b.customer_car_type_id = cct.id" +
                   "  JOIN service_area sa ON cct.service_area_id = sa.id" +
                   "  JOIN service_provider_country spc ON sa.service_provider_country_id = spc.id" +
                   "                                       AND spc.service_provider_id = 1" +
                   "  JOIN country cntry ON spc.country_id = cntry.id" +
                   "  LEFT JOIN car ON bd.assigned_car_id = car.id" +
                   "  LEFT JOIN trip t on t.booking_id = b.id " +
                   "  LEFT JOIN trip_rating tr on t.id = tr.belongs_to_trip_id " +
                   "  LEFT OUTER JOIN booking_tracking_detail btd on b.id = btd.booking_id "+
                   " WHERE b.id IN (:bookingIds)"
            );

            LOGGER.debug("Querying Careem DB [" + queryBuilder.toString() + "]");

            Query query = entityManager.createNativeQuery(queryBuilder.toString(), BookingDetail.class);

            query.setParameter("bookingIds", bookingIds);
            bookingDetails = query.getResultList();

        } catch (Exception e) {
            LOGGER.error("getBookingDetail threw exception", e);
        }
        return bookingDetails;
    }

    @Override
    public List<BookingWaypoint> getBookingWaypoints(Integer bookingId) {

        List<BookingWaypoint> bookingWaypoints = new ArrayList<>(0);
        try {
            StringBuilder queryBuilder = new StringBuilder(
                    " SELECT " +
                    "  bw.id," +
                    "  bw.booking_id," +
                    "  l.latitude as waypoint_latitude," +
                    "  l.longitude as waypoint_longitude," +
                    "  bw.priority as waypoint_priority," +
                    "  bw.waypoint_status" +
                    " FROM booking_waypoint bw " +
                    "  JOIN location l ON l.id = bw.location_id" +
                    " Where booking_id = :bookingId"
            );

            LOGGER.debug("Querying Careem DB [" + queryBuilder.toString() + "]");

            Query query = entityManager.createNativeQuery(queryBuilder.toString(), BookingWaypoint.class);

            query.setParameter("bookingId", bookingId);
            bookingWaypoints = query.getResultList();

        } catch (Exception e) {
            LOGGER.error("getBookingWaypoints threw exception", e);
        }

        return bookingWaypoints;
    }
    @Override
    public Long unverifiedCustomerTrips(Integer userId, Integer blockageType) {
        Long result = null;
        try {
            StringBuilder queryBuilder = new StringBuilder(
                    " SELECT count(1)" +
                    " FROM user_driver_block udb" +
                    " WHERE udb.user_id = :userId " +
                    "       AND udb.blockage_type = :blockageType" +
                    "      AND udb.creation_date >= DATE_SUB(now(), interval 30 day) "
            );

            LOGGER.debug("Querying Careem DB [" + queryBuilder.toString() + "]");

            Query query = entityManager.createNativeQuery(queryBuilder.toString());

            query.setParameter("userId", userId);
            query.setParameter("blockageType", blockageType);
            result =  ((BigInteger) query.getSingleResult()).longValue();

        } catch (Exception e) {
            LOGGER.error("getUnverified Trips threw exception", e);
        }
        return result;
    }

    @Override
    public Long fetchClientTrips(Integer clientId){
        String queryStr =
                "SELECT COUNT(1) FROM trip t " +
                        "INNER JOIN booking b ON b.id = t.booking_id " +
                        "where b.client_id = :clientId";
        Query query = entityManager.createNativeQuery(queryStr);
        query.setParameter("clientId", clientId);
        try {
            return ((BigInteger) query.getSingleResult()).longValue();
        } catch (NoResultException e) {
            LOGGER.error("getUnverified Trips threw exception", e);
            return 0L;
        }
    }

    @Override
    public List<Integer> getCancelledAndCompletedBookings(List<Integer> bookingIds) {
        List<Integer> result = new ArrayList<>(0);
        try {
            StringBuilder queryString = new StringBuilder("select bd.booking_id "
                    + " from booking_detail bd "
                    + " join booking_activity ba on bd.booking_id = ba.booking_id "
                    + " and ba.activity_type = bd.booking_status "
                    + " where bd.booking_id in (:bookingIds) "
                    + " and (bd.booking_status = 7 "
                    + " or (bd.booking_status = 6 and date_add(ba.creation_date, interval 5 minute) < now())) ");

            Query query = entityManager.createNativeQuery(queryString.toString());
            query.setParameter("bookingIds", bookingIds);

            result = query.getResultList();

        } catch (Exception ex){
            LOGGER.error("getCancelledAndCompletedBookings threw exception.", ex);
        }
        return result;
    }
}
