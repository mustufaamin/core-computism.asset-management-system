package com.core.computism.assasa.persistence.entity.pos;

import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import java.util.List;

/**
 * Created by VD on 2/9/2016.
 */
@Entity
@Table(name = "cc_customer")
public class Customer extends BaseEntity {
    private String firstName;
    private String lastName;
    private String phoneNumber;
    private String mobileNumber;
    private String email;
    private Address address;
    private List<PosOrder> posOrders;

    @Basic
    @Column(name = "first_name", nullable = false, insertable = true, updatable = true, length = 255)
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    @Basic
    @Column(name = "last_name", nullable = true, insertable = true, updatable = true, length = 255)
    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Basic
    @Column(name = "phone_number", nullable = false, insertable = true, updatable = true, length = 45)
    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    @Basic
    @Column(name = "email", nullable = false, insertable = true, updatable = true, length = 255)
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Basic
    @Column(name = "mobile_number", nullable = false, insertable = true, updatable = true, length = 45)
    public String getMobileNumber() {
        return mobileNumber;
    }

    public void setMobileNumber(String mobileNumber) {
        this.mobileNumber = mobileNumber;
    }

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "mailing_address_id", referencedColumnName = "id", nullable = false)
    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    @OneToMany(mappedBy = "customer")
    public List<PosOrder> getPosOrders() {
        return posOrders;
    }

    public void setPosOrders(List<PosOrder> posOrders) {
        this.posOrders = posOrders;
    }
}
