package com.core.computism.assasa.persistence.entity.booking;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.SqlResultSetMapping;

/**
 * Created by M.Mustufa Amin Shah on 9/11/2015.
 */

@Entity
@SqlResultSetMapping(name = "BookingWaypoint")
public class BookingWaypoint {

    private Integer id;
    private Integer bookingId;
    private Double waypointLatitude;
    private Double waypointLongitude;
    private Integer priority;
    private Integer waypointStatus;


    @Id
    @Column(name = "id")
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }


    @Column(name = "booking_id")
    public Integer getBookingId() {
        return bookingId;
    }

    public void setBookingId(Integer bookingId) {
        this.bookingId = bookingId;
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

    @Column(name = "waypoint_priority")
    public Integer getPriority() {
        return priority;
    }

    public void setPriority(Integer priority) {
        this.priority = priority;
    }

    @Column(name = "waypoint_status")
    public Integer getWaypointStatus() {
        return waypointStatus;
    }

    public void setWaypointStatus(Integer waypointStatus) {
        this.waypointStatus = waypointStatus;
    }
}
