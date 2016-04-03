package com.core.computism.assasa.ar.builder;

import com.core.computism.assasa.persistence.entity.ar.PaymentType;
import com.core.computism.assasa.persistence.entity.gl.admin.GlAccount;

/**
 * Created by VD on 3/14/2016.
 */
public class PaymentTypeBuilder {

    private String paymentTypeName;
    private String paymentTypeDesc;
    private GlAccount glAccount;
    private Integer status;
    private Integer moduleId;
    private Integer companyId;
    private Integer addOnGroupId;
    private Integer displayPriority;
    private String description;

    public PaymentTypeBuilder setPaymentTypeName(String paymentTypeName) {
        this.paymentTypeName = paymentTypeName;
        return this;
    }

    public PaymentTypeBuilder setPaymentTypeDesc(String paymentTypeDesc) {
        this.paymentTypeDesc = paymentTypeDesc;
        return this;
    }

    public PaymentTypeBuilder setGlAccount(GlAccount glAccount) {
        this.glAccount = glAccount;
        return this;
    }

    public PaymentTypeBuilder setStatus(Integer status) {
        this.status = status;
        return this;
    }

    public PaymentTypeBuilder setModuleId(Integer moduleId) {
        this.moduleId = moduleId;
        return this;
    }

    public PaymentTypeBuilder setCompanyId(Integer companyId) {
        this.companyId = companyId;
        return this;
    }

    public PaymentTypeBuilder setAddOnGroupId(Integer addOnGroupId) {
        this.addOnGroupId = addOnGroupId;
        return this;
    }

    public PaymentTypeBuilder setDisplayPriority(Integer displayPriority) {
        this.displayPriority = displayPriority;
        return this;
    }

    public PaymentTypeBuilder setDescription(String description) {
        this.description = description;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public String getPaymentTypeName() {
        return paymentTypeName;
    }

    public String getPaymentTypeDesc() {
        return paymentTypeDesc;
    }

    public GlAccount getGlAccount() {
        return glAccount;
    }

    public Integer getStatus() {
        return status;
    }

    public Integer getModuleId() {
        return moduleId;
    }

    public Integer getCompanyId() {
        return companyId;
    }

    public Integer getAddOnGroupId() {
        return addOnGroupId;
    }

    public Integer getDisplayPriority() {
        return displayPriority;
    }

    public PaymentType build() {

        PaymentType paymentType = new PaymentType();
        paymentType.setPaymentTypeName(this.getPaymentTypeName());
        paymentType.setPaymentTypeDesc(this.getPaymentTypeDesc());
        paymentType.setGlAccount(this.getGlAccount());
        paymentType.setStatus(this.getStatus());
        paymentType.setModuleId(this.getModuleId());
        paymentType.setCompanyId(this.getCompanyId());
        paymentType.setAddOnGroupId(this.getAddOnGroupId());
        paymentType.setDisplayPriority(this.getDisplayPriority());
        paymentType.setThankyouDescription(this.getDescription());

        return paymentType;
    }
}
