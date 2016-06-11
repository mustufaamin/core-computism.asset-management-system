package com.core.computism.assasa.ar.enumtype;

import java.util.HashMap;

/**
 * Created by VD on 6/11/2016.
 */
public enum PaymentSource implements IntegerEnumType<PaymentSource> {
    BACK_OFFICE(1),
    TERMINAL(2);

    private Integer code;
    private static HashMap<Integer, PaymentSource> paymentSources = new HashMap<>();

    static {
        for (PaymentSource paymentSource : PaymentSource.values()) {
            paymentSources.put(paymentSource.getCode(), paymentSource);
        }
    }
    public static PaymentSource getPaymentSource(Integer code) {
        return paymentSources.get(code);
    }

    private PaymentSource(Integer code) {
        this.code = code;
    }

    public int getCode() {
        return this.code;
    }
}
