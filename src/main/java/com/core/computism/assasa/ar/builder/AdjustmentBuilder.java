package com.core.computism.assasa.ar.builder;

import com.core.computism.assasa.persistence.entity.ar.Adjustment;
import com.core.computism.assasa.persistence.entity.ar.Payment;
import com.core.computism.assasa.persistence.entity.ar.account.ArAccount;
import com.core.computism.assasa.persistence.entity.ar.billing.BillCode;

import java.math.BigDecimal;
import java.util.Date;

/**
 * Created by VD on 4/14/2016.
 */
public class AdjustmentBuilder {

    private ArAccount arAccount;
    private BillCode billCode;
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

    public AdjustmentBuilder setArAccount(ArAccount arAccount) {
        this.arAccount = arAccount;
        return this;
    }

    public AdjustmentBuilder setBillCode(BillCode billCode) {
        this.billCode = billCode;
        return this;
    }

    public AdjustmentBuilder setAdjustmentDate(Date adjustmentDate) {
        this.adjustmentDate = adjustmentDate;
        return this;
    }

    public AdjustmentBuilder setAmount(BigDecimal amount) {
        this.amount = amount;
        return this;
    }

    public AdjustmentBuilder setAdjustmentType(Integer adjustmentType) {
        this.adjustmentType = adjustmentType;
        return this;
    }

    public AdjustmentBuilder setStatus(Integer status) {
        this.status = status;
        return this;
    }

    public AdjustmentBuilder setBatchId(Integer batchId) {
        this.batchId = batchId;
        return this;
    }

    public AdjustmentBuilder setDescription(String description) {
        this.description = description;
        return this;
    }

    public AdjustmentBuilder setStatementDescription2(String statementDescription2) {
        this.statementDescription2 = statementDescription2;
        return this;
    }

    public AdjustmentBuilder setNote(String note) {
        this.note = note;
        return this;
    }

    public AdjustmentBuilder setSuppressOnStatement(Boolean suppressOnStatement) {
        this.suppressOnStatement = suppressOnStatement;
        return this;
    }

    public AdjustmentBuilder setExcludeValueAdded(Boolean excludeValueAdded) {
        this.excludeValueAdded = excludeValueAdded;
        return this;
    }

    public AdjustmentBuilder setCreatedBy(Integer createdBy) {
        this.createdBy = createdBy;
        return this;
    }

    public AdjustmentBuilder setModifiedBy(Integer modifiedBy) {
        this.modifiedBy = modifiedBy;
        return this;
    }

    public ArAccount getArAccount() {
        return arAccount;
    }

    public BillCode getBillCode() {
        return billCode;
    }

    public Date getAdjustmentDate() {
        return adjustmentDate;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public Integer getAdjustmentType() {
        return adjustmentType;
    }

    public Integer getStatus() {
        return status;
    }

    public Integer getBatchId() {
        return batchId;
    }

    public String getDescription() {
        return description;
    }

    public String getStatementDescription2() {
        return statementDescription2;
    }

    public String getNote() {
        return note;
    }

    public Boolean getSuppressOnStatement() {
        return suppressOnStatement;
    }

    public Boolean getExcludeValueAdded() {
        return excludeValueAdded;
    }

    public Integer getCreatedBy() {
        return createdBy;
    }

    public Integer getModifiedBy() {
        return modifiedBy;
    }

    public Adjustment build() {

        Adjustment adjustment = new Adjustment();
        adjustment.setArAccount(this.getArAccount());
        adjustment.setBillCode(this.getBillCode());
        adjustment.setAmount(this.getAmount());
        adjustment.setAdjustmentDate(this.getAdjustmentDate());
        adjustment.setDescription(this.getDescription());
        adjustment.setNote(this.getNote());
        adjustment.setStatus(this.getStatus());
        adjustment.setCreatedBy(this.getCreatedBy());
        adjustment.setModifiedBy(this.getModifiedBy());
        adjustment.setBatchId(this.getBatchId());
        adjustment.setSuppressOnStatement(this.getSuppressOnStatement());
        adjustment.setStatementDescription2(this.getStatementDescription2());

        return adjustment;
    }
}
