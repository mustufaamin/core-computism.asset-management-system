package com.core.computism.assasa.persistence.entity.cmn;

import com.core.computism.assasa.persistence.entity.pos.BaseEntity;
import com.core.computism.assasa.persistence.entity.pos.PosOrder;
import com.core.computism.assasa.persistence.entity.pos.PurchaseOrder;

import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.List;

/**
 * Created by VD on 2/9/2016.
 */
@Entity
@Table(name = "cmn_currency")
public class Currency extends BaseEntity {

    private String name;
    private String symbol;

    @Basic
    @Column(name = "name", nullable = false, insertable = true, updatable = true, length = 255)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "symbol", nullable = false, insertable = true, updatable = true, length = 3)
    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }
}
