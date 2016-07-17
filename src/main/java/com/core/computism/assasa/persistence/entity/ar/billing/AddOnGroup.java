package com.core.computism.assasa.persistence.entity.ar.billing;

import com.core.computism.assasa.persistence.entity.gl.admin.GlAccount;
import com.core.computism.assasa.persistence.entity.pos.BaseEntity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 * Created by VD on 7/11/2016.
 */
@Entity
@Table(name = "bi_add_on_group")
public class AddOnGroup extends BaseEntity {

    private String name;
    private String description;
    private Integer taxGroupFlag;
    private Integer status;
    private Integer companyId;
    private List<AddOnGroupDetail> addOnGroupDetails;

    public AddOnGroup() {}

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

    @Column(name = "tax_group_flag")
    public Integer getTaxGroupFlag() {
        return taxGroupFlag;
    }

    public void setTaxGroupFlag(Integer taxGroupFlag) {
        this.taxGroupFlag = taxGroupFlag;
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

    @OneToMany(mappedBy = "addOnGroup", cascade = CascadeType.ALL)
    public List<AddOnGroupDetail> getAddOnGroupDetails() {
        return addOnGroupDetails;
    }

    public void setAddOnGroupDetails(List<AddOnGroupDetail> addOnGroupDetails) {
        this.addOnGroupDetails = addOnGroupDetails;
    }
}
