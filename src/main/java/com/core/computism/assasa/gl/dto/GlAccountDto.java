package com.core.computism.assasa.gl.dto;

import com.fasterxml.jackson.annotation.JsonAutoDetect;

import java.util.Date;

/**
 * Created by VD on 2/27/2016.
 */
@JsonAutoDetect
public class GlAccountDto {

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

    public GlAccountDto() {}

    public Integer getCompanyId() {
        return companyId;
    }

    public void setCompanyId(Integer companyId) {
        this.companyId = companyId;
    }

    public Integer getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(Integer departmentId) {
        this.departmentId = departmentId;
    }

    public Integer getMajorAccountNumber() {
        return majorAccountNumber;
    }

    public void setMajorAccountNumber(Integer majorAccountNumber) {
        this.majorAccountNumber = majorAccountNumber;
    }

    public Boolean getAccountTypeId() {
        return accountTypeId;
    }

    public void setAccountTypeId(Boolean accountTypeId) {
        this.accountTypeId = accountTypeId;
    }

    public Integer getAccountUsageType() {
        return accountUsageType;
    }

    public void setAccountUsageType(Integer accountUsageType) {
        this.accountUsageType = accountUsageType;
    }

    public String getShortDescription() {
        return shortDescription;
    }

    public void setShortDescription(String shortDescription) {
        this.shortDescription = shortDescription;
    }

    public String getLongDescription() {
        return longDescription;
    }

    public void setLongDescription(String longDescription) {
        this.longDescription = longDescription;
    }

    public Date getActivationDate() {
        return activationDate;
    }

    public void setActivationDate(Date activationDate) {
        this.activationDate = activationDate;
    }

    public Date getTerminationDate() {
        return terminationDate;
    }

    public void setTerminationDate(Date terminationDate) {
        this.terminationDate = terminationDate;
    }

    public String getExtAcctNum() {
        return extAcctNum;
    }

    public void setExtAcctNum(String extAcctNum) {
        this.extAcctNum = extAcctNum;
    }

    public Integer getChangedBy() {
        return changedBy;
    }

    public void setChangedBy(Integer changedBy) {
        this.changedBy = changedBy;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getTransferred() {
        return transferred;
    }

    public void setTransferred(Integer transferred) {
        this.transferred = transferred;
    }

    public Boolean getDetailedViewOnPosting() {
        return detailedViewOnPosting;
    }

    public void setDetailedViewOnPosting(Boolean detailedViewOnPosting) {
        this.detailedViewOnPosting = detailedViewOnPosting;
    }

    public Boolean getAllowManualJEEntriesAgainstCA() {
        return allowManualJEEntriesAgainstCA;
    }

    public void setAllowManualJEEntriesAgainstCA(Boolean allowManualJEEntriesAgainstCA) {
        this.allowManualJEEntriesAgainstCA = allowManualJEEntriesAgainstCA;
    }

    public Boolean getMultiCurrency() {
        return multiCurrency;
    }

    public void setMultiCurrency(Boolean multiCurrency) {
        this.multiCurrency = multiCurrency;
    }

    public Boolean getAccountNature() {
        return accountNature;
    }

    public void setAccountNature(Boolean accountNature) {
        this.accountNature = accountNature;
    }
}
