package com.core.computism.assasa.ar.builder;

import com.core.computism.assasa.ar.dto.AddOnChargeDto;
import com.core.computism.assasa.exception.BuilderException;
import com.core.computism.assasa.persistence.entity.ar.billing.AddOnCharge;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Faizan Iftikhar on 7/12/2016.
 */
@Component(value = "addOnChargeBuilder")
public class AddOnChargeBuilder {

    public AddOnCharge buildAddOnChargeEntity(AddOnChargeDto addOnChargeDto, AddOnCharge addOnCharge) throws BuilderException {

        if (addOnChargeDto == null) {
            throw new BuilderException("Add-On Charge Dto not present");
        }

        addOnCharge.setName(addOnChargeDto.getName());
        addOnCharge.setDescription(addOnChargeDto.getDescription());
        addOnCharge.setAmount(addOnChargeDto.getAmount());
        addOnCharge.setAmountType(addOnChargeDto.getAmountType());
        addOnCharge.setActivationDate(addOnChargeDto.getActivationDate());
        addOnCharge.setDeactivationDate(addOnChargeDto.getDeactivationDate());
        addOnCharge.setStatus(addOnChargeDto.getStatus());
        addOnCharge.setCompanyId(addOnChargeDto.getCompanyId());
        addOnCharge.setInclusiveFlag(addOnChargeDto.getAmountType());

        return addOnCharge;
    }

    public AddOnChargeDto buildAddOnChargeDto(AddOnCharge addOnCharge) throws BuilderException {

        if (addOnCharge == null) {
            throw new BuilderException("Add-On Charge Entity not present");
        }

        AddOnChargeDto addOnChargeDto = new AddOnChargeDto();
        addOnChargeDto.setId(addOnCharge.getId());
        addOnChargeDto.setGlAccountId(addOnCharge.getGlAccount().getId());
        addOnChargeDto.setName(addOnCharge.getName());
        addOnChargeDto.setDescription(addOnCharge.getDescription());
        addOnChargeDto.setAmount(addOnCharge.getAmount());
        addOnChargeDto.setAmountType(addOnCharge.getAmountType());
        addOnChargeDto.setActivationDate(addOnCharge.getActivationDate());
        addOnChargeDto.setDeactivationDate(addOnCharge.getDeactivationDate());
        addOnChargeDto.setStatus(addOnCharge.getStatus());
        addOnChargeDto.setCompanyId(addOnCharge.getCompanyId());
        addOnChargeDto.setInclusiveFlag(addOnCharge.getAmountType());

        return addOnChargeDto;
    }

    public List<AddOnChargeDto> buildAddOnChargeDtoList(List<AddOnCharge> addOnCharges) throws BuilderException {
        List<AddOnChargeDto> addOnChargeDtos = new ArrayList<>(addOnCharges.size());

        for (AddOnCharge addOnCharge : addOnCharges) {
            addOnChargeDtos.add(buildAddOnChargeDto(addOnCharge));
        }
        return addOnChargeDtos;
    }

}
