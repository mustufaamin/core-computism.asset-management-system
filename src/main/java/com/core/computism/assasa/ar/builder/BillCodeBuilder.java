package com.core.computism.assasa.ar.builder;

import com.core.computism.assasa.exception.BuilderException;
import com.core.computism.assasa.ar.dto.BillCodeDto;
import com.core.computism.assasa.ar.type.BillCodeType;
import com.core.computism.assasa.persistence.entity.ar.billing.BillCode;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by M.Mustufa Amin on 3/23/2016.
 */
@Component(value = "billCodeBuilder")
public class BillCodeBuilder {

    public BillCode buildBillCodeEntity(BillCodeDto billCodeDto,BillCode billCode) throws BuilderException {

        if(billCodeDto == null){
            throw new BuilderException("city Dto not present");
        }

        billCode.setName(billCodeDto.getName());
        billCode.setBillCodeTypeId(billCodeDto.getBillCodeType().getCode());
        billCode.setAddOnGroupId(billCodeDto.getAddOnGroupId());
        billCode.setDescription(billCodeDto.getDescription());
        billCode.setActivationDate(billCodeDto.getActivationDate());
        billCode.setDeactivationDate(billCodeDto.getDeactivationDate());
        billCode.setStatus(billCodeDto.getStatus());

        return billCode;
    }

    public BillCodeDto buildBillCodeDto(BillCode billCode) throws BuilderException {

        if(billCode == null){
            throw new BuilderException("city Entity not present");
        }

        BillCodeDto billCodeDto = new BillCodeDto();

        billCodeDto.setName(billCode.getName());
        billCodeDto.setBillCodeType(BillCodeType.getBillCodeType(billCode.getBillCodeTypeId()));
        billCodeDto.setAddOnGroupId(billCode.getAddOnGroupId());
        billCodeDto.setDescription(billCode.getDescription());
        billCodeDto.setActivationDate(billCode.getActivationDate());
        billCodeDto.setDeactivationDate(billCode.getDeactivationDate());
        billCodeDto.setStatus(billCode.getStatus());

        return billCodeDto;
    }

    public List<BillCodeDto> buildBillCodeDtoList(List<BillCode> billCodes) throws BuilderException {
        List<BillCodeDto> billCodeDtos = new ArrayList<>(billCodes.size());

        for (BillCode billCode: billCodes){
            billCodeDtos.add(buildBillCodeDto(billCode));
        }
        return billCodeDtos;
    }

}
