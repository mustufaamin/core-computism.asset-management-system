package com.core.computism.assasa.persistence.entity.ar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Created by VD on 3/14/2016.
 */
@Entity
@Table(name = "cmn_payment_type")
public class PaymentType extends BaseEntity  {

    @Column(name = "payment_type_name")
    private String paymentTypeName;

    @Column(name = "payment_type_desc")
    private String paymentTypeDesc;

    @Column(name = "gl_account_id")
    private Integer glAccountId;

    @Column(name = "status")
    private Integer status;

    @Column(name = "module_id")
    private Integer moduleId;

    @Column(name = "company_id")
    private Integer companyId;

    @Column(name = "display_priority")
    private Integer displayPriority;

    @Column(name = "thankyou_description")
    private Integer description;

    @Column(name = "add_on_group_id")
    private Integer addOnGroupId;

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

    public Integer getDescription() {
        return description;
    }

    public void setDescription(Integer description) {
        this.description = description;
    }

}
