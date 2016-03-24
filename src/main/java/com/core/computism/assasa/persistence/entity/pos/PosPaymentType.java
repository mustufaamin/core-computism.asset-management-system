package com.core.computism.assasa.persistence.entity.pos;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.sql.Timestamp;

/**
 * Created by M.Mustufa Amin Shah on 3/23/2016.
 */
@Entity
@Table(name = "pos_payment_type")
public class PosPaymentType extends BaseEntity{

    private String paymentTypeName;
    private String paymentTypeDesc;
    private Integer glAccountId;

    @Basic
    @Column(name = "payment_type_name", nullable = false, insertable = true, updatable = true, length = 20)
    public String getPaymentTypeName() {
        return paymentTypeName;
    }

    public void setPaymentTypeName(String paymentTypeName) {
        this.paymentTypeName = paymentTypeName;
    }

    @Basic
    @Column(name = "payment_type_desc", nullable = true, insertable = true, updatable = true, length = 35)
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

}
