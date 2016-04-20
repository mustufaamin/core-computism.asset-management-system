package com.core.computism.assasa.persistence.entity.cmn;

import com.core.computism.assasa.persistence.entity.pos.BaseEntity;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * Created by VD on 3/13/2016.
 */
@Entity
@Table(name = "cmn_city")
public class City extends BaseEntity {
    private String name;
    private String state;
    private Country country;

    @Basic
    @Column(name = "name", nullable = true, insertable = true, updatable = true, length = 255)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "state", nullable = true, insertable = true, updatable = true, length = 255)
    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "country_id", referencedColumnName = "id", nullable = false)
    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }
}
