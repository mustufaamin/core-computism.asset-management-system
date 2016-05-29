package com.core.computism.assasa.ar.builder;

import com.core.computism.assasa.ar.dto.ArQuotationDto;
import com.core.computism.assasa.ar.enumtype.ArQuotationStatus;
import com.core.computism.assasa.exception.BuilderException;
import com.core.computism.assasa.persistence.entity.ar.ArQuotation;
import com.core.computism.assasa.persistence.entity.pos.PosOrder;
import com.core.computism.assasa.pos.domain.PosOrderDto;
import com.core.computism.assasa.pos.domain.type.PosOrderStatus;
import org.springframework.stereotype.Component;

/**
 * Created by VD on 5/28/2016.
 */
@Component(value = "arQuotationBuilder")
public class ArQuotationBuilder {
    public ArQuotation buildArQuotationEntity(ArQuotation arQuotation, ArQuotationDto arQuotationDto) throws BuilderException {
        if(arQuotation == null || arQuotationDto == null){
            throw new BuilderException("Unable to build the POS Order Entity");
        }

        arQuotation.setId(arQuotationDto.getId());
        arQuotation.setNumberOfItems(arQuotationDto.getNumberOfItems());
        arQuotation.setArQuotationStatus(ArQuotationStatus.getArQuotationType(arQuotationDto.getStatus()));
        arQuotation.setTotalAmount(arQuotationDto.getTotalAmount());
        arQuotation.setCareOf(arQuotationDto.getCareOf());

        return arQuotation;
    }


}
