package com.core.computism.assasa.utilities;

import com.core.computism.assasa.ar.dto.service.TransactionServiceDto;
import com.core.computism.assasa.constant.IJournalEntry;

/**
 * Created by VD on 3/27/2016.
 */
public class ARUtility {

    public static int getJournalTypeByTransactionType(int transactionTypeId) {
        int journalType = 0;
        switch (transactionTypeId) {
            case (TransactionServiceDto.PERIODIC_TR_ID):
            case (TransactionServiceDto.ADJUSTMENT_TR_ID): { // transaction type periodic or adjustment
                journalType = IJournalEntry.JOURNAL_TYPE_AR_SALES;
                break;
            }
            case TransactionServiceDto.PAYMENT_TR_ID: { // transaction type payment receipts
                journalType = IJournalEntry.JOURNAL_TYPE_AR_RECEIPTS;
                break;
            }
        }
        return journalType;
    }

    public static int getJournalSourceTypeByTransactionType(int transactionTypeId) {
        int journalSourceType = 0;
        switch (transactionTypeId) {
            case TransactionServiceDto.ADJUSTMENT_TR_ID: {
                journalSourceType = IJournalEntry.JOURNAL_SOURCE_BILLING_ADJUSTMENT;
                break;
            }
            case TransactionServiceDto.PAYMENT_TR_ID: {
                journalSourceType = IJournalEntry.JOURNAL_SOURCE_PAYMENT_RECEIPT;
                break;
            }
            case TransactionServiceDto.PERIODIC_TR_ID: {
                journalSourceType = IJournalEntry.JOURNAL_SOURCE_BILLING_CHARGE;
                break;
            }
        }

        return journalSourceType;
    }
}
