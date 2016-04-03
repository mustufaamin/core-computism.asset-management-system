package com.core.computism.assasa.ar.dto;

import com.fasterxml.jackson.annotation.JsonAutoDetect;

import java.math.BigDecimal;
import java.util.Date;

/**
 * Created by VD on 2/19/2016.
 */
@JsonAutoDetect
public class ArAccountDto {

    private Long customerId;
    private Long accountTypeId;
    private BigDecimal currentBalance;
    private Integer accountStatus;
    private Integer companyId;
    private Integer createdBy;
    private Date modifiedDate;
    private Integer modifiedBy;
    private Date activationDate;
    private Date deactivationDate;

    public Long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
    }

    public Long getAccountTypeId() {
        return accountTypeId;
    }

    public void setAccountTypeId(Long accountTypeId) {
        this.accountTypeId = accountTypeId;
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
