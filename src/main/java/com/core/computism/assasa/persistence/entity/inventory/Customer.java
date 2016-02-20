package com.core.computism.assasa.persistence.entity.inventory;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.Collection;
import java.util.List;

/**
 * Created by VD on 2/9/2016.
 */
@Entity
@Table(name = "customer")
public class Customer extends BaseEntity {
    private String firstName;
    private String lastName;
    private String phoneNumber;
    private String email;
    private Address addresses;
    private List<Order> orders;

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

    @ManyToOne
    @JoinColumn(name = "mailing_address_id", referencedColumnName = "id", nullable = false)
    public Address getAddresses() {
        return addresses;
    }

    public void setAddresses(Address addresses) {
        this.addresses = addresses;
    }

    @OneToMany(mappedBy = "customer")
    public List<Order> getOrders() {
        return orders;
    }

    public void setOrders(List<Order> orders) {
        this.orders = orders;
    }
}
