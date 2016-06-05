package com.core.computism.assasa.persistence.entity.common;

import com.core.computism.assasa.persistence.entity.pos.BaseEntity;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Created by VD on 3/13/2016.
 */
@Entity
@Table(name = "cmn_country")
public class Country extends BaseEntity {
    private String name;

    @Basic
    @Column(name = "name", nullable = true, insertable = true, updatable = true, length = 255)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
