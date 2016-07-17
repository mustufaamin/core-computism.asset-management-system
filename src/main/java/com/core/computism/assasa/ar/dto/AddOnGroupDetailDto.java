package com.core.computism.assasa.ar.dto;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * Created by VD on 7/11/2016.
 */
@JsonAutoDetect
@JsonIgnoreProperties(ignoreUnknown = true)
public class AddOnGroupDetailDto {

    private Integer addOnGroupDetailId;
    private Integer addOnGroupId;
    private Integer addOnChargeId;

    public AddOnGroupDetailDto() {
    }

    public Integer getAddOnGroupDetailId() {
        return addOnGroupDetailId;
    }

    public void setAddOnGroupDetailId(Integer addOnGroupDetailId) {
        this.addOnGroupDetailId = addOnGroupDetailId;
    }

    public Integer getAddOnGroupId() {
        return addOnGroupId;
    }

    public void setAddOnGroupId(Integer addOnGroupId) {
        this.addOnGroupId = addOnGroupId;
    }

    public Integer getAddOnChargeId() {
        return addOnChargeId;
    }

    public void setAddOnChargeId(Integer addOnChargeId) {
        this.addOnChargeId = addOnChargeId;
    }
}
