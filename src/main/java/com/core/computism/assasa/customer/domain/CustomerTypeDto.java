package com.core.computism.assasa.customer.domain;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * Created by VD on 5/23/2016.
 */
@JsonAutoDetect
@JsonIgnoreProperties
public class CustomerTypeDto {

    private Long customerTypeId;
    private String customerTypeName;
    private String description;
    private Integer status;

    public CustomerTypeDto() { }

    public Long getCustomerTypeId() {
        return customerTypeId;
    }

    public void setCustomerTypeId(Long customerTypeId) {
        this.customerTypeId = customerTypeId;
    }

    public String getCustomerTypeName() {
        return customerTypeName;
    }

    public void setCustomerTypeName(String customerTypeName) {
        this.customerTypeName = customerTypeName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "CustomerTypeDto{" +
                "customerTypeId=" + customerTypeId +
                ", customerTypeName='" + customerTypeName + '\'' +
                ", description='" + description + '\'' +
                ", status=" + status +
                '}';
    }
}
