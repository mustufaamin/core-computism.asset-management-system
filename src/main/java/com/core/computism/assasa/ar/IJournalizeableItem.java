package com.core.computism.assasa.ar;

import com.core.computism.assasa.ar.dto.service.JournalEntryItem;
import com.core.computism.assasa.ar.dto.service.JournalizeableItemDetail;
import com.core.computism.assasa.persistence.entity.gl.admin.GlAccount;

import java.util.List;

/**
 * Created by VD on 3/17/2016.
 */
public interface IJournalizeableItem {
    public String getJournalizeableItemName();

    public GlAccount getAccountDetail();

    public List<JournalEntryItem> getJournalizeableItems(GlAccount accountDetail, JournalizeableItemDetail journalizeableItemDetail, String journalEntryItemComments);
}
