package com.core.computism.assasa.persistence.entity.pos;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.Date;

/**
 * Created by VD on 3/23/2016.
 */
@Entity
@Table(name = "pos_payment")
public class PosPayment extends BaseEntity {
    private Date paymentDate;
    private BigDecimal amount;
    private Integer terminalId;
    private Integer transactionId;

    private PosOrder posOrder;
    private PosPaymentType posPaymentType;

    @Basic
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "payment_date", nullable = true, insertable = true, updatable = true)
    public Date getPaymentDate() {
        return paymentDate;
    }
    public void setPaymentDate(Date paymentDate) {
        this.paymentDate = paymentDate;
    }

    @Basic
    @Column(name = "amount", nullable = true, insertable = true, updatable = true, precision = 2)
    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    @Basic
    @Column(name = "terminal_id", nullable = true, insertable = true, updatable = true)
    public Integer getTerminalId() {
        return terminalId;
    }

    public void setTerminalId(Integer terminalId) {
        this.terminalId = terminalId;
    }

    @Basic
    @Column(name = "transaction_id", nullable = true, insertable = true, updatable = true)
    public Integer getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(Integer transactionId) {
        this.transactionId = transactionId;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "payment_type_id", referencedColumnName = "id", nullable = false)
    public PosPaymentType getPosPaymentType() {
        return posPaymentType;
    }

    public void setPosPaymentType(PosPaymentType posPaymentType) {
        this.posPaymentType = posPaymentType;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "order_id", referencedColumnName = "id", nullable = false)
    public PosOrder getPosOrder() {
        return posOrder;
    }

    public void setPosOrder(PosOrder posOrder) {
        this.posOrder = posOrder;
    }
}
