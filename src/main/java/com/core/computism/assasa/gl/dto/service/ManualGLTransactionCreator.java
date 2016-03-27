package com.core.computism.assasa.gl.dto.service;

import com.core.computism.assasa.persistence.entity.gl.admin.GlAccount;

import java.math.BigDecimal;

/**
 * Created by VD on 3/26/2016.
 */
public class ManualGLTransactionCreator {

    protected GlAccount accountDetail;
    private BigDecimal amount;
    protected BigDecimal quantity;
    private String comment;

    public ManualGLTransactionCreator() {
    }

    public ManualGLTransactionCreator(GlAccount accountDetatil, BigDecimal amount, BigDecimal quantity) {
        this.accountDetail = accountDetatil;
        this.amount = amount;
        this.quantity = quantity;
    }

    public GlAccount getAccountDetail() {
        return accountDetail;
    }

    public void setAccountDetail(GlAccount accountDetail) {
        this.accountDetail = accountDetail;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public BigDecimal getAbsAmount() {
        return this.amount.abs();
    }

    public BigDecimal getQuantity() {
        return quantity;
    }

    public void setQuantity(BigDecimal quantity) {
        this.quantity = quantity;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    @Override
    public String toString() {
        return "ManualGLTransactionCreator{" +
                "accountDetail=" + accountDetail +
                ", amount=" + amount +
                ", quantity=" + quantity +
                ", comment='" + comment + '\'' +
                '}';
    }
}


