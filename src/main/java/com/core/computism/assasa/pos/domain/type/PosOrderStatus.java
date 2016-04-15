package com.core.computism.assasa.pos.domain.type;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by VD on 4/15/2016.
 */
public enum PosOrderStatus {
    PENDING(1),
    DELIVERED(2),
    PAID(3);

    private Integer code;
    private static Map<Integer,PosOrderStatus> posOrderStatuses = new HashMap<>();

    static{
        for(PosOrderStatus posOrderStatus : PosOrderStatus.values()){
            posOrderStatuses.put(posOrderStatus.getCode(),posOrderStatus);
        }
    }
    private PosOrderStatus(Integer value){
        this.code = value;
    }

    public Integer getCode() {
        return this.code;
    }
    public static PosOrderStatus getPosOrderStatus(Integer value){
        return posOrderStatuses.get(value);
    }
    public static Map<Integer, PosOrderStatus> getPosOrderStatuses() {
        return posOrderStatuses;
    }
}
