package com.core.computism.assasa.persistence.entity.booking;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

/**
 * Used to fetch booking details from Careem Repository
 * Created by Venturedive on 7/28/2015.
 */
@Entity
@SqlResultSetMapping(name = "BookingDetail")
public class BookingDetail {

    private Integer bookingId;
    private Timestamp bookingCreationDate;
    private Timestamp bookingModifiedDate;
    private Integer bookingType;
    private Timestamp pickupTime;
    private Timestamp captainPickupTime;
    private Integer bookingSource;
    private Integer bookingStatus;
    private Integer totalWayPoint;
    private Timestamp expectedArrivalDate;

    private Double pickupLatitude;
    private Double pickupLongitude;
    private Double dropOffLatitude;
    private Double dropOffLongitude;

    private Integer customerId;
    private String customerFirstName;
    private String customerLastName;
    private String customerPhone;
    private Integer customerType;
    private String customerCompany;
    private Integer customerRating;
    private String customerEmail;

    private Integer captainId;
    private String captainName;
    private String captainPhone;
    private String captainEmail;
    private String notesToCaptain;
    private Boolean isCaptainForVip;

    private Integer carType;
    private String carTypeDisplayName;
    private String carLicensePlate;
    private String carMake;
    private String carModel;
    private String carColor;

    private Integer serviceAreaId;
    private String serviceArea;
    private String serviceAreaShortName;
    private Integer countryId;
    private String country;

    private String bookerFirstName;
    private String bookerLastName;
    private String bookerPhone;
    private String recurringCode;
    private Integer userId;

    List<BookingWaypoint> bookingWaypoints = new ArrayList<>(0);

    @Id
    @Column(name = "booking_id")
    public Integer getBookingId() {
        return bookingId;
    }

    public void setBookingId(Integer bookingId) {
        this.bookingId = bookingId;
    }

    @Column(name = "booking_creation_date")
    public Timestamp getBookingCreationDate() {
        return bookingCreationDate;
    }

    public void setBookingCreationDate(Timestamp bookingCreationDate) {
        this.bookingCreationDate = bookingCreationDate;
    }

    @Column(name = "booking_modified_date")
    public Timestamp getBookingModifiedDate() {
        return bookingModifiedDate;
    }

    public void setBookingModifiedDate(Timestamp bookingModifiedDate) {
        this.bookingModifiedDate = bookingModifiedDate;
    }

    @Column(name = "booking_type")
    public Integer getBookingType() {
        return bookingType;
    }

    public void setBookingType(Integer bookingType) {
        this.bookingType = bookingType;
    }

    @Column(name = "pick_up_time")
    public Timestamp getPickupTime() {
        return pickupTime;
    }

    public void setPickupTime(Timestamp pickupTime) {
        this.pickupTime = pickupTime;
    }

    @Column(name = "driver_pick_up_time")
    public Timestamp getCaptainPickupTime() {
        return captainPickupTime;
    }

    public void setCaptainPickupTime(Timestamp captainPickupTime) {
        this.captainPickupTime = captainPickupTime;
    }

    @Column(name = "booking_status")
    public Integer getBookingStatus() {
        return bookingStatus;
    }

    public void setBookingStatus(Integer bookingStatus) {
        this.bookingStatus = bookingStatus;
    }

    @Column(name = "booking_source")
    public Integer getBookingSource() {
        return bookingSource;
    }

    public void setBookingSource(Integer bookingSource) {
        this.bookingSource = bookingSource;
    }


    @Column(name = "total_waypoint")
    public Integer getTotalWayPoint() {
        return totalWayPoint;
    }

    public void setTotalWayPoint(Integer totalWayPoint) {
        this.totalWayPoint = totalWayPoint;
    }

    @Column(name = "pickup_latitude")
    public Double getPickupLatitude() {
        return pickupLatitude;
    }

    public void setPickupLatitude(Double pickupLatitude) {
        this.pickupLatitude = pickupLatitude;
    }

    @Column(name = "pickup_longitude")
    public Double getPickupLongitude() {
        return pickupLongitude;
    }

    public void setPickupLongitude(Double pickupLongitude) {
        this.pickupLongitude = pickupLongitude;
    }

    @Column(name = "dropoff_latitude")
    public Double getDropOffLatitude() {
        return dropOffLatitude;
    }

    public void setDropOffLatitude(Double dropOffLatitude) {
        this.dropOffLatitude = dropOffLatitude;
    }

    @Column(name = "dropoff_longitude")
    public Double getDropOffLongitude() {
        return dropOffLongitude;
    }

    public void setDropOffLongitude(Double dropOffLongitude) {
        this.dropOffLongitude = dropOffLongitude;
    }

    @Column(name = "customer_id")
    public Integer getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Integer customerId) {
        this.customerId = customerId;
    }

    @Column(name = "customer_fname")
    public String getCustomerFirstName() {
        return customerFirstName;
    }

    public void setCustomerFirstName(String customerFirstName) {
        this.customerFirstName = customerFirstName;
    }

    @Column(name = "customer_lname")
    public String getCustomerLastName() {
        return customerLastName;
    }

    public void setCustomerLastName(String customerLastName) {
        this.customerLastName = customerLastName;
    }

    @Column(name = "customer_phone")
    public String getCustomerPhone() {
        return customerPhone;
    }

    public void setCustomerPhone(String customerPhone) {
        this.customerPhone = customerPhone;
    }

    @Column(name = "customer_type")
    public Integer getCustomerType() {
        return customerType;
    }

    public void setCustomerType(Integer customerType) {
        this.customerType = customerType;
    }

    @Column(name = "customer_company")
    public String getCustomerCompany() {
        return customerCompany;
    }

    public void setCustomerCompany(String customerCompany) {
        this.customerCompany = customerCompany;
    }

    @Column(name = "captain_id")
    public Integer getCaptainId() {
        return captainId;
    }

    public void setCaptainId(Integer captainId) {
        this.captainId = captainId;
    }

    @Column(name = "captain_name")
    public String getCaptainName() {
        return captainName;
    }

    public void setCaptainName(String captainName) {
        this.captainName = captainName;
    }

    @Column(name = "captain_phone")
    public String getCaptainPhone() {
        return captainPhone;
    }

    public void setCaptainPhone(String captainPhone) {
        this.captainPhone = captainPhone;
    }

    @Column(name = "notes_to_captain")
    public String getNotesToCaptain() {
        return notesToCaptain;
    }

    public void setNotesToCaptain(String notesToCaptain) {
        this.notesToCaptain = notesToCaptain;
    }

    @Column(name = "captain_for_vip")
    public Boolean getIsCaptainForVip() {
        return isCaptainForVip;
    }

    public void setIsCaptainForVip(Boolean isCaptainForVip) {
        this.isCaptainForVip = isCaptainForVip;
    }

    @Column(name = "car_type")
    public Integer getCarType() {
        return carType;
    }

    public void setCarType(Integer carType) {
        this.carType = carType;
    }

    @Column(name = "car_type_display_name")
    public String getCarTypeDisplayName() {
        return carTypeDisplayName;
    }

    public void setCarTypeDisplayName(String carTypeDisplayName) {
        this.carTypeDisplayName = carTypeDisplayName;
    }

    @Column(name = "car_license_plate")
    public String getCarLicensePlate() {
        return carLicensePlate;
    }

    public void setCarLicensePlate(String carLicensePlate) {
        this.carLicensePlate = carLicensePlate;
    }

    @Column(name = "car_make")
    public String getCarMake() {
        return carMake;
    }

    public void setCarMake(String carMake) {
        this.carMake = carMake;
    }

    @Column(name = "car_model")
    public String getCarModel() {
        return carModel;
    }

    public void setCarModel(String carModel) {
        this.carModel = carModel;
    }

    @Column(name = "car_color")
    public String getCarColor() {
        return carColor;
    }

    public void setCarColor(String carColor) {
        this.carColor = carColor;
    }

    @Column(name = "service_area_id")
    public Integer getServiceAreaId() {
        return serviceAreaId;
    }

    public void setServiceAreaId(Integer serviceAreaId) {
        this.serviceAreaId = serviceAreaId;
    }

    @Column(name = "service_area")
    public String getServiceArea() {
        return serviceArea;
    }

    public void setServiceArea(String serviceArea) {
        this.serviceArea = serviceArea;
    }

    @Column(name = "country_id")
    public Integer getCountryId() {
        return countryId;
    }

    public void setCountryId(Integer countryId) {
        this.countryId = countryId;
    }

    @Column(name = "country")
    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    @Column(name = "booker_fname")
    public String getBookerFirstName() {
        return bookerFirstName;
    }

    public void setBookerFirstName(String bookerFirstName) {
        this.bookerFirstName = bookerFirstName;
    }

    @Column(name = "booker_lname")
    public String getBookerLastName() {
        return bookerLastName;
    }

    public void setBookerLastName(String bookerLastName) {
        this.bookerLastName = bookerLastName;
    }

    @Column(name = "booker_phone")
    public String getBookerPhone() {
        return bookerPhone;
    }

    public void setBookerPhone(String bookerPhone) {
        this.bookerPhone = bookerPhone;
    }

    @Column(name = "recurring_code")
    public String getRecurringCode() {
        return recurringCode;
    }

    public void setRecurringCode(String recurringCode) {
        this.recurringCode = recurringCode;
    }

    @Column(name = "customer_rating")
    public Integer getCustomerRating() {
        return customerRating;
    }

    public void setCustomerRating(Integer customerRating) {
        this.customerRating = customerRating;
    }

    @Column(name = "user_id")
    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    @Column(name = "service_area_shortname")
    public String getServiceAreaShortName() {
        return serviceAreaShortName;
    }
    public void setServiceAreaShortName(String serviceAreaShortName) {
        this.serviceAreaShortName = serviceAreaShortName;
    }

    @Column(name = "customer_email")
    public String getCustomerEmail() {
        return customerEmail;
    }

    public void setCustomerEmail(String customerEmail) {
        this.customerEmail = customerEmail;
    }

    @Column(name = "captain_email")
    public String getCaptainEmail() {
        return captainEmail;
    }

    public void setCaptainEmail(String captainEmail) {
        this.captainEmail = captainEmail;
    }

    @Column(name = "expected_arrival_date")
    public Timestamp getExpectedArrivalDate() {
        return expectedArrivalDate;
    }
    public void setExpectedArrivalDate(Timestamp expectedArrivalDate) {
        this.expectedArrivalDate = expectedArrivalDate;
    }

    @Transient
    public List<BookingWaypoint> getBookingWaypoints() {
        return bookingWaypoints;
    }

    public void setBookingWaypoints(List<BookingWaypoint> bookingWaypoints) {
        this.bookingWaypoints = bookingWaypoints;
    }
}
