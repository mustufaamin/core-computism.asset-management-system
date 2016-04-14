package com.core.computism.assasa.ar.dto;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.math.BigDecimal;
import java.util.Date;

/**
 * Created by VD on 4/14/2016.
 */
@JsonAutoDetect
@JsonIgnoreProperties(ignoreUnknown = true)
public class AdjustmentDto {

    private Long arAccountId;
    private Long billCodeId;
    private Date adjustmentDate;
    private BigDecimal amount;
    private Integer adjustmentType;
    private Integer status;
    private Integer batchId;
    private String description;
    private String statementDescription2;
    private String note;
    private Boolean suppressOnStatement;
    private Boolean excludeValueAdded;
    private Integer createdBy;
    private Integer modifiedBy;

    public AdjustmentDto() {
    }

    public Long getArAccountId() {
        return arAccountId;
    }

    public void setArAccountId(Long arAccountId) {
        this.arAccountId = arAccountId;
    }

    public Long getBillCodeId() {
        return billCodeId;
    }

    public void setBillCodeId(Long billCodeId) {
        this.billCodeId = billCodeId;
    }

    public Date getAdjustmentDate() {
        return adjustmentDate;
    }

    public void setAdjustmentDate(Date adjustmentDate) {
        this.adjustmentDate = adjustmentDate;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public Integer getAdjustmentType() {
        return adjustmentType;
    }

    public void setAdjustmentType(Integer adjustmentType) {
        this.adjustmentType = adjustmentType;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getBatchId() {
        return batchId;
    }

    public void setBatchId(Integer batchId) {
        this.batchId = batchId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getStatementDescription2() {
        return statementDescription2;
    }

    public void setStatementDescription2(String statementDescription2) {
        this.statementDescription2 = statementDescription2;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public Boolean getSuppressOnStatement() {
        return suppressOnStatement;
    }

    public void setSuppressOnStatement(Boolean suppressOnStatement) {
        this.suppressOnStatement = suppressOnStatement;
    }

    public Boolean getExcludeValueAdded() {
        return excludeValueAdded;
    }

    public void setExcludeValueAdded(Boolean excludeValueAdded) {
        this.excludeValueAdded = excludeValueAdded;
    }

    public Integer getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(Integer createdBy) {
        this.createdBy = createdBy;
    }

    public Integer getModifiedBy() {
        return modifiedBy;
    }

    public void setModifiedBy(Integer modifiedBy) {
        this.modifiedBy = modifiedBy;
    }

    @Override
    public String toString() {
        return "AdjustmentDto{" +
                "arAccountId=" + arAccountId +
                ", billCodeId=" + billCodeId +
                ", adjustmentDate=" + adjustmentDate +
                ", amount=" + amount +
                ", adjustmentType=" + adjustmentType +
                ", status=" + status +
                ", batchId=" + batchId +
                ", description='" + description + '\'' +
                ", statementDescription2='" + statementDescription2 + '\'' +
                ", note='" + note + '\'' +
                ", suppressOnStatement=" + suppressOnStatement +
                ", excludeValueAdded=" + excludeValueAdded +
                ", createdBy=" + createdBy +
                ", modifiedBy=" + modifiedBy +
                '}';
    }
}
