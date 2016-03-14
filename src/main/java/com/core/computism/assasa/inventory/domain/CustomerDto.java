package com.core.computism.assasa.inventory.domain;

import com.core.computism.assasa.persistence.entity.inventory.Address;
import com.fasterxml.jackson.annotation.JsonAutoDetect;

/**
 * Created by M.Mustafa Amin Shah on 2/28/2016.
 */
@JsonAutoDetect
public class CustomerDto {

    private String firstName;
    private String lastName;
    private String phoneNumber;
    private String mobileNumber;
    private String email;
    private String locationAddress;
    private Long cityId;


    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getLocationAddress() {
        return locationAddress;
    }

    public void setLocationAddress(String locationAddress) {
        this.locationAddress = locationAddress;
    }

    public Long getCityId() {
        return cityId;
    }

    public void setCityId(Long cityId) {
        this.cityId = cityId;
    }

    public String getMobileNumber() {
        return mobileNumber;
    }

    public void setMobileNumber(String mobileNumber) {
        this.mobileNumber = mobileNumber;
    }
}
