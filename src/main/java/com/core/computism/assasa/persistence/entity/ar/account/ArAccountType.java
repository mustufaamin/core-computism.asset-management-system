package com.core.computism.assasa.persistence.entity.ar.account;

import com.core.computism.assasa.ar.IJournalizeableItem;
import com.core.computism.assasa.ar.dto.service.JournalEntryItem;
import com.core.computism.assasa.ar.dto.service.JournalizeableItemDetail;
import com.core.computism.assasa.persistence.entity.ar.BaseEntity;
import com.core.computism.assasa.persistence.entity.gl.admin.GlAccount;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by VD on 2/21/2016.
 */
@Entity
@Table(name = "ar_account_type")
public class ArAccountType extends BaseEntity implements IJournalizeableItem {

    private String accountTypeName;
    private String accountTypeDesc;
    private GlAccount glAccount;
    private Integer status;
    private Integer companyId;
    private String accountTypeCode;
    private Integer priority;
    private Boolean leftOverAmount;
    private Boolean requiredStatus;
    private String over30Message;
    private String over60Message;
    private String over90Message;
    private String over120Message;
    private Integer showAgingMessage;

    @Column(name = "account_type_name")
    public String getAccountTypeName() {
        return accountTypeName;
    }

    public void setAccountTypeName(String accountTypeName) {
        this.accountTypeName = accountTypeName;
    }

    @Column(name = "account_type_desc")
    public String getAccountTypeDesc() {
        return accountTypeDesc;
    }

    public void setAccountTypeDesc(String accountTypeDesc) {
        this.accountTypeDesc = accountTypeDesc;
    }

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "gl_account_id", referencedColumnName = "id", nullable = false)
    public GlAccount getGlAccount() {
        return glAccount;
    }

    public void setGlAccount(GlAccount glAccount) {
        this.glAccount = glAccount;
    }

    @Column(name = "status")
    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    @Column(name = "company_id")
    public Integer getCompanyId() {
        return companyId;
    }

    public void setCompanyId(Integer companyId) {
        this.companyId = companyId;
    }

    @Column(name = "account_type_code")
    public String getAccountTypeCode() {
        return accountTypeCode;
    }

    public void setAccountTypeCode(String accountTypeCode) {
        this.accountTypeCode = accountTypeCode;
    }

    @Column(name = "priority")
    public Integer getPriority() {
        return priority;
    }

    public void setPriority(Integer priority) {
        this.priority = priority;
    }

    @Column(name = "is_left_over_amount")
    public Boolean getLeftOverAmount() {
        return leftOverAmount;
    }

    public void setLeftOverAmount(Boolean leftOverAmount) {
        this.leftOverAmount = leftOverAmount;
    }

    @Column(name = "required_status")
    public Boolean getRequiredStatus() {
        return requiredStatus;
    }

    public void setRequiredStatus(Boolean requiredStatus) {
        this.requiredStatus = requiredStatus;
    }

    @Column(name = "over30_message")
    public String getOver30Message() {
        return over30Message;
    }

    public void setOver30Message(String over30Message) {
        this.over30Message = over30Message;
    }

    @Column(name = "over60_message")
    public String getOver60Message() {
        return over60Message;
    }

    public void setOver60Message(String over60Message) {
        this.over60Message = over60Message;
    }

    @Column(name = "over90_message")
    public String getOver90Message() {
        return over90Message;
    }

    public void setOver90Message(String over90Message) {
        this.over90Message = over90Message;
    }

    @Column(name = "over120_message")
    public String getOver120Message() {
        return over120Message;
    }

    public void setOver120Message(String over120Message) {
        this.over120Message = over120Message;
    }

    @Column(name = "show_aging_message")
    public Integer getShowAgingMessage() {
        return showAgingMessage;
    }

    public void setShowAgingMessage(Integer showAgingMessage) {
        this.showAgingMessage = showAgingMessage;
    }

    @Transient
    public String getJournalizeableItemName() {
        return this.getAccountTypeName();
    }

    @Transient
    public GlAccount getAccountDetail() {
        return this.getGlAccount();
    }

    @Transient
    public List<JournalEntryItem> getJournalizeableItems(GlAccount accountDetail, JournalizeableItemDetail journalizeableItemDetail, String journalEntryItemComments) {
        String journalEntryItemConsolidatedComments = journalEntryItemComments + " " + this.getJournalizeableItemName();
        List<JournalEntryItem> journalizeableItems = new ArrayList<JournalEntryItem>();
        journalizeableItemDetail.setQuantity(new BigDecimal(0.00));

        JournalEntryItem ji = new JournalEntryItem(this.getAccountDetail(), journalizeableItemDetail, journalEntryItemConsolidatedComments);

        try {
            journalizeableItemDetail = (JournalizeableItemDetail) journalizeableItemDetail.clone();
            journalizeableItemDetail.setAmount(new BigDecimal(0.00));
            journalizeableItemDetail.setQuantity(new BigDecimal(0.00));

            JournalEntryItem mainARAccountJournalizeableItemDebitREV = new JournalEntryItem(getAccountDetail(), (JournalizeableItemDetail) journalizeableItemDetail.clone(), journalEntryItemComments);
            mainARAccountJournalizeableItemDebitREV.setDebit(true);
            JournalEntryItem mainARAccountJournalizeableItemCreditREV = (JournalEntryItem) mainARAccountJournalizeableItemDebitREV.clone();
            mainARAccountJournalizeableItemCreditREV.setDebit(false);
            JournalEntryItem mainARAccountJournalizeableItemDebitEXP = new JournalEntryItem(getAccountDetail(), (JournalizeableItemDetail) journalizeableItemDetail.clone(), journalEntryItemComments);
            mainARAccountJournalizeableItemDebitEXP.setDebit(true);
            JournalEntryItem mainARAccountJournalizeableItemCreditEXP = (JournalEntryItem) mainARAccountJournalizeableItemDebitEXP.clone();
            mainARAccountJournalizeableItemCreditEXP.setDebit(false);

            journalizeableItems.add(mainARAccountJournalizeableItemDebitREV);
            journalizeableItems.add(mainARAccountJournalizeableItemCreditREV);
            journalizeableItems.add(mainARAccountJournalizeableItemDebitEXP);
            journalizeableItems.add(mainARAccountJournalizeableItemCreditEXP);

        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return journalizeableItems;
    }
}
