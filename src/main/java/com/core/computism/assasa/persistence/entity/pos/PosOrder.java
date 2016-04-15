package com.core.computism.assasa.persistence.entity.pos;

import com.core.computism.assasa.persistence.entity.cmn.Currency;
import com.core.computism.assasa.persistence.entity.cmn.Customer;
import com.core.computism.assasa.pos.domain.type.PosOrderStatus;

import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;
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
    private Integer status;

    private PosOrderStatus posOrderStatus;

    private Customer customer;
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

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    @Transient
    public PosOrderStatus getPosOrderStatus() {
        return PosOrderStatus.getPosOrderStatus(getStatus());
    }

    public void setPosOrderStatus(PosOrderStatus posOrderStatus) {
        this.status = posOrderStatus.getCode();
    }

    @Basic
    @Column(name = "number_of_items", nullable = true, insertable = true, updatable = true)




    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "customer_Id", referencedColumnName = "id", nullable = false)
    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "posOrder")
    public List<PosOrderItem> getPosOrderItems() {
        return posOrderItems;
    }

    public void setPosOrderItems(List<PosOrderItem> posOrderItems) {
        this.posOrderItems = posOrderItems;
    }

}
