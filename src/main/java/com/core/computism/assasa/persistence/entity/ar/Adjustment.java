package com.core.computism.assasa.persistence.entity.ar;

import com.core.computism.assasa.ar.IJournalizeableItem;
import com.core.computism.assasa.ar.dto.service.IJournalizeable;
import com.core.computism.assasa.ar.enumtype.TransactionType;
import com.core.computism.assasa.ar.transaction.IPostable;
import com.core.computism.assasa.persistence.entity.ar.account.ArAccount;
import com.core.computism.assasa.persistence.entity.ar.billing.BillCode;
import com.core.computism.assasa.persistence.entity.gl.JournalEntry;
import com.core.computism.assasa.persistence.entity.gl.admin.GlAccount;
import com.core.computism.assasa.utilities.ARUtility;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;
import java.math.BigDecimal;
import java.util.Date;

/**
 * Created by VD on 4/13/2016.
 */
@Entity
@Table(name = "ar_adjustment")
public class Adjustment extends BaseEntity implements IPostable, IJournalizeable {
    private ArAccount arAccount;
    private BillCode billCode;
    private Date adjustmentDate;
    private BigDecimal amount;
    private Integer adjustmentType;
    private Integer status;
    private Integer batchId;
    private String description;
    private String statementDescription2;
    private String note;
    private Boolean suppressOnStatement;
    private Boolean excludeValueAdded;
    private Integer createdBy;
    private Integer modifiedBy;
    private JournalEntry journalEntry;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "ar_account_id", referencedColumnName = "id", nullable = false)
    public ArAccount getArAccount() {
        return arAccount;
    }

    public void setArAccount(ArAccount arAccount) {
        this.arAccount = arAccount;
    }

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "bill_code_id", referencedColumnName = "id", nullable = false)
    public BillCode getBillCode() {
        return billCode;
    }

    public void setBillCode(BillCode billCode) {
        this.billCode = billCode;
    }

    @Column(name = "adjustment_date")
    public Date getAdjustmentDate() {
        return adjustmentDate;
    }

    public void setAdjustmentDate(Date adjustmentDate) {
        this.adjustmentDate = adjustmentDate;
    }

    @Column(name = "amount")
    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    @Column(name = "adjustment_type")
    public Integer getAdjustmentType() {
        return adjustmentType;
    }

    public void setAdjustmentType(Integer adjustmentType) {
        this.adjustmentType = adjustmentType;
    }

    @Column(name = "status")
    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    @Column(name = "batch_id")
    public Integer getBatchId() {
        return batchId;
    }

    public void setBatchId(Integer batchId) {
        this.batchId = batchId;
    }

    @Column(name = "description")
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Column(name = "statement_description_2")
    public String getStatementDescription2() {
        return statementDescription2;
    }

    public void setStatementDescription2(String statementDescription2) {
        this.statementDescription2 = statementDescription2;
    }

    @Column(name = "note")
    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    @Column(name = "suppress_on_statement")
    public Boolean getSuppressOnStatement() {
        return suppressOnStatement;
    }

    public void setSuppressOnStatement(Boolean suppressOnStatement) {
        this.suppressOnStatement = suppressOnStatement;
    }

    @Column(name = "exclude_value_added")
    public Boolean getExcludeValueAdded() {
        return excludeValueAdded;
    }

    public void setExcludeValueAdded(Boolean excludeValueAdded) {
        this.excludeValueAdded = excludeValueAdded;
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
        return this.adjustmentDate;
    }


    @Transient
    public int getArTransactionType() {
        return TransactionType.PAYMENT_TR_ID.getCode();
    }

    @Transient
    public BigDecimal getArTransactionAmount() {
        return this.getAmount();
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
        return this.getBillCode().getGlAccount().getId().intValue();
    }

    @Transient
    public JournalEntry getJournalEntry() {
        return journalEntry;
    }

    public void setJournalEntry(JournalEntry journalEntry) {
        this.journalEntry = journalEntry;
    }

    @Transient
    public int getArTransactionSubType() {
        return this.getAdjustmentType();
    }

    @Transient
    public int getJournalType() {
        return ARUtility.getJournalTypeByTransactionType(TransactionType.ADJUSTMENT_TR_ID.getCode());
    }

    @Transient
    public int getJournalSourceType() {
        return ARUtility.getJournalSourceTypeByTransactionType(TransactionType.ADJUSTMENT_TR_ID.getCode());
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
        return this.getAdjustmentDate();
    }

    @Transient
    public int getEntryTotalNature() {
        if (new BigDecimal(0).compareTo(this.getAmount()) == 0) {
            return 1;
        } else {
            return (int) (this.getAmount().doubleValue() / Math.abs(this.getAmount().doubleValue()));
        }
    }

    @Transient
    public GlAccount getAccountDetail() {
        return this.billCode.getGlAccount();
    }

    @Transient
    public IJournalizeableItem getJournalizeableControlItem() {
        return this.getArAccount().getArAccountType();
    }

    @Transient
    public IJournalizeableItem getJournalizeableMainItem() {
//        return this.getBillCode();
        return null;
    }

    @Transient
    public BigDecimal getJournalizeableMainItemAmount() {
        return this.getAmount();
    }

    @Transient
    public BigDecimal getJournalizeableMainItemQuantity() {
        return new BigDecimal(0.00);
    }

}
