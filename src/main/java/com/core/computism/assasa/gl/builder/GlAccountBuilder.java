package com.core.computism.assasa.gl.builder;

import com.core.computism.assasa.gl.entity.admin.GlAccount;

import java.util.Date;

/**
 * Created by VD on 2/27/2016.
 */
public class GlAccountBuilder {

    public Integer companyId;
    public Integer departmentId;
    public Integer majorAccountNumber;
    public Boolean accountTypeId;
    public Integer accountUsageType;
    public String shortDescription;
    public String longDescription;
    public Date activationDate;
    public Date terminationDate;
    public String extAcctNum;
    public Integer changedBy;
    public Integer status;
    public Integer transferred;
    public Boolean detailedViewOnPosting;
    public Boolean allowManualJEEntriesAgainstCA;
    public Boolean multiCurrency;
    public Boolean accountNature;

    public GlAccountBuilder setCompanyId(Integer companyId) {
        this.companyId = companyId;
        return this;
    }

    public GlAccountBuilder setDepartmentId(Integer departmentId) {
        this.departmentId = departmentId;
        return this;
    }

    public GlAccountBuilder setMajorAccountNumber(Integer majorAccountNumber) {
        this.majorAccountNumber = majorAccountNumber;
        return this;
    }

    public GlAccountBuilder setAccountTypeId(Boolean accountTypeId) {
        this.accountTypeId = accountTypeId;
        return this;
    }

    public GlAccountBuilder setAccountUsageType(Integer accountUsageType) {
        this.accountUsageType = accountUsageType;
        return this;
    }

    public GlAccountBuilder setShortDescription(String shortDescription) {
        this.shortDescription = shortDescription;
        return this;
    }

    public GlAccountBuilder setLongDescription(String longDescription) {
        this.longDescription = longDescription;
        return this;
    }

    public GlAccountBuilder setActivationDate(Date activationDate) {
        this.activationDate = activationDate;
        return this;
    }

    public GlAccountBuilder setTerminationDate(Date terminationDate) {
        this.terminationDate = terminationDate;
        return this;
    }

    public GlAccountBuilder setExtAcctNum(String extAcctNum) {
        this.extAcctNum = extAcctNum;
        return this;
    }

    public GlAccountBuilder setChangedBy(Integer changedBy) {
        this.changedBy = changedBy;
        return this;
    }

    public GlAccountBuilder setStatus(Integer status) {
        this.status = status;
        return this;
    }

    public GlAccountBuilder setTransferred(Integer transferred) {
        this.transferred = transferred;
        return this;
    }

    public GlAccountBuilder setDetailedViewOnPosting(Boolean detailedViewOnPosting) {
        this.detailedViewOnPosting = detailedViewOnPosting;
        return this;
    }

    public GlAccountBuilder setAllowManualJEEntriesAgainstCA(Boolean allowManualJEEntriesAgainstCA) {
        this.allowManualJEEntriesAgainstCA = allowManualJEEntriesAgainstCA;
        return this;
    }

    public GlAccountBuilder setMultiCurrency(Boolean multiCurrency) {
        this.multiCurrency = multiCurrency;
        return this;
    }

    public GlAccountBuilder setAccountNature(Boolean accountNature) {
        this.accountNature = accountNature;
        return this;
    }

    public Integer getCompanyId() {
        return companyId;
    }

    public Integer getDepartmentId() {
        return departmentId;
    }

    public Integer getMajorAccountNumber() {
        return majorAccountNumber;
    }

    public Boolean getAccountTypeId() {
        return accountTypeId;
    }

    public Integer getAccountUsageType() {
        return accountUsageType;
    }

    public String getShortDescription() {
        return shortDescription;
    }

    public String getLongDescription() {
        return longDescription;
    }

    public Date getActivationDate() {
        return activationDate;
    }

    public Date getTerminationDate() {
        return terminationDate;
    }

    public String getExtAcctNum() {
        return extAcctNum;
    }

    public Integer getChangedBy() {
        return changedBy;
    }

    public Integer getStatus() {
        return status;
    }

    public Integer getTransferred() {
        return transferred;
    }

    public Boolean getDetailedViewOnPosting() {
        return detailedViewOnPosting;
    }

    public Boolean getAllowManualJEEntriesAgainstCA() {
        return allowManualJEEntriesAgainstCA;
    }

    public Boolean getMultiCurrency() {
        return multiCurrency;
    }

    public Boolean getAccountNature() {
        return accountNature;
    }

    public GlAccount build() {
        GlAccount glAccount = new GlAccount();

        glAccount.setCompanyId(this.getCompanyId());
        glAccount.setDepartmentId(this.getDepartmentId());
        glAccount.setMajorAccountNumber(this.getMajorAccountNumber());
        glAccount.setAccountTypeId(this.getAccountTypeId());
        glAccount.setAccountUsageType(this.getAccountUsageType());
        glAccount.setShortDescription(this.getShortDescription());
        glAccount.setLongDescription(this.getLongDescription());
        glAccount.setActivationDate(this.getActivationDate());
        glAccount.setTerminationDate(this.getTerminationDate());
        glAccount.setExtAcctNum(this.getExtAcctNum());
        glAccount.setChangedBy(this.getChangedBy());
        glAccount.setStatus(this.getStatus());
        glAccount.setTransferred(this.getTransferred());
        glAccount.setDetailedViewOnPosting(this.getDetailedViewOnPosting());
        glAccount.setAllowManualJEEntriesAgainstCA(this.getAllowManualJEEntriesAgainstCA());
        glAccount.setMultiCurrency(this.getMultiCurrency());
        glAccount.setAccountNature(this.getAccountNature());

        return glAccount;
    }
}
