package com.core.computism.assasa.domain.type;

import java.util.HashMap;

/**
 * Created by Salman on 9/15/2015.
 */
public enum BlockageType {
    BLOCKED_BY_CUSTOMER(1), BlOCKED_BY_DRIVER(2);
    Integer code;
    private static HashMap<Integer, BlockageType> blockageTypes = new HashMap<>();

    static {
        for(BlockageType blockageType:BlockageType.values()){
            blockageTypes.put(blockageType.getCode(),blockageType);
        }
    }

    public static BlockageType getBlockageType(Integer value){
        return blockageTypes.get(value);
    }

    private BlockageType(Integer value) {
        this.code = value;
    }

    public Integer getCode() {
        return this.code;
    }
}
