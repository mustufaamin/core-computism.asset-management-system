package com.core.computism.assasa.ar.dto;

import com.core.computism.assasa.ar.type.BillCodeType;
import com.fasterxml.jackson.annotation.JsonAutoDetect;

import java.util.Date;

/**
 * Created by M.Mustufa Amin SHah on 3/23/2016.
 */
@JsonAutoDetect
public class BillCodeDto {

    private Long id;
    private BillCodeType billCodeType;
    private Integer addOnGroupId;
    private Long glAccountId;
    private String name;
    private String description;
    private Date activationDate;
    private Date deactivationDate;
    private Integer status;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public BillCodeType getBillCodeType() {
        return billCodeType;
    }

    public void setBillCodeType(BillCodeType billCodeType) {
        this.billCodeType = billCodeType;
    }

    public Integer getAddOnGroupId() {
        return addOnGroupId;
    }

    public void setAddOnGroupId(Integer addOnGroupId) {
        this.addOnGroupId = addOnGroupId;
    }

    public Long getGlAccountId() {
        return glAccountId;
    }

    public void setGlAccountId(Long glAccountId) {
        this.glAccountId = glAccountId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getActivationDate() {
        return activationDate;
    }

    public void setActivationDate(Date activationDate) {
        this.activationDate = activationDate;
    }

    public Date getDeactivationDate() {
        return deactivationDate;
    }

    public void setDeactivationDate(Date deactivationDate) {
        this.deactivationDate = deactivationDate;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
}
