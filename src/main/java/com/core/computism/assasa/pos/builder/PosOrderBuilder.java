package com.core.computism.assasa.pos.builder;

import com.core.computism.assasa.exception.BuilderException;
import com.core.computism.assasa.persistence.entity.pos.PosOrder;
import com.core.computism.assasa.pos.domain.PosOrderDto;
import com.core.computism.assasa.pos.domain.type.PosOrderStatus;

/**
 * Created by M.Mustafa Amin Shah
 * on 4/13/2016.
 */
public class PosOrderBuilder {

    public PosOrder buildPosOrderEntity(PosOrder posOrder,PosOrderDto posOrderDto) throws BuilderException {
        if(posOrder == null || posOrderDto == null){
            throw new BuilderException("Unable to build the POS Order Entity");
        }

        posOrder.setId(posOrderDto.getId());
        posOrder.setInvoiceNumber(posOrderDto.getInvoiceNumber());
        posOrder.setBatchNumber(posOrderDto.getBatchNumber());
        posOrder.setNumberOfItems(posOrderDto.getNumberOfItems());
        posOrder.setPosOrderStatus(PosOrderStatus.PENDING);

        return posOrder;
    }
}
