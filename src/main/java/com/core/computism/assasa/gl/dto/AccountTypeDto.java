package com.core.computism.assasa.gl.dto;

import com.core.computism.assasa.persistence.entity.gl.admin.AccountType;
import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * Created by VD on 2/21/2016.
 */
@JsonAutoDetect
@JsonIgnoreProperties(ignoreUnknown = true)
public class AccountTypeDto {

    public AccountTypeDto(AccountType accountType) {
        this.glAccountId = accountType.getId();
        this.description = accountType.getDescription();
        this.name = accountType.getName();
        this.normalBalanceFlag = accountType.getNormalBalanceFlag();
    }

    public AccountTypeDto() {
    }

    private Long glAccountId;
    private String description;
    private String name;
    private Integer normalBalanceFlag;

    public Long getGlAccountId() {
        return glAccountId;
    }

    public void setGlAccountId(Long glAccountId) {
        this.glAccountId = glAccountId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getNormalBalanceFlag() {
        return normalBalanceFlag;
    }

    public void setNormalBalanceFlag(Integer normalBalanceFlag) {
        this.normalBalanceFlag = normalBalanceFlag;
    }
}
