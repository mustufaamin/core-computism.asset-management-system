package com.core.computism.assasa.domain;

import com.core.computism.assasa.persistence.entity.inventory.Address;
import com.core.computism.assasa.persistence.entity.inventory.Item;
import com.core.computism.assasa.persistence.entity.inventory.PurchaseOrder;
import com.fasterxml.jackson.annotation.JsonAutoDetect;

import java.util.List;

/**
 * Created by VD on 2/28/2016.
 */
@JsonAutoDetect
public class SupplierDto {
    private String name;
    private String mobileNumber;
    private String phoneNumber;
    private String officeNumber;
    private String locationAddress;
    private String city;
    private String country;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMobileNumber() {
        return mobileNumber;
    }

    public void setMobileNumber(String mobileNumber) {
        this.mobileNumber = mobileNumber;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getOfficeNumber() {
        return officeNumber;
    }

    public void setOfficeNumber(String officeNumber) {
        this.officeNumber = officeNumber;
    }

    public String getLocationAddress() {
        return locationAddress;
    }

    public void setLocationAddress(String locationAddress) {
        this.locationAddress = locationAddress;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }
}
