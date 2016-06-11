package com.core.computism.assasa.ar.enumtype;

import java.util.HashMap;

/**
 * Created by VD on 6/11/2016.
 */
public enum PaymentStatus {

    UNPOSTED(1),
    POSTED(2);

    private Integer code;
    private static HashMap<Integer, PaymentStatus> paymentStatuses = new HashMap<>();

    static {
        for (PaymentStatus paymentStatus : PaymentStatus.values()) {
            paymentStatuses.put(paymentStatus.getCode(), paymentStatus);
        }
    }
    public static PaymentStatus getPaymentStatus(Integer code) {
        return paymentStatuses.get(code);
    }

    private PaymentStatus(Integer code) {
        this.code = code;
    }

    public int getCode() {
        return this.code;
    }
}
