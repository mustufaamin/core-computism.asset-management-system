package com.core.computism.assasa.gl.builder;

import com.core.computism.assasa.gl.entity.AccountType;

/**
 * Created by VD on 2/21/2016.
 */
public class AccountTypeBuilder {

    private String description;
    private String name;
    private Integer normalBalanceFlag;

    public AccountTypeBuilder setDescription(String description) {
        this.description = description;
        return this;
    }

    public AccountTypeBuilder setName(String name) {
        this.name = name;
        return this;
    }

    public AccountTypeBuilder setNormalBalanceFlag(Integer normalBalanceFlag) {
        this.normalBalanceFlag = normalBalanceFlag;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public String getName() {
        return name;
    }

    public Integer getNormalBalanceFlag() {
        return normalBalanceFlag;
    }

    public AccountType build() {

        AccountType accountType = new AccountType();
        accountType.setDescription(this.getDescription());
        accountType.setName(this.getName());
        accountType.setNormalBalanceFlag(this.getNormalBalanceFlag());

        return accountType;
    }
}
