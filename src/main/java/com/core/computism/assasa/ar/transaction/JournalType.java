package com.core.computism.assasa.ar.transaction;

import com.core.computism.assasa.constant.IJournalEntry;

/**
 * Created by VD on 4/10/2016.
 */
public class JournalType {

    public static String getSubLedgerAccountTypeStr(int journalType) {
        String typeStr = "";
        switch(journalType) {
            case(IJournalEntry.JOURNAL_TYPE_AR_SALES):
            case(IJournalEntry.JOURNAL_TYPE_AR_RECEIPTS):
                typeStr = "Member";
                break;
            case(IJournalEntry.JOURNAL_TYPE_AP_PAYMENTS):
            case(IJournalEntry.JOURNAL_TYPE_AP_PURCHASES):
                typeStr = "Vendor";
                break;
        }
        return typeStr;
    }
}
