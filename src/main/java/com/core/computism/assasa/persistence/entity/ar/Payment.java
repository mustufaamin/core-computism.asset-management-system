package com.core.computism.assasa.persistence.entity.ar;

import com.core.computism.assasa.ar.enumtype.TransactionType;
import com.core.computism.assasa.ar.transaction.IPostable;
import com.core.computism.assasa.persistence.entity.gl.JournalEntry;
import javax.persistence.Transient;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.math.BigDecimal;
import java.util.Date;

/**
 * Created by VD on 3/6/2016.
 */
@Entity
@Table(name = "ar_payment")
public class Payment extends BaseEntity implements IPostable {

    private Integer arAccountId;
    private Integer referenceArAccountId;
    private Integer paymentTypeId;
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

    @Column(name = "ar_account_id")
    public Integer getArAccountId() {
        return arAccountId;
    }

    public void setArAccountId(Integer arAccountId) {
        this.arAccountId = arAccountId;
    }

    @Column(name = "reference_ar_account_id")
    public Integer getReferenceArAccountId() {
        return referenceArAccountId;
    }

    public void setReferenceArAccountId(Integer referenceArAccountId) {
        this.referenceArAccountId = referenceArAccountId;
    }

    @Column(name = "payment_type_id")
    public Integer getPaymentTypeId() {
        return paymentTypeId;
    }

    public void setPaymentTypeId(Integer paymentTypeId) {
        this.paymentTypeId = paymentTypeId;
    }

    @Column(name = "payment_amount")
    public BigDecimal getPaymentAmount() {
        return paymentAmount;
    }

    public void setPaymentAmount(BigDecimal paymentAmount) {
        this.paymentAmount = paymentAmount;
    }

    @Column(name = "payment_date")
    public Date getPaymentDate() {
        return paymentDate;
    }

    public void setPaymentDate(Date paymentDate) {
        this.paymentDate = paymentDate;
    }

    @Column(name = "posted_date")
    public Date getPostedDate() {
        return postedDate;
    }

    public void setPostedDate(Date postedDate) {
        this.postedDate = postedDate;
    }

    @Column(name = "processed_by")
    public Integer getProcessedBy() {
        return processedBy;
    }

    public void setProcessedBy(Integer processedBy) {
        this.processedBy = processedBy;
    }

    @Column(name = "description")
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Column(name = "note")
    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    @Column(name = "status")
    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
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

    @Column(name = "batch_id")
    public Integer getBatchId() {
        return batchId;
    }

    public void setBatchId(Integer batchId) {
        this.batchId = batchId;
    }

    @Column(name = "source")
    public Integer getSource() {
        return source;
    }

    public void setSource(Integer source) {
        this.source = source;
    }

    @Column(name = "suppress_on_statement")
    public Boolean getSuppressOnStatement() {
        return suppressOnStatement;
    }

    public void setSuppressOnStatement(Boolean suppressOnStatement) {
        this.suppressOnStatement = suppressOnStatement;
    }

    @Column(name = "statement_description_2")
    public String getStatementDescription2() {
        return statementDescription2;
    }

    public void setStatementDescription2(String statementDescription2) {
        this.statementDescription2 = statementDescription2;
    }

    @Column(name = "reference_id")
    public Integer getReferenceId() {
        return referenceId;
    }

    @Transient
    public Long getArTransactionReferenceId() {
        return this.getId();
    }

    @Transient
    public int getArTransactionSourceId() {
        return 0;
    }

    @Transient
    public Date getArTransactionDate() {
        return this.paymentDate;
    }



    @Transient
    public int getArTransactionType() {
        return TransactionType.PAYMENT_TR_ID.getCode();
    }

    @Transient
    public BigDecimal getArTransactionAmount() {
        return this.getPaymentAmount().negate();
    }

    @Transient
    public String getArTransactionStatementDescription1() {
        return this.getDescription();
    }

    @Transient
    public String getArTransactionStatementDescription2() {
        return this.getStatementDescription2();
    }

    @Transient
    public String getArTransactionInternalDescription() {
        return "";
    }

    @Transient
    public int getGlAccountId() {
        return this.getPaymentTypeId();
    }

    @Transient
    public JournalEntry getJournalEntry() {
        return null;
    }

    @Transient
    public int getArTransactionSubType() {
        return TransactionType.PAYMENT_TR_ID.getCode();
    }

    public void setReferenceId(Integer referenceId) {
        this.referenceId = referenceId;
    }
}
