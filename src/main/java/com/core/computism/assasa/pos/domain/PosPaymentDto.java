package com.core.computism.assasa.pos.domain;

import com.core.computism.assasa.persistence.entity.pos.PosPaymentType;

import java.math.BigDecimal;
import java.util.Date;

/**
 * Created by M.Mustufa Amin Shah on 3/29/2016.
 */
public class PosPaymentDto {

    private Long id;
    private Date paymentDate;
    private BigDecimal amount;
    private Integer terminalId;
    private Integer transactionId;
    private Long posPaymentTypeId;
    private String posPaymentTypeName;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getPaymentDate() {
        return paymentDate;
    }

    public void setPaymentDate(Date paymentDate) {
        this.paymentDate = paymentDate;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public Integer getTerminalId() {
        return terminalId;
    }

    public void setTerminalId(Integer terminalId) {
        this.terminalId = terminalId;
    }

    public Integer getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(Integer transactionId) {
        this.transactionId = transactionId;
    }

    public Long getPosPaymentTypeId() {
        return posPaymentTypeId;
    }

    public void setPosPaymentTypeId(Long posPaymentTypeId) {
        this.posPaymentTypeId = posPaymentTypeId;
    }

    public String getPosPaymentTypeName() {
        return posPaymentTypeName;
    }

    public void setPosPaymentTypeName(String posPaymentTypeName) {
        this.posPaymentTypeName = posPaymentTypeName;
    }
}
