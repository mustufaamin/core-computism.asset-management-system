package com.core.computism.assasa.pos.domain;

import com.fasterxml.jackson.annotation.JsonAutoDetect;

/**
 * Created by M.Mustufa AMin Shah on 4/3/2016.
 */
@JsonAutoDetect
public class PosPaymentTypeDto {

    private Long id;
    private String paymentTypeName;
    private String paymentTypeDesc;
    private Integer glAccountId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPaymentTypeName() {
        return paymentTypeName;
    }

    public void setPaymentTypeName(String paymentTypeName) {
        this.paymentTypeName = paymentTypeName;
    }

    public String getPaymentTypeDesc() {
        return paymentTypeDesc;
    }

    public void setPaymentTypeDesc(String paymentTypeDesc) {
        this.paymentTypeDesc = paymentTypeDesc;
    }

    public Integer getGlAccountId() {
        return glAccountId;
    }

    public void setGlAccountId(Integer glAccountId) {
        this.glAccountId = glAccountId;
    }
}
