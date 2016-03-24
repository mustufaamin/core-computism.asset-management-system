package com.core.computism.assasa.persistence.entity.ar;

import com.core.computism.assasa.persistence.entity.pos.*;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.sql.Timestamp;

/**
 * Created by VD on 3/23/2016.
 */
@Entity
@Table(name = "cmn_payment_type")
public class PaymentType extends BaseEntity {

    private String paymentTypeName;
    private String paymentTypeDesc;
    private Integer glAccountId;
    private Integer status;
    private Integer moduleId;
    private Integer companyId;
    private Integer addOnGroupId;
    private Integer displayPriority;
    private String thankyouDescription;


    @Basic
    @Column(name = "payment_type_name", nullable = false, insertable = true, updatable = true, length = 50)
    public String getPaymentTypeName() {
        return paymentTypeName;
    }

    public void setPaymentTypeName(String paymentTypeName) {
        this.paymentTypeName = paymentTypeName;
    }

    @Basic
    @Column(name = "payment_type_desc", nullable = true, insertable = true, updatable = true, length = 255)
    public String getPaymentTypeDesc() {
        return paymentTypeDesc;
    }

    public void setPaymentTypeDesc(String paymentTypeDesc) {
        this.paymentTypeDesc = paymentTypeDesc;
    }

    @Basic
    @Column(name = "gl_account_id", nullable = true, insertable = true, updatable = true)
    public Integer getGlAccountId() {
        return glAccountId;
    }

    public void setGlAccountId(Integer glAccountId) {
        this.glAccountId = glAccountId;
    }

    @Basic
    @Column(name = "status", nullable = true, insertable = true, updatable = true)
    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    @Basic
    @Column(name = "module_id", nullable = true, insertable = true, updatable = true)
    public Integer getModuleId() {
        return moduleId;
    }

    public void setModuleId(Integer moduleId) {
        this.moduleId = moduleId;
    }

    @Basic
    @Column(name = "company_id", nullable = true, insertable = true, updatable = true)
    public Integer getCompanyId() {
        return companyId;
    }

    public void setCompanyId(Integer companyId) {
        this.companyId = companyId;
    }

    @Basic
    @Column(name = "add_on_group_id", nullable = true, insertable = true, updatable = true)
    public Integer getAddOnGroupId() {
        return addOnGroupId;
    }

    public void setAddOnGroupId(Integer addOnGroupId) {
        this.addOnGroupId = addOnGroupId;
    }

    @Basic
    @Column(name = "display_priority", nullable = true, insertable = true, updatable = true)
    public Integer getDisplayPriority() {
        return displayPriority;
    }

    public void setDisplayPriority(Integer displayPriority) {
        this.displayPriority = displayPriority;
    }

    @Basic
    @Column(name = "thankyou_description", nullable = true, insertable = true, updatable = true, length = 255)
    public String getThankyouDescription() {
        return thankyouDescription;
    }

    public void setThankyouDescription(String thankyouDescription) {
        this.thankyouDescription = thankyouDescription;
    }


}