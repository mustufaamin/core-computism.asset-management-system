package com.core.computism.assasa.ar.dto.service;

import com.core.computism.assasa.ar.IJournalizeableItem;

import java.io.Serializable;

public class JournalizeableItem implements Serializable, Cloneable {


    private IJournalizeableItem journalizeableItem;
    private JournalizeableItemDetail journalizeableItemDetail;

    public JournalizeableItem(IJournalizeableItem journalizeableItem, JournalizeableItemDetail journalizeableItemDetail) {
        super();
        this.journalizeableItem = journalizeableItem;
        this.journalizeableItemDetail = journalizeableItemDetail;
    }

    public IJournalizeableItem getJournalizeableItem() {
        return journalizeableItem;
    }

    public JournalizeableItemDetail getJournalizeableItemDetail() {
        return journalizeableItemDetail;
    }

    public void setJournalizeableItemDetail(
            JournalizeableItemDetail journalizeableItemDetail) {
        this.journalizeableItemDetail = journalizeableItemDetail;
    }

    public String toString() {
        StringBuffer sb = new StringBuffer();
        sb.append(super.toString());
        sb.append(" journalizeableItem : " + journalizeableItem.toString());
        sb.append(" journalizeableItemDetail : " + journalizeableItemDetail.toString());

        return sb.toString();
    }
}