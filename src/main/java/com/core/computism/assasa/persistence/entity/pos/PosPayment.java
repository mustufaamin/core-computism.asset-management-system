package com.core.computism.assasa.persistence.entity.pos;

import com.core.computism.assasa.ar.IJournalizeableItem;
import com.core.computism.assasa.ar.dto.service.IJournalizeable;
import com.core.computism.assasa.ar.enumtype.TransactionType;
import com.core.computism.assasa.persistence.entity.gl.JournalEntry;
import com.core.computism.assasa.persistence.entity.gl.admin.GlAccount;
import com.core.computism.assasa.utilities.ARUtility;

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
import javax.persistence.Transient;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.Date;

/**
 * Created by VD on 3/23/2016.
 */
@Entity
@Table(name = "pos_payment")
public class PosPayment extends BaseEntity implements IJournalizeable {
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

    @Override
    @Transient
    public int getJournalType() {
        return ARUtility.getJournalTypeByTransactionType(TransactionType.PAYMENT_TR_ID.getCode());
    }

    @Override
    @Transient
    public int getJournalSourceType() {
        return ARUtility.getJournalSourceTypeByTransactionType(TransactionType.PAYMENT_TR_ID.getCode());
    }

    @Override
    @Transient
    public int getJournalSourceId() {
        return this.getId().intValue();
    }

    @Override
    @Transient
    public int getSubLedgerAccountId() {
//        return this.getArAccount().getCustomer().getId().intValue();
        //TODO: ask Faizan
        return 0;
    }

    @Override
    @Transient
    public String getSubLedgerAccountName() {
        return null;
    }

    @Override
    @Transient
    public Date getJournalTransactionDate() {
        return this.getPaymentDate();
    }

    @Override
    @Transient
    public int getEntryTotalNature() {

        int i = 1;
        if (new BigDecimal(0).compareTo(this.getAmount()) == 0) {
            i = 1;
        } else {
            i = (int) (this.getAmount().doubleValue() / Math.abs(this.getAmount().doubleValue()));
        }
        return i * -1;

    }

    @Override
    @Transient
    public GlAccount getAccountDetail() {
        //TODO: No GL Account what attached
        return null;
    }

    @Override
    @Transient
    public IJournalizeableItem getJournalizeableControlItem() {
        return null;
    }

    @Override
    @Transient
    public IJournalizeableItem getJournalizeableMainItem() {
//        return this.getPosPaymentType();
        return null;
    }

    @Override
    @Transient
    public BigDecimal getJournalizeableMainItemAmount() {
        return this.getAmount().multiply(new BigDecimal(-1));
    }

    @Override
    @Transient
    public BigDecimal getJournalizeableMainItemQuantity() {
        return new BigDecimal(0.00);
    }

    @Override
    @Transient
    public void setJournalEntry(JournalEntry journalEntry) {

    }
}
