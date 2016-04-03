package com.core.computism.assasa.ar.dto;

import com.core.computism.assasa.gl.dto.GlAccountDto;
import com.core.computism.assasa.persistence.entity.ar.PaymentType;
import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * Created by VD on 3/14/2016.
 */
@JsonAutoDetect
@JsonIgnoreProperties(ignoreUnknown = true)
public class PaymentTypeDto {

    private Long paymentTypeId;
    private String paymentTypeName;
    private String paymentTypeDesc;
    private GlAccountDto glAccountDto;
    private Integer status;
    private Integer moduleId;
    private Integer companyId;
    private Integer addOnGroupId;
    private Integer displayPriority;
    private String description;

    public PaymentTypeDto() {}

    public PaymentTypeDto(PaymentType paymentType) {
        this.paymentTypeId = paymentType.getId();
        this.paymentTypeName = paymentType.getPaymentTypeName();
        this.paymentTypeDesc = paymentType.getPaymentTypeDesc() ;
        this.glAccountDto= new GlAccountDto(paymentType.getGlAccount());
        this.status= paymentType.getStatus();
        this.moduleId= paymentType.getModuleId();
        this.companyId= paymentType.getCompanyId();
        this.addOnGroupId= null;
        this.displayPriority= paymentType.getDisplayPriority();
        this.description= paymentType.getThankyouDescription();
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

    public GlAccountDto getGlAccountDto() {
        return glAccountDto;
    }

    public void setGlAccountDto(GlAccountDto glAccountDto) {
        this.glAccountDto = glAccountDto;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getModuleId() {
        return moduleId;
    }

    public void setModuleId(Integer moduleId) {
        this.moduleId = moduleId;
    }

    public Integer getCompanyId() {
        return companyId;
    }

    public void setCompanyId(Integer companyId) {
        this.companyId = companyId;
    }

    public Integer getAddOnGroupId() {
        return addOnGroupId;
    }

    public void setAddOnGroupId(Integer addOnGroupId) {
        this.addOnGroupId = addOnGroupId;
    }

    public Integer getDisplayPriority() {
        return displayPriority;
    }

    public void setDisplayPriority(Integer displayPriority) {
        this.displayPriority = displayPriority;
    }

    public Long getPaymentTypeId() {
        return paymentTypeId;
    }

    public void setPaymentTypeId(Long paymentTypeId) {
        this.paymentTypeId = paymentTypeId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
