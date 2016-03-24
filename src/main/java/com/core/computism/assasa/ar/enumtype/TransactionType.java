package com.core.computism.assasa.ar.enumtype;

import com.core.computism.assasa.exception.ArBusinessException;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public enum TransactionType implements IntegerEnumType<TransactionType> {

    PAYMENT_TR_ID(1), ADJUSTMENT_TR_ID(2);

    private static final List<TransactionType> TRANSACTION_TYPES = Collections.unmodifiableList(Arrays.asList(PAYMENT_TR_ID, ADJUSTMENT_TR_ID));

    private int code;

    private TransactionType(int c) {
        code = c;
    }

    @Override
    public int getCode() {
        return code;
    }


    public static TransactionType convert(String input) throws ArBusinessException {
        TransactionType transactionType = TransactionType.valueOf(input.toUpperCase());
        if (transactionType == null) {
            throw new ArBusinessException("Invalid transaction type.");
        }
        return transactionType;
    }

    public static Boolean isTransactionType(TransactionType transactionType) {
        return TRANSACTION_TYPES.contains(transactionType);
    }
}
