package com.core.computism.assasa.persistence.entity.ar;

import com.core.computism.assasa.persistence.entity.ar.account.ArAccount;
import com.core.computism.assasa.persistence.entity.ar.billing.BillCode;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import java.math.BigDecimal;
import java.util.Date;

/**
 * Created by VD on 4/13/2016.
 */
@Entity
@Table(name = "ar_adjustment")
public class Adjustment extends BaseEntity {
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

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "ar_account_id", referencedColumnName = "id", nullable = false)
    public ArAccount getArAccount() {
        return arAccount;
    }

    public void setArAccount(ArAccount arAccount) {
        this.arAccount = arAccount;
    }

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "bill_code_id", referencedColumnName = "id", nullable = false)
    public BillCode getBillCode() {
        return billCode;
    }

    public void setBillCode(BillCode billCode) {
        this.billCode = billCode;
    }

    @Column(name = "adjustment_date")
    public Date getAdjustmentDate() {
        return adjustmentDate;
    }

    public void setAdjustmentDate(Date adjustmentDate) {
        this.adjustmentDate = adjustmentDate;
    }

    @Column(name = "amount")
    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    @Column(name = "adjustment_type")
    public Integer getAdjustmentType() {
        return adjustmentType;
    }

    public void setAdjustmentType(Integer adjustmentType) {
        this.adjustmentType = adjustmentType;
    }

    @Column(name = "status")
    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    @Column(name = "batch_id")
    public Integer getBatchId() {
        return batchId;
    }

    public void setBatchId(Integer batchId) {
        this.batchId = batchId;
    }

    @Column(name = "description")
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Column(name = "statement_description_2")
    public String getStatementDescription2() {
        return statementDescription2;
    }

    public void setStatementDescription2(String statementDescription2) {
        this.statementDescription2 = statementDescription2;
    }

    @Column(name = "note")
    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    @Column(name = "suppress_on_statement")
    public Boolean getSuppressOnStatement() {
        return suppressOnStatement;
    }

    public void setSuppressOnStatement(Boolean suppressOnStatement) {
        this.suppressOnStatement = suppressOnStatement;
    }

    @Column(name = "exclude_value_added")
    public Boolean getExcludeValueAdded() {
        return excludeValueAdded;
    }

    public void setExcludeValueAdded(Boolean excludeValueAdded) {
        this.excludeValueAdded = excludeValueAdded;
    }

    @Column(name = "created_by")
    public Integer getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(Integer createdBy) {
        this.createdBy = createdBy;
    }

    @Column(name = "modified_by")
    public Integer getModifiedBy() {
        return modifiedBy;
    }

    public void setModifiedBy(Integer modifiedBy) {
        this.modifiedBy = modifiedBy;
    }
}
