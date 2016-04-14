package com.core.computism.assasa.ar.dto;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.math.BigDecimal;
import java.util.Date;

/**
 * Created by VD on 3/6/2016.
 */
@JsonAutoDetect
@JsonIgnoreProperties(ignoreUnknown = true)
public class PaymentDto {

    private Long arAccountId;
    private Integer referenceArAccountId;
    private Long paymentTypeId;
    private BigDecimal paymentAmount;
    private Date paymentDate;
    private Date postedDate;
    private Integer processedBy;
    private String description;
    private String note;
    private Integer status;
    private Integer createdBy;
    private Integer modifiedBy;
    private Integer batchId;
    private Integer source;
    private Boolean suppressOnStatement;
    private String statementDescription2;
    private Integer referenceId;

    public Long getArAccountId() {
        return arAccountId;
    }

    public void setArAccountId(Long arAccountId) {
        this.arAccountId = arAccountId;
    }

    public Integer getReferenceArAccountId() {
        return referenceArAccountId;
    }

    public void setReferenceArAccountId(Integer referenceArAccountId) {
        this.referenceArAccountId = referenceArAccountId;
    }

    public Long getPaymentTypeId() {
        return paymentTypeId;
    }

    public void setPaymentTypeId(Long paymentTypeId) {
        this.paymentTypeId = paymentTypeId;
    }

    public BigDecimal getPaymentAmount() {
        return paymentAmount;
    }

    public void setPaymentAmount(BigDecimal paymentAmount) {
        this.paymentAmount = paymentAmount;
    }

    public Date getPaymentDate() {
        return paymentDate;
    }

    public void setPaymentDate(Date paymentDate) {
        this.paymentDate = paymentDate;
    }

    public Date getPostedDate() {
        return postedDate;
    }

    public void setPostedDate(Date postedDate) {
        this.postedDate = postedDate;
    }

    public Integer getProcessedBy() {
        return processedBy;
    }

    public void setProcessedBy(Integer processedBy) {
        this.processedBy = processedBy;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
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

    public Integer getBatchId() {
        return batchId;
    }

    public void setBatchId(Integer batchId) {
        this.batchId = batchId;
    }

    public Integer getSource() {
        return source;
    }

    public void setSource(Integer source) {
        this.source = source;
    }

    public Boolean getSuppressOnStatement() {
        return suppressOnStatement;
    }

    public void setSuppressOnStatement(Boolean suppressOnStatement) {
        this.suppressOnStatement = suppressOnStatement;
    }

    public String getStatementDescription2() {
        return statementDescription2;
    }

    public void setStatementDescription2(String statementDescription2) {
        this.statementDescription2 = statementDescription2;
    }

    public Integer getReferenceId() {
        return referenceId;
    }

    public void setReferenceId(Integer referenceId) {
        this.referenceId = referenceId;
    }
}
