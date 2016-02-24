package com.core.computism.assasa.persistence.entity.ticket;

import com.core.computism.assasa.ar.entity.BaseEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * Created by M.Mustufa Amin Shah on 9/11/2015.
 */
@Entity
@Table(name = "booking_waypoint_location")
public class BookingWaypointLocation extends BaseEntity {

    private BookingInfo bookingInfo;
    private Double waypointLatitude;
    private Double waypointLongitude;
    private Integer priority;
    private Integer waypointStatus;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "booking_info_id")
    public BookingInfo getBookingInfo() {
        return bookingInfo;
    }

    public void setBookingInfo(BookingInfo bookingInfo) {
        this.bookingInfo = bookingInfo;
    }

    @Column(name = "waypoint_latitude")
    public Double getWaypointLatitude() {
        return waypointLatitude;
    }

    public void setWaypointLatitude(Double waypointLatitude) {
        this.waypointLatitude = waypointLatitude;
    }

    @Column(name = "waypoint_longitude")
    public Double getWaypointLongitude() {
        return waypointLongitude;
    }

    public void setWaypointLongitude(Double waypointLongitude) {
        this.waypointLongitude = waypointLongitude;
    }

    @Column(name = "priority", precision = 11, scale = 0)
    public Integer getPriority() {
        return priority;
    }

    public void setPriority(Integer priority) {
        this.priority = priority;
    }

    @Column(name = "waypoint_status", precision = 11, scale = 0)
    public Integer getWaypointStatus() {
        return waypointStatus;
    }

    public void setWaypointStatus(Integer waypointStatus) {
        this.waypointStatus = waypointStatus;
    }
}
