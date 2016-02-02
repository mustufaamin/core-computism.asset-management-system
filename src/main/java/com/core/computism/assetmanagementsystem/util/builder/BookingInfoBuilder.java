package com.core.computism.assetmanagementsystem.util.builder;

import com.core.computism.assetmanagementsystem.domain.type.TripType;
import com.core.computism.assetmanagementsystem.persistence.entity.booking.BookingDetail;
import com.core.computism.assetmanagementsystem.persistence.entity.booking.BookingWaypoint;
import com.core.computism.assetmanagementsystem.persistence.entity.ticket.BookingInfo;
import com.core.computism.assetmanagementsystem.persistence.entity.ticket.BookingWaypointLocation;

import java.util.HashSet;
import java.util.Set;
/**
 * Created by M.Mustufa Amin Shah on 9/14/2015.
 */
public class BookingInfoBuilder {

    public static BookingInfo setBookingInfo(BookingDetail bookingDetail, BookingInfo bookingInfo) {
        setBookingDetails(bookingDetail, bookingInfo);
        setCustomerInfo(bookingDetail, bookingInfo);
        setCaptainInfo(bookingDetail, bookingInfo);
        setCarInfo(bookingDetail, bookingInfo);
        setRegionInfo(bookingDetail, bookingInfo);
        setBookerInfo(bookingDetail, bookingInfo);
        setWaypoints(bookingDetail, bookingInfo);

        return bookingInfo;
    }

    private static void setWaypoints(BookingDetail bookingDetail, BookingInfo bookingInfo) {
        Set<BookingWaypointLocation> bookingWaypointLocations = new HashSet<>(bookingDetail.getBookingWaypoints().size());

        for (BookingWaypoint waypoint : bookingDetail.getBookingWaypoints()) {
            BookingWaypointLocation bookingWaypointLocation = new BookingWaypointLocation();

            bookingWaypointLocation.setBookingInfo(bookingInfo);
            bookingWaypointLocation.setPriority(waypoint.getPriority());
            bookingWaypointLocation.setWaypointLatitude(waypoint.getWaypointLatitude());
            bookingWaypointLocation.setWaypointLongitude(waypoint.getWaypointLongitude());
            bookingWaypointLocation.setWaypointStatus(waypoint.getWaypointStatus());

            bookingWaypointLocations.add(bookingWaypointLocation);
        }
        bookingInfo.setWaypointLocations(bookingWaypointLocations);
    }

    private static void setBookerInfo(BookingDetail bookingDetail, BookingInfo bookingInfo) {
        bookingInfo.setBookerFirstName(bookingDetail.getBookerFirstName());
        bookingInfo.setBookerLastName(bookingDetail.getBookerLastName());
        bookingInfo.setBookerPhone(bookingDetail.getBookerPhone());
    }

    private static void setRegionInfo(BookingDetail bookingDetail, BookingInfo bookingInfo) {
        bookingInfo.setServiceAreaId(bookingDetail.getServiceAreaId());
        bookingInfo.setServiceArea(bookingDetail.getServiceArea());
        bookingInfo.setCountryId(bookingDetail.getCountryId());
        bookingInfo.setCountry(bookingDetail.getCountry());
        bookingInfo.setServiceAreaShortName(bookingDetail.getServiceAreaShortName());
    }

    private static void setCarInfo(BookingDetail bookingDetail, BookingInfo bookingInfo) {
        bookingInfo.setCarType(bookingDetail.getCarType());
        bookingInfo.setCarLicensePlate(bookingDetail.getCarLicensePlate());
        bookingInfo.setCarMake(bookingDetail.getCarMake());
        bookingInfo.setCarModel(bookingDetail.getCarModel());
        bookingInfo.setCarColor(bookingDetail.getCarColor());
        bookingInfo.setCarTypeDisplayName(bookingDetail.getCarTypeDisplayName());
    }

    private static void setCaptainInfo(BookingDetail bookingDetail, BookingInfo bookingInfo) {
        bookingInfo.setCaptainId(bookingDetail.getCaptainId());
        bookingInfo.setCaptainName(bookingDetail.getCaptainName());
        bookingInfo.setCaptainPhone(bookingDetail.getCaptainPhone());
        bookingInfo.setNotesToCaptain(bookingDetail.getNotesToCaptain());
        bookingInfo.setIsCaptainForVip(bookingDetail.getIsCaptainForVip());
        bookingInfo.setCaptainEmail(bookingDetail.getCaptainEmail());
    }

    private static void setCustomerInfo(BookingDetail bookingDetail, BookingInfo bookingInfo) {
        bookingInfo.setCustomerId(bookingDetail.getCustomerId());
        bookingInfo.setCustomerFirstName(bookingDetail.getCustomerFirstName());
        bookingInfo.setCustomerLastName(bookingDetail.getCustomerLastName());
        bookingInfo.setCustomerPhone(bookingDetail.getCustomerPhone());
        bookingInfo.setCustomerType(bookingDetail.getCustomerType());
        bookingInfo.setCustomerCompany(bookingDetail.getCustomerCompany());
        bookingInfo.setCustomerEmail(bookingDetail.getCustomerEmail());
        bookingInfo.setCustomerRating(bookingDetail.getCustomerRating());
    }

    private static void setBookingDetails(BookingDetail bookingDetail, BookingInfo bookingInfo) {
        bookingInfo.setBookingId(bookingDetail.getBookingId());
        bookingInfo.setBookingCreationDate(bookingDetail.getBookingCreationDate());
        bookingInfo.setBookingModifiedDate(bookingDetail.getBookingModifiedDate());

        // Convert Unconfirmed Bookings to Now
        Integer bookingType = bookingDetail.getBookingType() == 3 ? 2 : bookingDetail.getBookingType();
        bookingInfo.setBookingType(bookingType);

        bookingInfo.setPickupTime(bookingDetail.getPickupTime());
        bookingInfo.setCaptainPickupTime(bookingDetail.getCaptainPickupTime());
        bookingInfo.setBookingSource(bookingDetail.getBookingSource());
        bookingInfo.setBookingStatus(bookingDetail.getBookingStatus());
        bookingInfo.setTotalWayPoint(bookingDetail.getTotalWayPoint());

        bookingInfo.setPickupLatitude(bookingDetail.getPickupLatitude());
        bookingInfo.setPickupLongitude(bookingDetail.getPickupLongitude());
        bookingInfo.setDropOffLatitude(bookingDetail.getDropOffLatitude());
        bookingInfo.setDropOffLongitude(bookingDetail.getDropOffLongitude());

        bookingInfo.setExpectedArrivalDate(bookingDetail.getExpectedArrivalDate());

        TripType tripType = bookingDetail.getTotalWayPoint() > 0 ? TripType.MULTISTOP
                : bookingDetail.getRecurringCode() != null ? TripType.REPEAT : TripType.SINGLE;
        bookingInfo.setTripType(tripType);
    }
}
