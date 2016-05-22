package com.core.computism.assasa.persistence.entity.ar;

import com.core.computism.assasa.persistence.entity.cmn.Address;
import com.core.computism.assasa.persistence.entity.cmn.Currency;
import com.core.computism.assasa.persistence.entity.cmn.Customer;

import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import java.math.BigDecimal;
import java.sql.Timestamp;

/**
 * Created by VD on 5/22/2016.
 */
@Entity
@Table(name = "ar_quotation", schema = "", catalog = "assasa")
public class ArQuotation extends BaseEntity {

    private String subject;
    private String quoteNumber;
    private String careOf;
    private Integer numberOfItems;
    private BigDecimal totalAmount;

    private Customer customer;
    private Currency currency;
    private Address address;


    @Basic
    @Column(name = "subject", nullable = true, insertable = true, updatable = true, length = 255)
    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    @Basic
    @Column(name = "quote_number", nullable = true, insertable = true, updatable = true, length = 255)
    public String getQuoteNumber() {
        return quoteNumber;
    }

    public void setQuoteNumber(String quoteNumber) {
        this.quoteNumber = quoteNumber;
    }

    @Basic
    @Column(name = "care_of", nullable = true, insertable = true, updatable = true, length = 255)
    public String getCareOf() {
        return careOf;
    }

    public void setCareOf(String careOf) {
        this.careOf = careOf;
    }

    @Basic
    @Column(name = "number_of_items", nullable = true, insertable = true, updatable = true)
    public Integer getNumberOfItems() {
        return numberOfItems;
    }

    public void setNumberOfItems(Integer numberOfItems) {
        this.numberOfItems = numberOfItems;
    }

    @Basic
    @Column(name = "total_amount", nullable = true, insertable = true, updatable = true, precision = 2)
    public BigDecimal getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(BigDecimal totalAmount) {
        this.totalAmount = totalAmount;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "customer_Id", referencedColumnName = "id", nullable = false)
    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "currency_id", referencedColumnName = "id", nullable = false)
    public Currency getCurrency() {
        return currency;
    }

    public void setCurrency(Currency currency) {
        this.currency = currency;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "address_id", referencedColumnName = "id", nullable = false)
    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }
}
