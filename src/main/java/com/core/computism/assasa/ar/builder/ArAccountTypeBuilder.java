package com.core.computism.assasa.ar.builder;

import com.core.computism.assasa.persistence.entity.ar.account.ArAccountType;

/**
 * Created by VD on 2/21/2016.
 */
public class ArAccountTypeBuilder {

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

    public ArAccountTypeBuilder setAccountTypeName(String accountTypeName) {
        this.accountTypeName = accountTypeName;
        return this;
    }

    public ArAccountTypeBuilder setAccountTypeDesc(String accountTypeDesc) {
        this.accountTypeDesc = accountTypeDesc;
        return this;
    }

    public ArAccountTypeBuilder setGlAccountId(Integer glAccountId) {
        this.glAccountId = glAccountId;
        return this;
    }

    public ArAccountTypeBuilder setStatus(Integer status) {
        this.status = status;
        return this;
    }

    public ArAccountTypeBuilder setCompanyId(Integer companyId) {
        this.companyId = companyId;
        return this;
    }

    public ArAccountTypeBuilder setAccountTypeCode(String accountTypeCode) {
        this.accountTypeCode = accountTypeCode;
        return this;
    }

    public ArAccountTypeBuilder setPriority(Integer priority) {
        this.priority = priority;
        return this;
    }

    public ArAccountTypeBuilder setLeftOverAmount(Boolean leftOverAmount) {
        this.leftOverAmount = leftOverAmount;
        return this;
    }

    public ArAccountTypeBuilder setRequiredStatus(Boolean requiredStatus) {
        this.requiredStatus = requiredStatus;
        return this;
    }

    public ArAccountTypeBuilder setOver30Message(String over30Message) {
        this.over30Message = over30Message;
        return this;
    }

    public ArAccountTypeBuilder setOver60Message(String over60Message) {
        this.over60Message = over60Message;
        return this;
    }

    public ArAccountTypeBuilder setOver90Message(String over90Message) {
        this.over90Message = over90Message;
        return this;
    }

    public ArAccountTypeBuilder setOver120Message(String over120Message) {
        this.over120Message = over120Message;
        return this;
    }

    public ArAccountTypeBuilder setShowAgingMessage(Integer showAgingMessage) {
        this.showAgingMessage = showAgingMessage;
        return this;
    }

    public String getAccountTypeName() {
        return accountTypeName;
    }

    public String getAccountTypeDesc() {
        return accountTypeDesc;
    }

    public Integer getGlAccountId() {
        return glAccountId;
    }

    public Integer getStatus() {
        return status;
    }

    public Integer getCompanyId() {
        return companyId;
    }

    public String getAccountTypeCode() {
        return accountTypeCode;
    }

    public Integer getPriority() {
        return priority;
    }

    public Boolean getLeftOverAmount() {
        return leftOverAmount;
    }

    public Boolean getRequiredStatus() {
        return requiredStatus;
    }

    public String getOver30Message() {
        return over30Message;
    }

    public String getOver60Message() {
        return over60Message;
    }

    public String getOver90Message() {
        return over90Message;
    }

    public String getOver120Message() {
        return over120Message;
    }

    public Integer getShowAgingMessage() {
        return showAgingMessage;
    }

    public ArAccountType build() {

        ArAccountType arAccountType = new ArAccountType();
        arAccountType.setAccountTypeName(this.accountTypeName);
        arAccountType.setAccountTypeDesc(this.accountTypeDesc);
        arAccountType.setGlAccountId(this.glAccountId);
        arAccountType.setStatus(this.status);
        arAccountType.setCompanyId(this.companyId);
        arAccountType.setAccountTypeCode(this.accountTypeCode);
        arAccountType.setPriority(this.priority);
        arAccountType.setLeftOverAmount(this.leftOverAmount);
        arAccountType.setRequiredStatus(this.requiredStatus);
        arAccountType.setOver30Message(this.over30Message);
        arAccountType.setOver60Message(this.over60Message);
        arAccountType.setOver90Message(this.over90Message);
        arAccountType.setOver120Message(this.over120Message);
        arAccountType.setShowAgingMessage(this.showAgingMessage);

        return arAccountType;
    }
}
