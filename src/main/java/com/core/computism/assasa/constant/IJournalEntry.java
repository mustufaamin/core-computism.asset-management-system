package com.core.computism.assasa.constant;

/**
 * Created by VD on 3/27/2016.
 */
public interface IJournalEntry {

    public static final int JOURNAL_TYPE_AR_SALES = 1;
    public static final int JOURNAL_TYPE_AR_RECEIPTS = 2;
    public static final int JOURNAL_TYPE_AP_PAYMENTS = 3;
    public static final int JOURNAL_TYPE_AP_PURCHASES = 4;

    /*journal type strings*/
    public static final String JOURNAL_TYPE_AR_SALES_STR = "Sales";
    public static final String JOURNAL_TYPE_AR_RECEIPTS_STR = "Receipts";
    public static final String JOURNAL_TYPE_AP_PAYMENTS_STR = "Payments";
    public static final String JOURNAL_TYPE_AP_PURCHASES_STR = "Purchases";


    /*subledger account types:*/
    public static final int SUB_LEDGER_ACCT_TYPE_CUSTOMER = 1;
    public static final int SUB_LEDGER_ACCT_TYPE_VENDOR = 2;


    /*Journal Source
    * JOURNAL_SOURCE_INVOICE -> A Vendor Invoice from AP
    * JOURNAL_SOURCE_PAYMENT_RECEIPT -> payment receipt from a customer in AR
    * JOURNAL_SOURCE_CHIT -> a chit from a POS transaction
    * JOURNAL_SOURCE_CHECK -> represents a check cut to a vendor in AP
    *
    * JOURNAL_SOURCE_BILLING_CHARGE, JOURNAL_SOURCE_BILLING_ADJUSTMENT ->
    * represents a periodic charge due to service billing
    *  and other non-POS charges in AR
    */

    public static final int JOURNAL_SOURCE_INVOICE = 1;
    public static final int JOURNAL_SOURCE_PAYMENT_RECEIPT = 2;
    public static final int JOURNAL_SOURCE_CHIT = 3;
    public static final int JOURNAL_SOURCE_CHECK = 4;
    public static final int JOURNAL_SOURCE_BILLING_CHARGE = 5;
    public static final int JOURNAL_SOURCE_BILLING_ADJUSTMENT = 6;

}
