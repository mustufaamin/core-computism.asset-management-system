package com.core.computism.assasa.ar.dto.service;

import com.core.computism.assasa.ar.IJournalizeableItem;
import com.core.computism.assasa.persistence.entity.gl.JournalEntry;
import com.core.computism.assasa.persistence.entity.gl.admin.GlAccount;

import java.math.BigDecimal;
import java.util.Date;

/**
 * Created by VD on 3/27/2016.
 */
public interface IJournalizeable {

    public int getJournalType();
    public int getJournalSourceType();
    public int getJournalSourceId();
    public int getSubLedgerAccountId();
    public String getSubLedgerAccountName();
    public Date getJournalTransactionDate();
    public int getEntryTotalNature();
    /**
     * Information GL selection is default, based on meal period or location or advance GL Setting
     * or
     * Default ignored and used discount GL
     * @return
     */
    public GlAccount getAccountDetail();
    /**
     * AR Account Type
     * @return
     */
    public IJournalizeableItem getJournalizeableControlItem();
    /**
     * Bill code or Payment Type
     * @return
     */
    public IJournalizeableItem getJournalizeableMainItem();
    /**
     * Bill code amount or Payment Type amount
     * @return
     */
    public BigDecimal getJournalizeableMainItemAmount();
    /*
     * Quantity in Adjustment for statistical accounting
     */
    public BigDecimal getJournalizeableMainItemQuantity();

    public void setJournalEntry(JournalEntry journalEntry);
}
