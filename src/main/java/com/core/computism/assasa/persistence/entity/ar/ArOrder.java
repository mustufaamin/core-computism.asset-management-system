package com.core.computism.assasa.persistence.entity.ar;

import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.sql.Timestamp;
import java.util.Date;

/**
 * Created by VD on 5/22/2016.
 */
@Entity
@Table(name = "ar_order", schema = "", catalog = "assasa")
public class ArOrder extends BaseEntity {

    private String subject;
    private Integer status;
    private Date orderDeliveredDate;

    private ArQuotation arQuotation;



    @Basic
    @Column(name = "subject", nullable = true, insertable = true, updatable = true, length = 255)
    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    @Basic
    @Column(name = "status", nullable = true, insertable = true, updatable = true)
    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    @Basic
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "order_delivered_date", nullable = true, insertable = true, updatable = true)

    public Date getOrderDeliveredDate() {
        return orderDeliveredDate;
    }

    public void setOrderDeliveredDate(Date orderDeliveredDate) {
        this.orderDeliveredDate = orderDeliveredDate;
    }

    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "quotation_id", referencedColumnName = "id", nullable = false)
    public ArQuotation getArQuotation() {
        return arQuotation;
    }

    public void setArQuotation(ArQuotation arQuotation) {
        this.arQuotation = arQuotation;
    }
}
