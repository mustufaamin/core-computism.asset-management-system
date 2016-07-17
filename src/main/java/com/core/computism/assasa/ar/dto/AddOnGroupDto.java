package com.core.computism.assasa.ar.dto;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

/**
 * Created by VD on 7/11/2016.
 */
@JsonAutoDetect
@JsonIgnoreProperties(ignoreUnknown = true)
public class AddOnGroupDto {

    private Long addOnGroupId;
    private String name;
    private String description;
    private Integer taxGroupFlag;
    private Integer status;
    private Integer companyId;
    private List<AddOnGroupDetailDto> addOnGroupDetailDtos;

    public AddOnGroupDto() {
    }

    public Long getAddOnGroupId() {
        return addOnGroupId;
    }

    public void setAddOnGroupId(Long addOnGroupId) {
        this.addOnGroupId = addOnGroupId;
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

    public Integer getTaxGroupFlag() {
        return taxGroupFlag;
    }

    public void setTaxGroupFlag(Integer taxGroupFlag) {
        this.taxGroupFlag = taxGroupFlag;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getCompanyId() {
        return companyId;
    }

    public void setCompanyId(Integer companyId) {
        this.companyId = companyId;
    }

    public List<AddOnGroupDetailDto> getAddOnGroupDetailDtos() {
        return addOnGroupDetailDtos;
    }

    public void setAddOnGroupDetailDtos(List<AddOnGroupDetailDto> addOnGroupDetailDtos) {
        this.addOnGroupDetailDtos = addOnGroupDetailDtos;
    }
}
