package com.core.computism.assetmanagementsystem.persistence.entity.ticket;

import com.core.computism.assetmanagementsystem.domain.type.TripType;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by Venturedive on 8/17/2015.
 */
@Entity
@Table(name = "booking_info")
public class BookingInfo extends BaseEntity {
    private static final long serialVersionUID = 1661288220126124630L;

    private Integer bookingId;
    private Date bookingCreationDate;
    private Date bookingModifiedDate;
    private Integer bookingType;
    private Date pickupTime;
    private Date captainPickupTime;
    private Integer bookingSource;
    private Integer bookingStatus;
    private Integer totalWayPoint;

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
    private String customerEmail;

    private Integer captainId;
    private String captainName;
    private String captainPhone;
    private String captainEmail;
    private String notesToCaptain;
    private Boolean isCaptainForVip;

    private Integer carType;
    private String carLicensePlate;
    private String carMake;
    private String carModel;
    private String carColor;
    private String carTypeDisplayName;

    private Integer serviceAreaId;
    private String serviceArea;
    private String serviceAreaShortName;
    private Integer countryId;
    private String country;

    private String bookerFirstName;
    private String bookerLastName;
    private String bookerPhone;

    private Double vehicleCurrentLatitude;
    private Double vehicleCurrentLongitude;
    private Integer customerRating;
    private Integer tripType;
    private Integer tripRating;

    private Date expectedArrivalDate;

    private Set<Ticket> tickets = new HashSet<>(0);
    private Set<BookingWaypointLocation> waypointLocations = new HashSet<>(0);

    @Column(name = "booking_id", nullable = false, precision = 11, scale = 0)
    public Integer getBookingId() {
        return bookingId;
    }

    public void setBookingId(Integer bookingId) {
        this.bookingId = bookingId;
    }

    @Temporal(value = TemporalType.TIMESTAMP)
    @Column(name = "booking_creation_date", length = 11)
    public Date getBookingCreationDate() {
        return bookingCreationDate;
    }

    public void setBookingCreationDate(Date bookingCreationDate) {
        this.bookingCreationDate = bookingCreationDate;
    }

    @Temporal(value = TemporalType.TIMESTAMP)
    @Column(name = "booking_modified_date", length = 11)
    public Date getBookingModifiedDate() {
        return bookingModifiedDate;
    }

    public void setBookingModifiedDate(Date bookingModifiedDate) {
        this.bookingModifiedDate = bookingModifiedDate;
    }

    @Column(name = "booking_type", precision = 11, scale = 0)
    public Integer getBookingType() {
        return bookingType;
    }

    public void setBookingType(Integer bookingType) {
        this.bookingType = bookingType;
    }

    @Temporal(value = TemporalType.TIMESTAMP)
    @Column(name = "pickup_time", length = 11)
    public Date getPickupTime() {
        return pickupTime;
    }

    public void setPickupTime(Date pickupTime) {
        this.pickupTime = pickupTime;
    }

    @Temporal(value = TemporalType.TIMESTAMP)
    @Column(name = "captain_pickup_time", length = 11)
    public Date getCaptainPickupTime() {
        return captainPickupTime;
    }

    public void setCaptainPickupTime(Date captainPickupTime) {
        this.captainPickupTime = captainPickupTime;
    }

    @Column(name = "booking_source", precision = 11, scale = 0)
    public Integer getBookingSource() {
        return bookingSource;
    }

    public void setBookingSource(Integer bookingSource) {
        this.bookingSource = bookingSource;
    }

    @Column(name = "booking_status")
    public Integer getBookingStatus() {
        return bookingStatus;
    }

    public void setBookingStatus(Integer bookingStatus) {
        this.bookingStatus = bookingStatus;
    }

    @Column(name = "total_waypoint", nullable = false, precision = 11, scale = 0)
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

    @Column(name = "customer_id", nullable = false, precision = 11, scale = 0)
    public Integer getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Integer customerId) {
        this.customerId = customerId;
    }

    @Column(name = "customer_fname", nullable = false, length = 200)
    public String getCustomerFirstName() {
        return customerFirstName;
    }

    public void setCustomerFirstName(String customerFirstName) {
        this.customerFirstName = customerFirstName;
    }

    @Column(name = "customer_lname", nullable = false, length = 200)
    public String getCustomerLastName() {
        return customerLastName;
    }

    public void setCustomerLastName(String customerLastName) {
        this.customerLastName = customerLastName;
    }

    @Column(name = "customer_phone", length = 20)
    public String getCustomerPhone() {
        return customerPhone;
    }

    public void setCustomerPhone(String customerPhone) {
        this.customerPhone = customerPhone;
    }

    @Column(name = "customer_type", nullable = false, precision = 11, scale = 0)
    public Integer getCustomerType() {
        return customerType;
    }

    public void setCustomerType(Integer customerType) {
        this.customerType = customerType;
    }

    @Column(name = "customer_company", length = 45)
    public String getCustomerCompany() {
        return customerCompany;
    }

    public void setCustomerCompany(String customerCompany) {
        this.customerCompany = customerCompany;
    }

    @Column(name = "captain_id", precision = 11, scale = 0)
    public Integer getCaptainId() {
        return captainId;
    }

    public void setCaptainId(Integer captainId) {
        this.captainId = captainId;
    }

    @Column(name = "captain_name", length = 60)
    public String getCaptainName() {
        return captainName;
    }

    public void setCaptainName(String captainName) {
        this.captainName = captainName;
    }

    @Column(name = "captain_phone", length = 45)
    public String getCaptainPhone() {
        return captainPhone;
    }

    public void setCaptainPhone(String captainPhone) {
        this.captainPhone = captainPhone;
    }

    @Column(name = "notes_to_captain", length = 450)
    public String getNotesToCaptain() {
        return notesToCaptain;
    }

    public void setNotesToCaptain(String notesToCaptain) {
        this.notesToCaptain = notesToCaptain;
    }

    @Column(name = "captain_for_vip", precision = 11, scale = 0)
    public Boolean getIsCaptainForVip() {
        return isCaptainForVip;
    }

    public void setIsCaptainForVip(Boolean isCaptainForVip) {
        this.isCaptainForVip = isCaptainForVip;
    }

    @Column(name = "car_type", precision = 11, scale = 0)
    public Integer getCarType() {
        return carType;
    }

    public void setCarType(Integer carType) {
        this.carType = carType;
    }

    @Column(name = "car_license_plate", length = 45)
    public String getCarLicensePlate() {
        return carLicensePlate;
    }

    public void setCarLicensePlate(String carLicensePlate) {
        this.carLicensePlate = carLicensePlate;
    }

    @Column(name = "car_make", length = 245)
    public String getCarMake() {
        return carMake;
    }

    public void setCarMake(String carMake) {
        this.carMake = carMake;
    }

    @Column(name = "car_model", length = 245)
    public String getCarModel() {
        return carModel;
    }

    public void setCarModel(String carModel) {
        this.carModel = carModel;
    }

    @Column(name = "car_color", length = 245)
    public String getCarColor() {
        return carColor;
    }

    public void setCarColor(String carColor) {
        this.carColor = carColor;
    }

    @Column(name = "car_type_display_name",length = 255)
    public String getCarTypeDisplayName() {
        return carTypeDisplayName;
    }

    public void setCarTypeDisplayName(String carTypeDisplayName) {
        this.carTypeDisplayName = carTypeDisplayName;
    }

    @Column(name = "service_area_id", nullable = false, precision = 11, scale = 0)
    public Integer getServiceAreaId() {
        return serviceAreaId;
    }

    public void setServiceAreaId(Integer serviceAreaId) {
        this.serviceAreaId = serviceAreaId;
    }

    @Column(name = "service_area", length = 255)
    public String getServiceArea() {
        return serviceArea;
    }

    public void setServiceArea(String serviceArea) {
        this.serviceArea = serviceArea;
    }

    @Column(name = "country_id", nullable = false, precision = 11, scale = 0)
    public Integer getCountryId() {
        return countryId;
    }

    public void setCountryId(Integer countryId) {
        this.countryId = countryId;
    }

    @Column(name = "country", length = 300)
    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    @Column(name = "booker_fname", nullable = false, length = 200)
    public String getBookerFirstName() {
        return bookerFirstName;
    }

    public void setBookerFirstName(String bookerFirstName) {
        this.bookerFirstName = bookerFirstName;
    }

    @Column(name = "booker_lname", nullable = false, length = 200)
    public String getBookerLastName() {
        return bookerLastName;
    }

    public void setBookerLastName(String bookerLastName) {
        this.bookerLastName = bookerLastName;
    }

    @Column(name = "booker_phone", length = 20)
    public String getBookerPhone() {
        return bookerPhone;
    }

    public void setBookerPhone(String bookerPhone) {
        this.bookerPhone = bookerPhone;
    }

    @Column(name = "vehicle_current_latitude")
    public Double getVehicleCurrentLatitude() {
        return vehicleCurrentLatitude;
    }

    public void setVehicleCurrentLatitude(Double vehicleCurrentLatitude) {
        this.vehicleCurrentLatitude = vehicleCurrentLatitude;
    }

    @Column(name = "vehicle_current_longitude")
    public Double getVehicleCurrentLongitude() {
        return vehicleCurrentLongitude;
    }

    public void setVehicleCurrentLongitude(Double vehicleCurrentLongitude) {
        this.vehicleCurrentLongitude = vehicleCurrentLongitude;
    }

    @Column(name = "customer_rating", precision = 11, scale = 0)
    public Integer getCustomerRating() {
        return customerRating;
    }

    public void setCustomerRating(Integer customerRating) {
        this.customerRating = customerRating;
    }

    @Column(name = "trip_type", precision = 11, scale = 0)
    public Integer getTripType() {
        return tripType;
    }

    public void setTripType(Integer tripType) {
        this.tripType = tripType;
    }

    @Column(name = "trip_rating", precision = 11, scale = 0)
    public Integer getTripRating() {
        return tripRating;
    }

    public void setTripRating(Integer tripRating) {
        this.tripRating = tripRating;
    }

    @Column(name = "service_area_short_name", length = 255)
    public String getServiceAreaShortName() {
        return serviceAreaShortName;
    }
    public void setServiceAreaShortName(String serviceAreaShortName) {
        this.serviceAreaShortName = serviceAreaShortName;
    }

    @Column(name = "customer_email", length = 255)
    public String getCustomerEmail() {
        return customerEmail;
    }

    public void setCustomerEmail(String customerEmail) {
        this.customerEmail = customerEmail;
    }

    @Column(name = "captain_email", length = 255)
    public String getCaptainEmail() {
        return captainEmail;
    }

    public void setCaptainEmail(String captainEmail) {
        this.captainEmail = captainEmail;
    }

    @Temporal(value = TemporalType.TIMESTAMP)
    @Column(name="expected_arrival_date")
    public Date getExpectedArrivalDate() {
        return expectedArrivalDate;
    }

    public void setExpectedArrivalDate(Date expectedArrivalDate) {
        this.expectedArrivalDate = expectedArrivalDate;
    }

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "bookingInfo")
    public Set<Ticket> getTickets() {
        return tickets;
    }

    public void setTickets(Set<Ticket> tickets) {
        this.tickets = tickets;
    }

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "bookingInfo")
    public Set<BookingWaypointLocation> getWaypointLocations() {
        return waypointLocations;
    }

    public void setWaypointLocations(Set<BookingWaypointLocation> waypointLocations) {
        this.waypointLocations = waypointLocations;
    }
    @Transient
    public TripType getTripTypeValue(){
        return TripType.getTripType(this.tripType);
    }
    public void setTripType(TripType type){
        this.tripType = type.getCode();
    }

}
