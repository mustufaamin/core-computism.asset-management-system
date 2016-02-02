package com.core.computism.assetmanagementsystem.domain.type;

import java.util.HashMap;

/**
 * Created by Venturedive on 7/20/2015.
 */
public enum CarCategory {
    BUSINESS (1),
    ECONOMY (2),
    FIRST_CLASS(3),
    SUV(4);

    private Integer code;
    private static HashMap<Integer, CarCategory> carCategories = new HashMap<>();

    static{
        for(CarCategory carCategory : CarCategory.values()){
            carCategories.put(carCategory.getCode(),carCategory);
        }
    }

    public static CarCategory getCarCategory(Integer code) {
        return carCategories.get(code);
    }

    private CarCategory(Integer code) {
        this.code = code;
    }

    public Integer getCode() {
        return this.code;
    }
}
