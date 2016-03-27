package com.core.computism.assasa.ar.dto.service;

import java.math.BigDecimal;

/**
 * Created by VD on 3/25/2016.
 */
public class JournalizeableItemDetail {

    private BigDecimal amount;
    private BigDecimal quantity;

    public JournalizeableItemDetail() {
    }

    public JournalizeableItemDetail(BigDecimal amount, BigDecimal quantity) {
        this.amount = amount;
        this.quantity = quantity;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public BigDecimal getQuantity() {
        return quantity;
    }

    public void setQuantity(BigDecimal quantity) {
        this.quantity = quantity;
    }

    public Object clone() throws CloneNotSupportedException
    {
        JournalizeableItemDetail journalizeableItemDetail=new JournalizeableItemDetail(this.amount, this.quantity);
        return journalizeableItemDetail;
    }
}
