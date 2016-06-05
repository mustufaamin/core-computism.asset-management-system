package com.core.computism.assasa.ar.enumtype;

import java.util.HashMap;

/**
 * Created by VD on 5/28/2016.
 */
public enum ArQuotationStatus {
    NOT_APPROVED(1),
    APPROVED(2);

    private Integer code;
    private static HashMap<Integer, ArQuotationStatus> arQuotationStatuses = new HashMap<>();

    static {
        for (ArQuotationStatus arQuotationStatus : ArQuotationStatus.values()) {
            arQuotationStatuses.put(arQuotationStatus.getCode(), arQuotationStatus);
        }
    }
    public static ArQuotationStatus getArQuotationType(Integer code) {
        return arQuotationStatuses.get(code);
    }

    private ArQuotationStatus(Integer code) {
        this.code = code;
    }

    public Integer getCode() {
        return this.code;
    }
}
