package com.core.computism.assasa.pos.builder;

import com.core.computism.assasa.exception.BuilderException;
import com.core.computism.assasa.persistence.entity.pos.PosPaymentType;
import com.core.computism.assasa.pos.domain.PosPaymentTypeDto;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by M.Mustufa Amin Shah on 4/3/2016.
 */
@Component(value = "posPaymentTypeBuilder")
public class PosPaymentTypeBuilder {

    public PosPaymentTypeDto buildPosPaymentTypeDto(PosPaymentType posPaymentType) throws BuilderException {

        if(posPaymentType == null){
            throw new BuilderException("Pos Payment type is Null");
        }

        PosPaymentTypeDto posPaymentTypeDto = new PosPaymentTypeDto();

        posPaymentTypeDto.setId(posPaymentType.getId());
        posPaymentTypeDto.setPaymentTypeDesc(posPaymentType.getPaymentTypeDesc());
        posPaymentTypeDto.setPaymentTypeName(posPaymentType.getPaymentTypeName());
        //TODO: Need to change it to Account GL Entity
        posPaymentTypeDto.setGlAccountId(posPaymentType.getGlAccountId());

        return posPaymentTypeDto;
    }
    
    public PosPaymentType buildPosPaymentTypeEntity(PosPaymentType posPaymentType, PosPaymentTypeDto posPaymentTypeDto) throws BuilderException {
        if(posPaymentType==null || posPaymentTypeDto ==null){
            throw new BuilderException("Error Occurred while creating the PosPaymentEntity");
        }
        posPaymentType.setId(posPaymentTypeDto.getId());
        posPaymentType.setPaymentTypeDesc(posPaymentTypeDto.getPaymentTypeDesc());
        posPaymentType.setPaymentTypeName(posPaymentTypeDto.getPaymentTypeName());
        //TODO: Change to ENtity
        posPaymentType.setGlAccountId(posPaymentTypeDto.getGlAccountId());

        return posPaymentType;

    }

    public List<PosPaymentTypeDto> buildPaymentTypeDtoList(List<PosPaymentType> posPaymentTypes) throws BuilderException {

        List<PosPaymentTypeDto> posPaymentTypeDtos = new ArrayList<>(posPaymentTypes.size());

        for (PosPaymentType posPaymentType:posPaymentTypes){
            posPaymentTypeDtos.add(buildPosPaymentTypeDto(posPaymentType));
        }
        return posPaymentTypeDtos;
    }
}
