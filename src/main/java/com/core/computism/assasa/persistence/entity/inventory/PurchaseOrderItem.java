package com.core.computism.assasa.persistence.entity.inventory;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Created by VD on 2/9/2016.
 */
@Entity
@Table(name = "purchase_order_item")
public class PurchaseOrderItem extends BaseEntity {
    private Integer itemId;
    private Integer purchaseOrderId;
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
    @Column(name = "purchase_order_id", nullable = true, insertable = true, updatable = true)
    public Integer getPurchaseOrderId() {
        return purchaseOrderId;
    }

    public void setPurchaseOrderId(Integer purchaseOrderId) {
        this.purchaseOrderId = purchaseOrderId;
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
