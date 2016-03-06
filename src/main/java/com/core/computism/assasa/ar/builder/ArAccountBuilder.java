package com.core.computism.assasa.ar.builder;

import com.core.computism.assasa.ar.entity.account.ArAccount;

import java.math.BigDecimal;
import java.util.Date;

/**
 * Created by VD on 2/19/2016.
 */
public class ArAccountBuilder {

    private Integer customerId;
    private Integer accountTypeId;
    private BigDecimal currentBalance;
    private Integer accountStatus;
    private Integer companyId;
    private Integer createdBy;
    private Integer modifiedBy;
    private Date activationDate;
    private Date deactivationDate;

    public ArAccountBuilder setCustomerId(Integer customerId) {
        this.customerId = customerId;
        return this;
    }

    public ArAccountBuilder setAccountTypeId(Integer accountTypeId) {
        this.accountTypeId = accountTypeId;
        return this;
    }

    public ArAccountBuilder setCurrentBalance(BigDecimal currentBalance) {
        this.currentBalance = currentBalance;
        return this;
    }

    public ArAccountBuilder setAccountStatus(Integer accountStatus) {
        this.accountStatus = accountStatus;
        return this;
    }

    public ArAccountBuilder setCompanyId(Integer companyId) {
        this.companyId = companyId;
        return this;
    }

    public ArAccountBuilder setCreatedBy(Integer getCreatedBy) {
        this.createdBy = createdBy;
        return this;
    }

    public ArAccountBuilder setModifiedBy(Integer getModifiedBy) {
        this.modifiedBy = modifiedBy;
        return this;
    }

    public ArAccountBuilder setActivationDate(Date activationDate) {
        this.activationDate = activationDate;
        return this;
    }

    public ArAccountBuilder setDeactivationDate(Date deactivationDate) {
        this.deactivationDate = deactivationDate;
        return this;
    }

    public Integer getCustomerId() {
        return customerId;
    }

    public Integer getAccountTypeId() {
        return accountTypeId;
    }

    public BigDecimal getCurrentBalance() {
        return currentBalance;
    }

    public Integer getAccountStatus() {
        return accountStatus;
    }

    public Integer getCompanyId() {
        return companyId;
    }

    public Integer getCreatedBy() {
        return createdBy;
    }

    public Integer getModifiedBy() {
        return modifiedBy;
    }

    public Date getActivationDate() {
        return activationDate;
    }

    public Date getDeactivationDate() {
        return deactivationDate;
    }

    public ArAccount build() {

        ArAccount arAccount = new ArAccount();
        arAccount.setCustomerId(this.customerId);
        arAccount.setAccountTypeId(this.accountTypeId);
        arAccount.setCurrentBalance(this.currentBalance);
        arAccount.setAccountStatus(this.accountStatus);
        arAccount.setCompanyId(this.companyId);
        arAccount.setCreatedBy(this.createdBy);
        arAccount.setModifiedBy(this.modifiedBy);
        arAccount.setActivationDate(this.activationDate);
        arAccount.setDeactivationDate(this.deactivationDate);

        return arAccount;
    }
}
