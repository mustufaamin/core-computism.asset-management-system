package com.core.computism.assasa.persistence.entity.ar;

import com.core.computism.assasa.persistence.entity.gl.JournalEntry;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import java.math.BigDecimal;
import java.util.Date;

/**
 * Created by VD on 3/19/2016.
 */
@Entity
@Table(name = "ar_transaction")
public class Transaction extends BaseEntity {

    private Integer arAccountId;
    private Integer statementId;
    private Integer referenceId;
    private Integer sourceId;
    private Date transactionDate;
    private Integer transactionType;
    private BigDecimal amount;
    private Integer status;
    private String statementDescription1;
    private String statementDescription2;
    private String description;
    private Date postingDate;
    private Integer chargeCustomerId;
    private Integer createdBy;
    private Integer glAccountId;
    private JournalEntry journalEntry;
    private Integer transactionSubType;
    private BigDecimal totalAmount;
    private Boolean suppressOnStatement;

    @Column(name = "ar_account_id")
    public Integer getArAccountId() {
        return arAccountId;
    }

    public void setArAccountId(Integer arAccountId) {
        this.arAccountId = arAccountId;
    }

    @Column(name = "statement_id")
    public Integer getStatementId() {
        return statementId;
    }

    public void setStatementId(Integer statementId) {
        this.statementId = statementId;
    }

    @Column(name = "reference_id")
    public Integer getReferenceId() {
        return referenceId;
    }

    public void setReferenceId(Integer referenceId) {
        this.referenceId = referenceId;
    }

    @Column(name = "source_id")
    public Integer getSourceId() {
        return sourceId;
    }

    public void setSourceId(Integer sourceId) {
        this.sourceId = sourceId;
    }

    @Column(name = "transaction_date")
    public Date getTransactionDate() {
        return transactionDate;
    }

    public void setTransactionDate(Date transactionDate) {
        this.transactionDate = transactionDate;
    }

    @Column(name = "transaction_type")
    public Integer getTransactionType() {
        return transactionType;
    }

    public void setTransactionType(Integer transactionType) {
        this.transactionType = transactionType;
    }

    @Column(name = "amount")
    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    @Column(name = "status")
    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    @Column(name = "stmt_desc_1")
    public String getStatementDescription1() {
        return statementDescription1;
    }

    public void setStatementDescription1(String statementDescription1) {
        this.statementDescription1 = statementDescription1;
    }

    @Column(name = "stmt_desc_2")
    public String getStatementDescription2() {
        return statementDescription2;
    }

    public void setStatementDescription2(String statementDescription2) {
        this.statementDescription2 = statementDescription2;
    }

    @Column(name = "description")
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Column(name = "posting_date")
    public Date getPostingDate() {
        return postingDate;
    }

    public void setPostingDate(Date postingDate) {
        this.postingDate = postingDate;
    }

    @Column(name = "charge_customer_id")
    public Integer getChargeCustomerId() {
        return chargeCustomerId;
    }

    public void setChargeCustomerId(Integer chargeCustomerId) {
        this.chargeCustomerId = chargeCustomerId;
    }

    @Column(name = "created_by")
    public Integer getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(Integer createdBy) {
        this.createdBy = createdBy;
    }

    @Column(name = "glaccount_id")
    public Integer getGlAccountId() {
        return glAccountId;
    }

    public void setGlAccountId(Integer glaccountId) {
        this.glAccountId = glaccountId;
    }


    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "journal_entry_id", referencedColumnName = "id", nullable = false)
    public JournalEntry getJournalEntry() {
        return journalEntry;
    }

    public void setJournalEntry(JournalEntry journalEntry) {
        this.journalEntry = journalEntry;
    }

    @Column(name = "transaction_sub_type")
    public Integer getTransactionSubType() {
        return transactionSubType;
    }

    public void setTransactionSubType(Integer transactionSubType) {
        this.transactionSubType = transactionSubType;
    }

    @Column(name = "total_amount")
    public BigDecimal getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(BigDecimal totalAmount) {
        this.totalAmount = totalAmount;
    }

    @Column(name = "suppress_on_statement")
    public Boolean getSuppressOnStatement() {
        return suppressOnStatement;
    }

    public void setSuppressOnStatement(Boolean suppressOnStatement) {
        this.suppressOnStatement = suppressOnStatement;
    }
}
