package com.core.computism.assasa.persistence.entity.ar;

import com.core.computism.assasa.ar.IJournalizeableItem;
import com.core.computism.assasa.ar.dto.service.IJournalizeable;
import com.core.computism.assasa.ar.enumtype.TransactionType;
import com.core.computism.assasa.ar.transaction.IPostable;
import com.core.computism.assasa.persistence.entity.ar.account.ArAccount;
import com.core.computism.assasa.persistence.entity.gl.JournalEntry;
import com.core.computism.assasa.persistence.entity.gl.admin.GlAccount;
import com.core.computism.assasa.utilities.*;

import javax.persistence.CascadeType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Transient;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.math.BigDecimal;
import java.util.Date;

/**
 * Created by VD on 3/6/2016.
 */
@Entity
@Table(name = "ar_payment")
public class Payment extends BaseEntity implements IPostable, IJournalizeable {

    private ArAccount arAccount;
    private Integer referenceArAccountId;
    private PaymentType paymentType;
    private BigDecimal paymentAmount;
    private Date paymentDate;
    private Date postedDate;
    private Integer processedBy;
    private String description;
    private String note;
    private Integer status;
    private Integer createdBy;
    private Integer modifiedBy;
    private Integer batchId;
    private Integer source;
    private Boolean suppressOnStatement;
    private String statementDescription2;
    private Integer referenceId;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "ar_account_id", referencedColumnName = "id", nullable = false)
    public ArAccount getArAccount() {
        return arAccount;
    }

    public void setArAccount(ArAccount arAccount) {
        this.arAccount = arAccount;
    }

    @Column(name = "reference_ar_account_id")
    public Integer getReferenceArAccountId() {
        return referenceArAccountId;
    }

    public void setReferenceArAccountId(Integer referenceArAccountId) {
        this.referenceArAccountId = referenceArAccountId;
    }

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "payment_type_id", referencedColumnName = "id", nullable = false)
    public PaymentType getPaymentType() {
        return paymentType;
    }

    public void setPaymentType(PaymentType paymentType) {
        this.paymentType = paymentType;
    }

    @Column(name = "payment_amount")
    public BigDecimal getPaymentAmount() {
        return paymentAmount;
    }

    public void setPaymentAmount(BigDecimal paymentAmount) {
        this.paymentAmount = paymentAmount;
    }

    @Column(name = "payment_date")
    public Date getPaymentDate() {
        return paymentDate;
    }

    public void setPaymentDate(Date paymentDate) {
        this.paymentDate = paymentDate;
    }

    @Column(name = "posted_date")
    public Date getPostedDate() {
        return postedDate;
    }

    public void setPostedDate(Date postedDate) {
        this.postedDate = postedDate;
    }

    @Column(name = "processed_by")
    public Integer getProcessedBy() {
        return processedBy;
    }

    public void setProcessedBy(Integer processedBy) {
        this.processedBy = processedBy;
    }

    @Column(name = "description")
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Column(name = "note")
    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    @Column(name = "status")
    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    @Column(name = "created_by")
    public Integer getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(Integer createdBy) {
        this.createdBy = createdBy;
    }

    @Column(name = "modified_by")
    public Integer getModifiedBy() {
        return modifiedBy;
    }

    public void setModifiedBy(Integer modifiedBy) {
        this.modifiedBy = modifiedBy;
    }

    @Column(name = "batch_id")
    public Integer getBatchId() {
        return batchId;
    }

    public void setBatchId(Integer batchId) {
        this.batchId = batchId;
    }

    @Column(name = "source")
    public Integer getSource() {
        return source;
    }

    public void setSource(Integer source) {
        this.source = source;
    }

    @Column(name = "suppress_on_statement")
    public Boolean getSuppressOnStatement() {
        return suppressOnStatement;
    }

    public void setSuppressOnStatement(Boolean suppressOnStatement) {
        this.suppressOnStatement = suppressOnStatement;
    }

    @Column(name = "statement_description_2")
    public String getStatementDescription2() {
        return statementDescription2;
    }

    public void setStatementDescription2(String statementDescription2) {
        this.statementDescription2 = statementDescription2;
    }

    @Column(name = "reference_id")
    public Integer getReferenceId() {
        return referenceId;
    }

    @Transient
    public Integer getArAccountId() {
        return this.getArAccount().getId().intValue();
    }

    @Transient
    public Long getArTransactionReferenceId() {
        return this.getId();
    }

    @Transient
    public int getArTransactionSourceId() {
        return 0;
    }

    @Transient
    public Date getArTransactionDate() {
        return this.paymentDate;
    }


    @Transient
    public int getArTransactionType() {
        return TransactionType.PAYMENT_TR_ID.getCode();
    }

    @Transient
    public BigDecimal getArTransactionAmount() {
        return this.getPaymentAmount().negate();
    }

    @Transient
    public String getArTransactionStatementDescription1() {
        return this.getDescription();
    }

    @Transient
    public String getArTransactionStatementDescription2() {
        return this.getStatementDescription2();
    }

    @Transient
    public String getArTransactionInternalDescription() {
        return "";
    }

    @Transient
    public int getGlAccountId() {
        return this.getPaymentType().getGlAccount().getId().intValue();
    }

    @Transient
    public JournalEntry getJournalEntry() {
        return null;
    }

    @Transient
    public int getArTransactionSubType() {
        return TransactionType.PAYMENT_TR_ID.getCode();
    }

    public void setReferenceId(Integer referenceId) {
        this.referenceId = referenceId;
    }

    @Transient
    public int getJournalType() {
        return ARUtility.getJournalTypeByTransactionType(TransactionType.PAYMENT_TR_ID.getCode());
    }

    @Transient
    public int getJournalSourceType() {
        return ARUtility.getJournalSourceTypeByTransactionType(TransactionType.PAYMENT_TR_ID.getCode());
    }

    @Transient
    public int getJournalSourceId() {
        return this.getId().intValue();
    }

    @Transient
    public int getSubLedgerAccountId() {
        return this.getArAccount().getCustomer().getId().intValue();
    }

    @Transient
    public String getSubLedgerAccountName() {
        return this.arAccount.getCustomer().getCustomerFullName();
    }

    @Transient
    public Date getJournalTransactionDate() {
        return this.getPaymentDate();
    }

    @Transient
    public int getEntryTotalNature() {
        int i = 1;
        if (new BigDecimal(0).compareTo(this.getPaymentAmount()) == 0) {
            i = 1;
        } else {
            i = (int) (this.getPaymentAmount().doubleValue() / Math.abs(this.getPaymentAmount().doubleValue()));
        }
        return i * -1;
    }

    @Transient
    public GlAccount getAccountDetail() {
        return this.paymentType.getGlAccount();
    }

    @Transient
    public IJournalizeableItem getJournalizeableControlItem() {
        return this.getArAccount().getArAccountType();
    }

    @Transient
    public IJournalizeableItem getJournalizeableMainItem() {
        return this.getPaymentType();
    }

    @Transient
    public BigDecimal getJournalizeableMainItemAmount() {
        return this.getPaymentAmount().multiply(new BigDecimal(-1));
    }

    @Transient
    public BigDecimal getJournalizeableMainItemQuantity() {
        return new BigDecimal(0.00);
    }
}
