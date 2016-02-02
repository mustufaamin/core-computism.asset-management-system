package com.core.computism.assetmanagementsystem.domain.type;

import java.util.HashMap;

/**
 * Created by Venture Dive on 9/14/2015.
 */
public enum TripType {

    SINGLE(1),
    REPEAT(2),
    MULTISTOP(3);

    private Integer code;
    private static HashMap<Integer, TripType> tripTypes = new HashMap<>(0);

    static {
        for(TripType tripType : TripType.values()){
            tripTypes.put(tripType.getCode(),tripType);
        }
    }

    private TripType(Integer value) {
        this.code = value;
    }

    public static TripType getTripType(Integer value) {
        return tripTypes.get(value);
    }


    public Integer getCode() {
        return this.code;
    }
}
