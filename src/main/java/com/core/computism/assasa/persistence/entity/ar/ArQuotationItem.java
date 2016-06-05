package com.core.computism.assasa.persistence.entity.ar;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * Created by VD on 5/22/2016.
 */
@Entity
@Table(name = "ar_quotation_item", schema = "assasa", catalog = "assasa")
public class ArQuotationItem extends BaseEntity{

    private ArQuotation arQuotation;
    private ArItem arItem;
    private Integer quantity;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "quotation_id", referencedColumnName = "id", nullable = false)
    public ArQuotation getArQuotation() {
        return arQuotation;
    }

    public void setArQuotation(ArQuotation arQuotation) {
        this.arQuotation = arQuotation;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "item_id", referencedColumnName = "id", nullable = false)
    public ArItem getArItem() {
        return arItem;
    }

    public void setArItem(ArItem arItem) {
        this.arItem = arItem;
    }

    @Basic
    @Column(name="quantity")
    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }
}
