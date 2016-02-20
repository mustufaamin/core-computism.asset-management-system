package com.core.computism.assasa.persistence.entity.inventory;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import java.util.Collection;
import java.util.List;

/**
 * Created by VD on 2/9/2016.
 */
@Entity
public class Supplier extends BaseEntity {

    private String name;
    private String mobileNumber;
    private String phoneNumber;
    private String officeNumber;
    private List<Item> items;
    private List<PurchaseOrder> purchaseOrders;
    private Address addresses;

    @Basic
    @Column(name = "name", nullable = true, insertable = true, updatable = true, length = 255)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    @Basic
    @Column(name = "mobile_number", nullable = true, insertable = true, updatable = true, length = 45)
    public String getMobileNumber() {
        return mobileNumber;
    }

    public void setMobileNumber(String mobileNumber) {
        this.mobileNumber = mobileNumber;
    }

    @Basic
    @Column(name = "phone_number", nullable = true, insertable = true, updatable = true, length = 45)
    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    @Basic
    @Column(name = "office_number", nullable = true, insertable = true, updatable = true, length = 45)
    public String getOfficeNumber() {
        return officeNumber;
    }

    public void setOfficeNumber(String officeNumber) {
        this.officeNumber = officeNumber;
    }

    @OneToMany(mappedBy = "supplierRef")
    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }

    @OneToMany(mappedBy = "supplier")
    public List<PurchaseOrder> getPurchaseOrders() {
        return purchaseOrders;
    }

    public void setPurchaseOrders(List<PurchaseOrder> purchaseOrders) {
        this.purchaseOrders = purchaseOrders;
    }

    @ManyToOne
    @JoinColumn(name = "address", referencedColumnName = "id", nullable = false)
    public Address getAddresses() {
        return addresses;
    }

    public void setAddresses(Address addresses) {
        this.addresses = addresses;
    }
}
