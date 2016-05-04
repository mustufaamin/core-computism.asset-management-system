package com.core.computism.assasa.domain.type;

import java.util.HashMap;

/**
 * Created by Salman on 9/15/2015.
 */
public enum CustomerVerification {
    VERIFIED(1),
    UNVERIFIED(0);

    Integer code;
    private static HashMap<Integer, CustomerVerification> customerVerifications = new HashMap<>();

    static{
        for(CustomerVerification customerVerificationType:CustomerVerification.values()){
            customerVerifications.put(customerVerificationType.getCode(),customerVerificationType);
        }
    }

    public static CustomerVerification getcustomerVerification(Integer value) {
        return customerVerifications.get(value);
    }

    private CustomerVerification(Integer code) {
        this.code = code;
    }

    public Integer getCode() {
        return code;
    }
}
