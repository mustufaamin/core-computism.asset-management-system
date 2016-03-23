package com.core.computism.assasa.persistence.entity.ar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.math.BigDecimal;
import java.util.Date;

/**
 * Created by VD on 3/19/2016.
 */
@Entity
@Table(name = "ar_transaction")
public class Transaction extends BaseEntity {


    @Column(name = "ar_account_id")
    private Integer arAccountId;

    @Column(name = "statement_id")
    private Integer statementId;

    @Column(name = "reference_id")
    private Integer referenceId;

    @Column(name = "source_id")
    private Integer sourceId;

    @Column(name = "transaction_date")
    private Date transactionDate;

    @Column(name = "transaction_type")
    private Integer transactionType;

    @Column(name = "amount")
    private BigDecimal amount;

    @Column(name = "status")
    private Integer status;

    @Column(name = "stmt_desc_1")
    private String statementDescription1;

    @Column(name = "stmt_desc_2")
    private String statementDescription2;

    @Column(name = "description")
    private String description;

    @Column(name = "posting_date")
    private Date postingDate;

    @Column(name = "charge_customerId")
    private Integer chargeCustomerId;

    @Column(name = "created_by")
    private Integer createdBy;

    @Column(name = "glaccount_id")
    private Integer glAccountId;

    @Column(name = "journal_entry_id")
    private Integer journalEntryId;

    @Column(name = "transaction_sub_type")
    private Integer transactionSubType;

    @Column(name = "total_amount")
    private BigDecimal totalAmount;

    @Column(name = "suppress_on_statement")
    private Boolean suppressOnStatement;

    public Integer getStatementId() {
        return statementId;
    }

    public void setStatementId(Integer statementId) {
        this.statementId = statementId;
    }

    public Integer getReferenceId() {
        return referenceId;
    }

    public void setReferenceId(Integer referenceId) {
        this.referenceId = referenceId;
    }

    public Integer getSourceId() {
        return sourceId;
    }

    public void setSourceId(Integer sourceId) {
        this.sourceId = sourceId;
    }

    public Date getTransactionDate() {
        return transactionDate;
    }

    public void setTransactionDate(Date transactionDate) {
        this.transactionDate = transactionDate;
    }

    public Integer getTransactionType() {
        return transactionType;
    }

    public void setTransactionType(Integer transactionType) {
        this.transactionType = transactionType;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getStatementDescription1() {
        return statementDescription1;
    }

    public void setStatementDescription1(String statementDescription1) {
        this.statementDescription1 = statementDescription1;
    }

    public String getStatementDescription2() {
        return statementDescription2;
    }

    public void setStatementDescription2(String statementDescription2) {
        this.statementDescription2 = statementDescription2;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getPostingDate() {
        return postingDate;
    }

    public void setPostingDate(Date postingDate) {
        this.postingDate = postingDate;
    }

    public Integer getChargeCustomerId() {
        return chargeCustomerId;
    }

    public void setChargeCustomerId(Integer chargeCustomerId) {
        this.chargeCustomerId = chargeCustomerId;
    }

    public Integer getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(Integer createdBy) {
        this.createdBy = createdBy;
    }

    public Integer getGlAccountId() {
        return glAccountId;
    }

    public void setGlAccountId(Integer glaccountId) {
        this.glAccountId = glaccountId;
    }

    public Integer getJournalEntryId() {
        return journalEntryId;
    }

    public void setJournalEntryId(Integer journalEntryId) {
        this.journalEntryId = journalEntryId;
    }

    public Integer getTransactionSubType() {
        return transactionSubType;
    }

    public void setTransactionSubType(Integer transactionSubType) {
        this.transactionSubType = transactionSubType;
    }

    public BigDecimal getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(BigDecimal totalAmount) {
        this.totalAmount = totalAmount;
    }

    public Boolean getSuppressOnStatement() {
        return suppressOnStatement;
    }

    public void setSuppressOnStatement(Boolean suppressOnStatement) {
        this.suppressOnStatement = suppressOnStatement;
    }

    public Integer getArAccountId() {
        return arAccountId;
    }

    public void setArAccountId(Integer arAccountId) {
        this.arAccountId = arAccountId;
    }
}
