package com.core.computism.assasa.ar.dto;

import com.core.computism.assasa.persistence.entity.ar.account.ArAccount;
import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.math.BigDecimal;
import java.util.Date;

/**
 * Created by VD on 5/3/2016.
 */
@JsonAutoDetect
@JsonIgnoreProperties(ignoreUnknown = true)
public class ArAccountSearchResponseDto {

    private Long customerId;
    private String customerName;
    private Long accountTypeId;
    private String accountTypeName;
    private BigDecimal currentBalance;
    private Integer accountStatus;
    private Integer companyId;
    private Integer createdBy;
    private Date modifiedDate;
    private Integer modifiedBy;
    private Date activationDate;
    private Date deactivationDate;

    public ArAccountSearchResponseDto() {

    }

    public ArAccountSearchResponseDto(ArAccount arAccount) {
        this.customerId = arAccount.getCustomer().getId();
        this.customerName = arAccount.getCustomer().getCustomerFullName();
        this.accountTypeId = arAccount.getArAccountType().getId();
        this.accountTypeName = arAccount.getArAccountType().getAccountTypeName();
        this.currentBalance = arAccount.getCurrentBalance();
        this.accountStatus = arAccount.getAccountStatus();
        this.companyId = arAccount.getCompanyId();
        this.createdBy = arAccount.getCreatedBy();
        this.modifiedDate = arAccount.getLastModifiedDate();
        this.modifiedBy = arAccount.getModifiedBy();
        this.activationDate = arAccount.getActivationDate();
        this.deactivationDate = arAccount.getDeactivationDate();
    }

    public Long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public Long getAccountTypeId() {
        return accountTypeId;
    }

    public void setAccountTypeId(Long accountTypeId) {
        this.accountTypeId = accountTypeId;
    }

    public String getAccountTypeName() {
        return accountTypeName;
    }

    public void setAccountTypeName(String accountTypeName) {
        this.accountTypeName = accountTypeName;
    }

    public BigDecimal getCurrentBalance() {
        return currentBalance;
    }

    public void setCurrentBalance(BigDecimal currentBalance) {
        this.currentBalance = currentBalance;
    }

    public Integer getAccountStatus() {
        return accountStatus;
    }

    public void setAccountStatus(Integer accountStatus) {
        this.accountStatus = accountStatus;
    }

    public Integer getCompanyId() {
        return companyId;
    }

    public void setCompanyId(Integer companyId) {
        this.companyId = companyId;
    }

    public Integer getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(Integer createdBy) {
        this.createdBy = createdBy;
    }

    public Date getModifiedDate() {
        return modifiedDate;
    }

    public void setModifiedDate(Date modifiedDate) {
        this.modifiedDate = modifiedDate;
    }

    public Integer getModifiedBy() {
        return modifiedBy;
    }

    public void setModifiedBy(Integer modifiedBy) {
        this.modifiedBy = modifiedBy;
    }

    public Date getActivationDate() {
        return activationDate;
    }

    public void setActivationDate(Date activationDate) {
        this.activationDate = activationDate;
    }

    public Date getDeactivationDate() {
        return deactivationDate;
    }

    public void setDeactivationDate(Date deactivationDate) {
        this.deactivationDate = deactivationDate;
    }
}
