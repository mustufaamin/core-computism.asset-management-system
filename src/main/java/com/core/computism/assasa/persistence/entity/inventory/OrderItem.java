package com.core.computism.assasa.persistence.entity.inventory;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Created by VD on 2/9/2016.
 */
@Entity
@Table(name = "order_item")
public class OrderItem extends BaseEntity {

    private Integer itemId;
    private Integer orderId;
    private Integer quantity;

    @Basic
    @Column(name = "item_id", nullable = true, insertable = true, updatable = true)
    public Integer getItemId() {
        return itemId;
    }

    public void setItemId(Integer itemId) {
        this.itemId = itemId;
    }

    @Basic
    @Column(name = "order_id", nullable = true, insertable = true, updatable = true)
    public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
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
