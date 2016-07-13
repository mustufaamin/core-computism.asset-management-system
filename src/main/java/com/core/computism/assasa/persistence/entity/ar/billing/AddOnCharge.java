package com.core.computism.assasa.persistence.entity.ar.billing;

import com.core.computism.assasa.persistence.entity.gl.admin.GlAccount;
import com.core.computism.assasa.persistence.entity.pos.BaseEntity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import java.math.BigDecimal;
import java.util.Date;

/**
 * Created by VD on 7/11/2016.
 */
@Entity
@Table(name = "bi_add_on_charge")
public class AddOnCharge extends BaseEntity {

    private GlAccount glAccount;
    private String name;
    private String description;
    private BigDecimal amount;
    private Integer amountType;
    private Date activationDate;
    private Date deactivationDate;
    private Integer status;
    private Integer companyId;
    private Integer inclusiveFlag;

    public AddOnCharge() {}

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "gl_account_id", referencedColumnName = "id", nullable = false)
    public GlAccount getGlAccount() {
        return glAccount;
    }

    public void setGlAccount(GlAccount glAccount) {
        this.glAccount = glAccount;
    }

    @Column(name = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Column(name = "description")
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Column(name = "amount")
    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    @Column(name = "amount_type")
    public Integer getAmountType() {
        return amountType;
    }

    public void setAmountType(Integer amountType) {
        this.amountType = amountType;
    }

    @Column(name = "activation_date")
    public Date getActivationDate() {
        return activationDate;
    }

    public void setActivationDate(Date activationDate) {
        this.activationDate = activationDate;
    }

    @Column(name = "deactivation_date")
    public Date getDeactivationDate() {
        return deactivationDate;
    }

    public void setDeactivationDate(Date deactivationDate) {
        this.deactivationDate = deactivationDate;
    }

    @Column(name = "status")
    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    @Column(name = "company_id")
    public Integer getCompanyId() {
        return companyId;
    }

    public void setCompanyId(Integer companyId) {
        this.companyId = companyId;
    }

    @Column(name = "inclusive_flag")
    public Integer getInclusiveFlag() {
        return inclusiveFlag;
    }

    public void setInclusiveFlag(Integer inclusiveFlag) {
        this.inclusiveFlag = inclusiveFlag;
    }
}
