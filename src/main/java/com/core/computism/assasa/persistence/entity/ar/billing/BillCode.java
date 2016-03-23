package com.core.computism.assasa.persistence.entity.ar.billing;

import com.core.computism.assasa.persistence.entity.pos.BaseEntity;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.sql.Timestamp;
import java.util.Date;

/**
 * Created by VD on 3/23/2016.
 */
@Entity
@Table(name = "bi_bill_code")
public class BillCode extends BaseEntity{
    private Integer billCodeTypeId;
    private Integer addOnGroupId;
    private String name;
    private String description;
    private Date activationDate;
    private Date deactivationDate;
    private Integer status;

    @Basic
    @Column(name = "bill_code_type_id", nullable = true, insertable = true, updatable = true)
    public Integer getBillCodeTypeId() {
        return billCodeTypeId;
    }

    public void setBillCodeTypeId(Integer billCodeTypeId) {
        this.billCodeTypeId = billCodeTypeId;
    }

    @Basic
    @Column(name = "add_on_group_id", nullable = true, insertable = true, updatable = true)
    public Integer getAddOnGroupId() {
        return addOnGroupId;
    }

    public void setAddOnGroupId(Integer addOnGroupId) {
        this.addOnGroupId = addOnGroupId;
    }

    @Basic
    @Column(name = "name", nullable = true, insertable = true, updatable = true, length = 30)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "description", nullable = true, insertable = true, updatable = true, length = 255)
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Basic
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "activation_date", nullable = true, insertable = true, updatable = true)
    public Date getActivationDate() {
        return activationDate;
    }

    public void setActivationDate(Date activationDate) {
        this.activationDate = activationDate;
    }

    @Basic
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "deactivation_date", nullable = true, insertable = true, updatable = true)
    public Date getDeactivationDate() {
        return deactivationDate;
    }

    public void setDeactivationDate(Date deactivationDate) {
        this.deactivationDate = deactivationDate;
    }

    @Basic
    @Column(name = "status", nullable = true, insertable = true, updatable = true)
    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }



   }
