package com.core.computism.assasa.persistence.entity.ar;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.sql.Timestamp;

/**
 * Created by VD on 5/22/2016.
 */
@Entity
@Table(name = "ar_item_type", schema = "assasa", catalog = "assasa")
public class ArItemType extends BaseEntity {

    private String name;


    @Basic
    @Column(name = "name", nullable = true, insertable = true, updatable = true, length = 45)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


}
