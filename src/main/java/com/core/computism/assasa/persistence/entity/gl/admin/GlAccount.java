package com.core.computism.assasa.persistence.entity.gl.admin;

import com.core.computism.assasa.persistence.entity.gl.BaseEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.Date;

/**
 * Created by VD on 2/27/2016.
 */
@Entity
@Table(name = "ac_gl_account")
public class GlAccount extends BaseEntity {

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

    @Column(name = "company_id")
    public Integer getCompanyId() {
        return companyId;
    }

    public void setCompanyId(Integer companyId) {
        this.companyId = companyId;
    }

    @Column(name = "dept_id")
    public Integer getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(Integer departmentId) {
        this.departmentId = departmentId;
    }

    @Column(name = "major_acct_num")
    public Integer getMajorAccountNumber() {
        return majorAccountNumber;
    }

    public void setMajorAccountNumber(Integer majorAccountNumber) {
        this.majorAccountNumber = majorAccountNumber;
    }

    @Column(name = "account_type_id")
    public Boolean getAccountTypeId() {
        return accountTypeId;
    }

    public void setAccountTypeId(Boolean accountTypeId) {
        this.accountTypeId = accountTypeId;
    }

    @Column(name = "acct_usage_type")
    public Integer getAccountUsageType() {
        return accountUsageType;
    }

    public void setAccountUsageType(Integer accountUsageType) {
        this.accountUsageType = accountUsageType;
    }

    @Column(name = "short_desc")
    public String getShortDescription() {
        return shortDescription;
    }

    public void setShortDescription(String shortDescription) {
        this.shortDescription = shortDescription;
    }

    @Column(name = "long_desc")
    public String getLongDescription() {
        return longDescription;
    }

    public void setLongDescription(String longDescription) {
        this.longDescription = longDescription;
    }

    @Column(name = "activation_date")
    public Date getActivationDate() {
        return activationDate;
    }

    public void setActivationDate(Date activationDate) {
        this.activationDate = activationDate;
    }

    @Column(name = "termination_date")
    public Date getTerminationDate() {
        return terminationDate;
    }

    public void setTerminationDate(Date terminationDate) {
        this.terminationDate = terminationDate;
    }

    @Column(name = "ext_acct_num")
    public String getExtAcctNum() {
        return extAcctNum;
    }

    public void setExtAcctNum(String extAcctNum) {
        this.extAcctNum = extAcctNum;
    }

    @Column(name = "changed_by")
    public Integer getChangedBy() {
        return changedBy;
    }

    public void setChangedBy(Integer changedBy) {
        this.changedBy = changedBy;
    }

    @Column(name = "status")
    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    @Column(name = "is_transferred")
    public Integer getTransferred() {
        return transferred;
    }

    public void setTransferred(Integer transferred) {
        this.transferred = transferred;
    }

    @Column(name = "detailed_view_on_posting")
    public Boolean getDetailedViewOnPosting() {
        return detailedViewOnPosting;
    }

    public void setDetailedViewOnPosting(Boolean detailedViewOnPosting) {
        this.detailedViewOnPosting = detailedViewOnPosting;
    }

    @Column(name = "allow_manual_JE_entries_against_CA")
    public Boolean getAllowManualJEEntriesAgainstCA() {
        return allowManualJEEntriesAgainstCA;
    }

    public void setAllowManualJEEntriesAgainstCA(Boolean allowManualJEEntriesAgainstCA) {
        this.allowManualJEEntriesAgainstCA = allowManualJEEntriesAgainstCA;
    }

    @Column(name = "is_multi_currency")
    public Boolean getMultiCurrency() {
        return multiCurrency;
    }

    public void setMultiCurrency(Boolean multiCurrency) {
        this.multiCurrency = multiCurrency;
    }

    @Column(name = "account_nature")
    public Boolean getAccountNature() {
        return accountNature;
    }

    public void setAccountNature(Boolean accountNature) {
        this.accountNature = accountNature;
    }
}
