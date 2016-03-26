package com.core.computism.assasa.persistence.entity.pos;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * Created by VD on 2/9/2016.
 */
@Entity
@Table(name = "pos_order_item")
public class PosOrderItem extends BaseEntity {

    private PosItem PosItem;
    private PosOrder posOrder;
    private Integer quantity;

    @ManyToOne
    @JoinColumn(name = "item_id", referencedColumnName = "id", nullable = false)
    public PosItem getPosItem() {
        return PosItem;
    }

    public void setPosItem(PosItem posItem) {
        PosItem = posItem;
    }
    @ManyToOne
    @JoinColumn(name = "order_id", referencedColumnName = "id", nullable = false)
    public PosOrder getPosOrder() {
        return posOrder;
    }

    public void setPosOrder(PosOrder posOrder) {
        this.posOrder = posOrder;
    }

    @Basic
    @Column(name = "quantity", nullable = true, insertable = true, updatable = true)
    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }
}
