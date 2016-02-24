package com.core.computism.assasa.gl.dto;

import com.fasterxml.jackson.annotation.JsonAutoDetect;

/**
 * Created by VD on 2/21/2016.
 */
@JsonAutoDetect
public class AccountTypeDto {

    private String description;
    private String name;
    private Integer normalBalanceFlag;

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
