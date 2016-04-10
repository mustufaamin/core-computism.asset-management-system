package com.core.computism.assasa.persistence.entity.pos;

import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.List;

/**
 * Created by M.Mustufa Amin Shah on 2/9/2016.
 */
@Entity
@Table(name = "pos_order")
public class PosOrder extends BaseEntity{

    private Integer invoiceNumber;
    private Integer batchNumber;
    private Integer totalAmount;
    private Integer numberOfItems;

    private Customer customer;
    private Currency currency;
    private List<PosPayment>  posPayments;
    private List<PosOrderItem> posOrderItems;

    @Basic
    @Column(name = "invoice_number", nullable = true, insertable = true, updatable = true)
    public Integer getInvoiceNumber() {
        return invoiceNumber;
    }

    public void setInvoiceNumber(Integer invoiceNumber) {
        this.invoiceNumber = invoiceNumber;
    }

    @Basic
    @Column(name = "batch_number", nullable = true, insertable = true, updatable = true)
    public Integer getBatchNumber() {
        return batchNumber;
    }

    public void setBatchNumber(Integer batchNumber) {
        this.batchNumber = batchNumber;
    }

    @Basic
    @Column(name = "total_amount", nullable = true, insertable = true, updatable = true)
    public Integer getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(Integer totalAmount) {
        this.totalAmount = totalAmount;
    }


    @Basic
    @Column(name = "number_of_items", nullable = true, insertable = true, updatable = true)
    public Integer getNumberOfItems() {
        return numberOfItems;
    }

    public void setNumberOfItems(Integer numberOfItems) {
        this.numberOfItems = numberOfItems;
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
    @JoinColumn(name = "currency_id",  nullable = false)

    public Currency getCurrency() {
        return currency;
    }

    public void setCurrency(Currency currency) {
        this.currency = currency;
    }

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "posOrder")
    public List<PosOrderItem> getPosOrderItems() {
        return posOrderItems;
    }

    public void setPosOrderItems(List<PosOrderItem> posOrderItems) {
        this.posOrderItems = posOrderItems;
    }

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "posOrder")
    public List<PosPayment> getPosPayments() {
        return posPayments;
    }

    public void setPosPayments(List<PosPayment> posPayments) {
        this.posPayments = posPayments;
    }
}
