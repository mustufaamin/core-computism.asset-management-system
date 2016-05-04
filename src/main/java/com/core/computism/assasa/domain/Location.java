package com.core.computism.assasa.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * Created by M.Mustufa on 9/15/2015.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class Location {

    private static final Double RADIAN_CONST = Math.PI / 180.0;
    private static final long serialVersionUID = -7170537262334836002L;

    private Double latitude;
    private Double longitude;

    public Location() {}

    public Location(Double latitude, Double longitude) {
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public Double getLatitude() {
        return latitude;
    }

    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

    public Double getLongitude() {
        return longitude;
    }

    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }

    public Double getRadianLatitude() {
        return RADIAN_CONST * latitude;
    }
    public Double getRadianLongitude() {
        return RADIAN_CONST * longitude;
    }


    @Override
    public String toString() {
        return new StringBuilder(
                "Latitude [" + latitude
                        + "], Longitude [" + longitude + "]"
        ).toString();
    }
}
