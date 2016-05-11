package com.core.computism.assasa.ar.type;

import java.util.HashMap;

/**
 * Created by VD on 3/23/2016.
 */
public enum BillCodeType {

    TYPE1(1), TYPE2(2),TYPE3(3),TYPE4(4),TYPE5(5);
    Integer code;
    private static HashMap<Integer, BillCodeType> billCodeTypes = new HashMap<>();

    static {
        for(BillCodeType billCodeType:BillCodeType.values()){
            billCodeTypes.put(billCodeType.getCode(),billCodeType);
        }
    }

    public static BillCodeType getBillCodeType(Integer value){
        return billCodeTypes.get(value);
    }

    private BillCodeType(Integer value) {
        this.code = value;
    }

    public Integer getCode() {
        return this.code;
    }
}
