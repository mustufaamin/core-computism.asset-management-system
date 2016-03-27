package com.core.computism.assasa.ar.dto.service;

import com.core.computism.assasa.gl.dto.service.ManualGLTransactionCreator;
import com.core.computism.assasa.persistence.entity.gl.admin.GlAccount;

/**
 * Created by VD on 3/26/2016.
 */
public class JournalEntryItem extends ManualGLTransactionCreator {
    private boolean debit;
    private JournalizeableItemDetail journalizeableItemDetail;

    public JournalEntryItem() {
    }

    public JournalEntryItem(GlAccount accountDetail, JournalizeableItemDetail journalizeableItemDetail, String comment) {
        super(accountDetail, journalizeableItemDetail.getAmount(), journalizeableItemDetail.getQuantity());
        super.setComment(comment);
        this.journalizeableItemDetail = journalizeableItemDetail;
    }

    public JournalEntryItem(GlAccount accountDetail, JournalizeableItemDetail journalizeableItemDetail, String comment, boolean debit) {
        this(accountDetail, journalizeableItemDetail, comment);
        this.debit = debit;
    }

    public Integer getCompanyId() {
        return this.accountDetail.getCompanyId();
    }

    public boolean isDebit() {
        return debit;
    }

    public void setDebit(boolean debit) {
        this.debit = debit;
    }

    public JournalizeableItemDetail getJournalizeableItemDetail() {
        return journalizeableItemDetail;
    }

    public void setJournalizeableItemDetail(JournalizeableItemDetail journalizeableItemDetail) {
        this.journalizeableItemDetail = journalizeableItemDetail;
    }

    public GlAccount getAccountDetail() {
        return accountDetail;
    }

    public void setAccountDetail(GlAccount accountDetail ) {
        this.accountDetail= accountDetail;
    }

    public Object clone() throws CloneNotSupportedException
    {
        JournalEntryItem journalizeableItem = new JournalEntryItem(accountDetail, (JournalizeableItemDetail)this.journalizeableItemDetail.clone() ,this.getComment());
        journalizeableItem.setDebit(this.debit);
        return journalizeableItem;
    }
}
