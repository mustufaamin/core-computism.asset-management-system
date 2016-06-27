package com.core.computism.assasa.common.domain;

import java.math.BigDecimal;
import java.util.Date;

/**
 * Created by Mustafa Amin Shah on 3/13/2016.
 */
public class BatchDto {

    private Long batchId;
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

    public Long getBatchId() {
        return batchId;
    }

    public void setBatchId(Long batchId) {
        this.batchId = batchId;
    }

    public Integer getBatchType() {
        return batchType;
    }

    public void setBatchType(Integer batchType) {
        this.batchType = batchType;
    }

    public Integer getBatchStatus() {
        return batchStatus;
    }

    public void setBatchStatus(Integer batchStatus) {
        this.batchStatus = batchStatus;
    }

    public String getBatchName() {
        return batchName;
    }

    public void setBatchName(String batchName) {
        this.batchName = batchName;
    }

    public Integer getBatchCountMethod() {
        return batchCountMethod;
    }

    public void setBatchCountMethod(Integer batchCountMethod) {
        this.batchCountMethod = batchCountMethod;
    }

    public BigDecimal getBatchAmount() {
        return batchAmount;
    }

    public void setBatchAmount(BigDecimal batchAmount) {
        this.batchAmount = batchAmount;
    }

    public Integer getModuleId() {
        return moduleId;
    }

    public void setModuleId(Integer moduleId) {
        this.moduleId = moduleId;
    }

    public Date getDateOpened() {
        return dateOpened;
    }

    public void setDateOpened(Date dateOpened) {
        this.dateOpened = dateOpened;
    }

    public Integer getOpenedBy() {
        return openedBy;
    }

    public void setOpenedBy(Integer openedBy) {
        this.openedBy = openedBy;
    }

    public Date getClosingDate() {
        return closingDate;
    }

    public void setClosingDate(Date closingDate) {
        this.closingDate = closingDate;
    }

    public Integer getClosedBy() {
        return closedBy;
    }

    public void setClosedBy(Integer closedBy) {
        this.closedBy = closedBy;
    }

    public Integer getCloseOnPosting() {
        return closeOnPosting;
    }

    public void setCloseOnPosting(Integer closeOnPosting) {
        this.closeOnPosting = closeOnPosting;
    }

    @Override
    public String toString() {
        return "BatchDto{" +
                "closeOnPosting=" + closeOnPosting +
                ", closedBy=" + closedBy +
                ", closingDate=" + closingDate +
                ", openedBy=" + openedBy +
                ", dateOpened=" + dateOpened +
                ", moduleId=" + moduleId +
                ", batchAmount=" + batchAmount +
                ", batchCountMethod=" + batchCountMethod +
                ", batchName='" + batchName + '\'' +
                ", batchStatus=" + batchStatus +
                ", batchType=" + batchType +
                '}';
    }
}
