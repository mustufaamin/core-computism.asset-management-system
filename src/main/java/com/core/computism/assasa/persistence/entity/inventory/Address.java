package com.core.computism.assasa.persistence.entity.inventory;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.Collection;
import java.util.List;

/**
 * Created by VD on 2/9/2016.
 */
@Entity
@Table(name = "address")
public class Address extends BaseEntity {

    private String locationAddress;
    private String city;
    private String country;
    private List<Customer> customersById;
    private List<Supplier> suppliersById;


    @Basic
    @Column(name = "location_address", nullable = true, insertable = true, updatable = true, length = 500)
    public String getLocationAddress() {
        return locationAddress;
    }

    public void setLocationAddress(String locationAddress) {
        this.locationAddress = locationAddress;
    }

    @Basic
    @Column(name = "city", nullable = true, insertable = true, updatable = true, length = 45)
    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    @Basic
    @Column(name = "country", nullable = true, insertable = true, updatable = true, length = 45)
    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    @OneToMany(mappedBy = "addresses")
    public List<Customer> getCustomersById() {
        return customersById;
    }

    public void setCustomersById(List<Customer> customersById) {
        this.customersById = customersById;
    }

    @OneToMany(mappedBy = "addresses")
    public List<Supplier> getSuppliersById() {
        return suppliersById;
    }

    public void setSuppliersById(List<Supplier> suppliersById) {
        this.suppliersById = suppliersById;
    }
}
