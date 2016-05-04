package com.core.computism.assasa.pos.builder;

import com.core.computism.assasa.exception.BuilderException;
import com.core.computism.assasa.persistence.entity.pos.PosItemGroup;
import com.core.computism.assasa.pos.domain.PosItemGroupDto;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by M.Mustufa Amin on 3/27/2016.
 */
@Component(value = "posItemGroupBuilder")
public class PosItemGroupBuilder {

    public PosItemGroupDto buildPosItemGroupDto(PosItemGroup posItemGroup) throws BuilderException {
        if(posItemGroup == null){
            throw new BuilderException("Unable to find PosItemGroupEntity");
        }
        PosItemGroupDto posItemGroupDto = new PosItemGroupDto();

        posItemGroupDto.setId(posItemGroup.getId());
        posItemGroupDto.setGroupName(posItemGroup.getGroupName());
        posItemGroupDto.setGroupDescription(posItemGroup.getGroupDescription());
        posItemGroupDto.setItemGroupStatus(posItemGroup.getItemGroupStatus());
        posItemGroupDto.setBillCodeId(posItemGroup.getBillCode().getId());
        posItemGroupDto.setBillCodeName(posItemGroup.getBillCode().getName());

        return posItemGroupDto;
    }

    public PosItemGroup buildItemGroupEntity(PosItemGroup posItemGroup,PosItemGroupDto posItemGroupDto) throws BuilderException {
        if(posItemGroup == null || posItemGroupDto == null){
            throw new BuilderException("Unable to create Item Group Entity");
        }

        posItemGroup.setGroupName(posItemGroup.getGroupName());
        posItemGroup.setItemGroupStatus(posItemGroup.getItemGroupStatus());
        posItemGroup.setGroupDescription(posItemGroup.getGroupDescription());

        return posItemGroup;
    }

    public List<PosItemGroupDto> buildPosItemGroupList(List<PosItemGroup> posItemGroups) throws BuilderException {
        List<PosItemGroupDto> posItemGroupDtos = new ArrayList<>(posItemGroups.size());

        for(PosItemGroup posItemGroup : posItemGroups){
            posItemGroupDtos.add(buildPosItemGroupDto(posItemGroup));
        }
        return posItemGroupDtos;
    }
}
