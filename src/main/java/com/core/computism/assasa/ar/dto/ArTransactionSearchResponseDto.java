package com.core.computism.assasa.ar.dto;

import com.core.computism.assasa.ar.service.ArAccountService;
import com.core.computism.assasa.exception.ArBusinessException;
import com.core.computism.assasa.persistence.entity.ar.Transaction;
import com.core.computism.assasa.persistence.entity.ar.account.ArAccount;
import com.core.computism.assasa.persistence.entity.cmn.Customer;
import com.core.computism.assasa.persistence.entity.gl.JournalEntry;
import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.springframework.beans.factory.annotation.Autowired;

import java.math.BigDecimal;
import java.util.Date;

/**
 * Created by VD on 5/9/2016.
 */
@JsonAutoDetect
@JsonIgnoreProperties(ignoreUnknown = true)
public class ArTransactionSearchResponseDto {

    private Long arAccountId;
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
    private Long glAccountId;
    private Integer transactionSubType;
    private BigDecimal totalAmount;
    private Boolean suppressOnStatement;
    private Long customerId;
    private String customerFullName;

    public ArTransactionSearchResponseDto() {
    }

    public ArTransactionSearchResponseDto(Transaction transaction, ArAccount arAccount) {
        this.arAccountId = arAccount.getId();
        this.statementId = transaction.getStatementId();
        this.referenceId = transaction.getReferenceId();
        this.sourceId = transaction.getSourceId();
        this.transactionDate = transaction.getTransactionDate();
        this.transactionType = transaction.getTransactionType();
        this.amount = transaction.getAmount();
        this.status = transaction.getStatus();
        this.statementDescription1 = transaction.getStatementDescription1();
        this.statementDescription2 = transaction.getStatementDescription2();
        this.description = transaction.getDescription();
        this.postingDate = transaction.getPostingDate();
        this.chargeCustomerId = transaction.getChargeCustomerId();
        this.createdBy = transaction.getCreatedBy();
        this.glAccountId = transaction.getId();
        this.transactionSubType = transaction.getTransactionSubType();
        this.totalAmount = transaction.getTotalAmount();
        this.suppressOnStatement = transaction.getSuppressOnStatement();
        Customer customer = arAccount.getCustomer();
        if(customer !=null) {
            this.customerFullName = customer.getCustomerFullName();
            this.customerId = customer.getId();
        }
    }

    public Long getArAccountId() {
        return arAccountId;
    }

    public void setArAccountId(Long arAccountId) {
        this.arAccountId = arAccountId;
    }

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

    public Long getGlAccountId() {
        return glAccountId;
    }

    public void setGlAccountId(Long glAccountId) {
        this.glAccountId = glAccountId;
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

    public Long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
    }

    public String getCustomerFullName() {
        return customerFullName;
    }

    public void setCustomerFullName(String customerFullName) {
        this.customerFullName = customerFullName;
    }
}
