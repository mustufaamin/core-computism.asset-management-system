package com.core.computism.assasa.persistence.entity.gl.admin;

import com.core.computism.assasa.persistence.entity.gl.BaseEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Created by VD on 2/21/2016.
 */
@Entity
@Table(name = "ac_account_type")
public class AccountType extends BaseEntity {

    private String description;
    private String name;
    private Integer normalBalanceFlag;

    @Column(name = "description")
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Column(name = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Column(name = "normal_balance_flag")
    public Integer getNormalBalanceFlag() {
        return normalBalanceFlag;
    }

    public void setNormalBalanceFlag(Integer normalBalanceFlag) {
        this.normalBalanceFlag = normalBalanceFlag;
    }
}
