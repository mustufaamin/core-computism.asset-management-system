package com.core.computism.assasa.ar.builder;

import com.core.computism.assasa.ar.dto.AddOnGroupDetailDto;
import com.core.computism.assasa.ar.dto.AddOnGroupDto;
import com.core.computism.assasa.exception.BuilderException;
import com.core.computism.assasa.persistence.entity.ar.billing.AddOnGroup;
import com.core.computism.assasa.persistence.entity.ar.billing.AddOnGroupDetail;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Faizan Iftikhar on 7/12/2016.
 */
@Component(value = "addOnChargeBuilder")
public class AddOnGroupBuilder {

    public AddOnGroup buildAddOnChargeEntity(AddOnGroupDto addOnGroupDto, AddOnGroup addOnGroup) throws BuilderException {

        if (addOnGroupDto == null) {
            throw new BuilderException("Add-On group Dto not present");
        }

        addOnGroup.setName(addOnGroupDto.getName());
        addOnGroup.setDescription(addOnGroupDto.getDescription());
        addOnGroup.setStatus(addOnGroupDto.getStatus());
        addOnGroup.setCompanyId(addOnGroupDto.getCompanyId());
        addOnGroup.setTaxGroupFlag(addOnGroupDto.getTaxGroupFlag());

        return addOnGroup;
    }

    public AddOnGroupDto buildAddOnGroupDto(AddOnGroup addOnGroup) throws BuilderException {

        if (addOnGroup == null) {
            throw new BuilderException("Add-On group Entity not present");
        }

        AddOnGroupDto addOnGroupDto = new AddOnGroupDto();
        addOnGroupDto.setAddOnGroupId(addOnGroup.getId());
        addOnGroupDto.setName(addOnGroup.getName());
        addOnGroupDto.setDescription(addOnGroup.getDescription());
        addOnGroupDto.setStatus(addOnGroup.getStatus());
        addOnGroupDto.setCompanyId(addOnGroup.getCompanyId());
        addOnGroupDto.setTaxGroupFlag(addOnGroup.getTaxGroupFlag());

        return addOnGroupDto;
    }

    public List<AddOnGroupDto> buildAddOnGroupDtoList(List<AddOnGroup> addOnGroups) throws BuilderException {
        List<AddOnGroupDto> addOnGroupDtos = new ArrayList<>(addOnGroups.size());

        for (AddOnGroup addOnGroup : addOnGroups) {
            addOnGroupDtos.add(buildAddOnGroupDto(addOnGroup));
        }
        return addOnGroupDtos;
    }

}
