package com.core.computism.assasa.pos.domain;

/**
 * Created by VD on 4/15/2016.
 */
public class PosOrderItemDto {
    private Long itemId;
    private Integer quantity;

    public Long getItemId() {
        return itemId;
    }

    public void setItemId(Long itemId) {
        this.itemId = itemId;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }
}
