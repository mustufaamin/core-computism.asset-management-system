package com.core.computism.assasa.persistence.entity.customer;

import com.core.computism.assasa.persistence.entity.pos.BaseEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Created by VD on 5/22/2016.
 */
@Entity
@Table(name = "cc_customer_type")
public class CustomerType extends BaseEntity {

    private String name;
    private String description;
    private Integer status;

    @Column(name = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Column(name = "description")
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Column(name = "status")
    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
}
