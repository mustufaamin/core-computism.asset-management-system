package com.core.computism.assasa.persistence.entity.common;

import com.core.computism.assasa.persistence.entity.pos.BaseEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.math.BigDecimal;
import java.util.Date;

/**
 * Created by VD on 6/28/2016.
 */
@Entity
@Table(name = "cmn_batch")
public class Batch extends BaseEntity {

    private Integer batchType;
    private Integer batchStatus;
    private String batchName;
    private Integer batchCountMethod;
    private BigDecimal batchAmount;
    private Integer moduleId;
    private Date dateOpened;
    private Integer openedBy;
    private Date closingDate;
    private Integer closedBy;
    private Integer closeOnPosting;

    public Batch() {
    }

    @Column(name = "batch_type")
    public Integer getBatchType() {
        return batchType;
    }

    public void setBatchType(Integer batchType) {
        this.batchType = batchType;
    }

    @Column(name = "batch_status")
    public Integer getBatchStatus() {
        return batchStatus;
    }

    public void setBatchStatus(Integer batchStatus) {
        this.batchStatus = batchStatus;
    }

    @Column(name = "batch_name")
    public String getBatchName() {
        return batchName;
    }

    public void setBatchName(String batchName) {
        this.batchName = batchName;
    }

    @Column(name = "batch_count_method")
    public Integer getBatchCountMethod() {
        return batchCountMethod;
    }

    public void setBatchCountMethod(Integer batchCountMethod) {
        this.batchCountMethod = batchCountMethod;
    }

    @Column(name = "batch_amount")
    public BigDecimal getBatchAmount() {
        return batchAmount;
    }

    public void setBatchAmount(BigDecimal batchAmount) {
        this.batchAmount = batchAmount;
    }

    @Column(name = "module_id")
    public Integer getModuleId() {
        return moduleId;
    }

    public void setModuleId(Integer moduleId) {
        this.moduleId = moduleId;
    }

    @Column(name = "date_opened")
    public Date getDateOpened() {
        return dateOpened;
    }

    public void setDateOpened(Date dateOpened) {
        this.dateOpened = dateOpened;
    }

    @Column(name = "opened_by")
    public Integer getOpenedBy() {
        return openedBy;
    }

    public void setOpenedBy(Integer openedBy) {
        this.openedBy = openedBy;
    }

    @Column(name = "closing_date")
    public Date getClosingDate() {
        return closingDate;
    }

    public void setClosingDate(Date closingDate) {
        this.closingDate = closingDate;
    }

    @Column(name = "closed_by")
    public Integer getClosedBy() {
        return closedBy;
    }

    public void setClosedBy(Integer closedBy) {
        this.closedBy = closedBy;
    }

    @Column(name = "close_on_posting")
    public Integer getCloseOnPosting() {
        return closeOnPosting;
    }

    public void setCloseOnPosting(Integer closeOnPosting) {
        this.closeOnPosting = closeOnPosting;
    }
}