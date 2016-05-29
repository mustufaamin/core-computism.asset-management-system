package com.core.computism.assasa.ar.enumtype;

import java.util.HashMap;

/**
 * Created by VD on 5/29/2016.
 */
public enum ArOrderStatus {

    NOT_DELIVERED(1),
    DELIVERED(2),
    CLOSE(3);


    private Integer code;
    private static HashMap<Integer, ArOrderStatus> arOrderStatuses = new HashMap<>();

    static {
        for (ArOrderStatus arOrderStatus : ArOrderStatus.values()) {
            arOrderStatuses.put(arOrderStatus.getCode(), arOrderStatus);
        }
    }
    public static ArOrderStatus getArQuotationType(Integer code) {
        return arOrderStatuses.get(code);
    }

    private ArOrderStatus(Integer code) {
        this.code = code;
    }

    public Integer getCode() {
        return this.code;
    }
}
