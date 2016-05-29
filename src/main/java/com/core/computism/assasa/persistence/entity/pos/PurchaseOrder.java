package com.core.computism.assasa.persistence.entity.pos;

import com.core.computism.assasa.persistence.entity.common.Currency;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * Created by VD on 2/9/2016.
 */
@Entity
@Table(name = "purchase_order")
public class PurchaseOrder extends BaseEntity {

    private Integer invoiceNumber;
    private Integer batchNumber;
    private Integer totalItems;
    private Integer totalAmount;
    private Supplier supplier;
    private Currency currency;


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
    @Column(name = "total_items", nullable = true, insertable = true, updatable = true)
    public Integer getTotalItems() {
        return totalItems;
    }

    public void setTotalItems(Integer totalItems) {
        this.totalItems = totalItems;
    }

    @Basic
    @Column(name = "total_amount", nullable = true, insertable = true, updatable = true)
    public Integer getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(Integer totalAmount) {
        this.totalAmount = totalAmount;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "supplier_id", referencedColumnName = "id", nullable = false)
    public Supplier getSupplier() {
        return supplier;
    }

    public void setSupplier(Supplier supplier) {
        this.supplier = supplier;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "currency_id", nullable = false)

    public Currency getCurrency() {
        return currency;
    }

    public void setCurrency(Currency currency) {
        this.currency = currency;
    }
}
