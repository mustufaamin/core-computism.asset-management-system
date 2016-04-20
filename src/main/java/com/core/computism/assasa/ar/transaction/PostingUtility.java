package com.core.computism.assasa.ar.transaction;

import com.core.computism.assasa.ar.dto.service.JournalEntryItem;

import java.math.BigDecimal;
import java.util.List;

/**
 * Created by VD on 4/19/2016.
 */
public class PostingUtility {

    public static BigDecimal entryTotalAmount(List<JournalEntryItem> totalJournalizeableItems) {
        BigDecimal totalAmount = new BigDecimal(0.00);
        for(JournalEntryItem journalEntryItem : totalJournalizeableItems) {
            totalAmount.add(journalEntryItem.getAbsAmount());
        }
        return totalAmount;
    }

    public static void offSetJournalEntryItem(List<JournalEntryItem> totalJournalizeableItems, JournalEntryItem journalEntryControlItems) {
        BigDecimal totalAmount = new BigDecimal(0.00);
        for(JournalEntryItem journalEntryItem : totalJournalizeableItems) {
            totalAmount.add(journalEntryItem.getAbsAmount());
        }
        journalEntryControlItems.setAmount(totalAmount);
    }
}
