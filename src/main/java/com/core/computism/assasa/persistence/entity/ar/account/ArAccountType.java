package com.core.computism.assasa.persistence.entity.ar.account;

import com.core.computism.assasa.persistence.entity.ar.BaseEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Created by VD on 2/21/2016.
 */
@Entity
@Table(name = "ar_account_type")
public class ArAccountType extends BaseEntity {

    private String accountTypeName;
    private String accountTypeDesc;
    private Integer glAccountId;
    private Integer status;
    private Integer companyId;
    private String accountTypeCode;
    private Integer priority;
    private Boolean leftOverAmount;
    private Boolean requiredStatus;
    private String over30Message;
    private String over60Message;
    private String over90Message;
    private String over120Message;
    private Integer showAgingMessage;

    @Column(name = "account_type_name")
    public String getAccountTypeName() {
        return accountTypeName;
    }

    public void setAccountTypeName(String accountTypeName) {
        this.accountTypeName = accountTypeName;
    }

    @Column(name = "account_type_desc")
    public String getAccountTypeDesc() {
        return accountTypeDesc;
    }

    public void setAccountTypeDesc(String accountTypeDesc) {
        this.accountTypeDesc = accountTypeDesc;
    }

    @Column(name = "gl_account_id")
    public Integer getGlAccountId() {
        return glAccountId;
    }

    public void setGlAccountId(Integer glAccountId) {
        this.glAccountId = glAccountId;
    }

    @Column(name = "status")
    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    @Column(name = "company_id")
    public Integer getCompanyId() {
        return companyId;
    }

    public void setCompanyId(Integer companyId) {
        this.companyId = companyId;
    }

    @Column(name = "account_type_code")
    public String getAccountTypeCode() {
        return accountTypeCode;
    }

    public void setAccountTypeCode(String accountTypeCode) {
        this.accountTypeCode = accountTypeCode;
    }

    @Column(name = "priority")
    public Integer getPriority() {
        return priority;
    }

    public void setPriority(Integer priority) {
        this.priority = priority;
    }

    @Column(name = "is_left_over_amount")
    public Boolean getLeftOverAmount() {
        return leftOverAmount;
    }

    public void setLeftOverAmount(Boolean leftOverAmount) {
        this.leftOverAmount = leftOverAmount;
    }

    @Column(name = "required_status")
    public Boolean getRequiredStatus() {
        return requiredStatus;
    }

    public void setRequiredStatus(Boolean requiredStatus) {
        this.requiredStatus = requiredStatus;
    }

    @Column(name = "over30_message")
    public String getOver30Message() {
        return over30Message;
    }

    public void setOver30Message(String over30Message) {
        this.over30Message = over30Message;
    }

    @Column(name = "over60_message")
    public String getOver60Message() {
        return over60Message;
    }

    public void setOver60Message(String over60Message) {
        this.over60Message = over60Message;
    }

    @Column(name = "over90_message")
    public String getOver90Message() {
        return over90Message;
    }

    public void setOver90Message(String over90Message) {
        this.over90Message = over90Message;
    }

    @Column(name = "over120_message")
    public String getOver120Message() {
        return over120Message;
    }

    public void setOver120Message(String over120Message) {
        this.over120Message = over120Message;
    }

    @Column(name = "show_aging_message")
    public Integer getShowAgingMessage() {
        return showAgingMessage;
    }

    public void setShowAgingMessage(Integer showAgingMessage) {
        this.showAgingMessage = showAgingMessage;
    }
}
