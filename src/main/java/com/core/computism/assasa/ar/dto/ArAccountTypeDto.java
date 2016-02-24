package com.core.computism.assasa.ar.dto;

import com.fasterxml.jackson.annotation.JsonAutoDetect;

/**
 * Created by VD on 2/21/2016.
 */
@JsonAutoDetect
public class ArAccountTypeDto {

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

    public String getAccountTypeName() {
        return accountTypeName;
    }

    public void setAccountTypeName(String accountTypeName) {
        this.accountTypeName = accountTypeName;
    }

    public String getAccountTypeDesc() {
        return accountTypeDesc;
    }

    public void setAccountTypeDesc(String accountTypeDesc) {
        this.accountTypeDesc = accountTypeDesc;
    }

    public Integer getGlAccountId() {
        return glAccountId;
    }

    public void setGlAccountId(Integer glAccountId) {
        this.glAccountId = glAccountId;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getCompanyId() {
        return companyId;
    }

    public void setCompanyId(Integer companyId) {
        this.companyId = companyId;
    }

    public String getAccountTypeCode() {
        return accountTypeCode;
    }

    public void setAccountTypeCode(String accountTypeCode) {
        this.accountTypeCode = accountTypeCode;
    }

    public Integer getPriority() {
        return priority;
    }

    public void setPriority(Integer priority) {
        this.priority = priority;
    }

    public Boolean getLeftOverAmount() {
        return leftOverAmount;
    }

    public void setLeftOverAmount(Boolean leftOverAmount) {
        this.leftOverAmount = leftOverAmount;
    }

    public Boolean getRequiredStatus() {
        return requiredStatus;
    }

    public void setRequiredStatus(Boolean requiredStatus) {
        this.requiredStatus = requiredStatus;
    }

    public String getOver30Message() {
        return over30Message;
    }

    public void setOver30Message(String over30Message) {
        this.over30Message = over30Message;
    }

    public String getOver60Message() {
        return over60Message;
    }

    public void setOver60Message(String over60Message) {
        this.over60Message = over60Message;
    }

    public String getOver90Message() {
        return over90Message;
    }

    public void setOver90Message(String over90Message) {
        this.over90Message = over90Message;
    }

    public String getOver120Message() {
        return over120Message;
    }

    public void setOver120Message(String over120Message) {
        this.over120Message = over120Message;
    }

    public Integer getShowAgingMessage() {
        return showAgingMessage;
    }

    public void setShowAgingMessage(Integer showAgingMessage) {
        this.showAgingMessage = showAgingMessage;
    }
}
