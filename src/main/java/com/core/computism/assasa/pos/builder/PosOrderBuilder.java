package com.core.computism.assasa.pos.builder;

import com.core.computism.assasa.exception.BuilderException;
import com.core.computism.assasa.persistence.entity.pos.PosOrder;
import com.core.computism.assasa.persistence.entity.pos.PosOrderItem;
import com.core.computism.assasa.pos.domain.PosOrderDto;
import com.core.computism.assasa.pos.domain.PosOrderItemDto;
import com.core.computism.assasa.pos.domain.type.PosOrderStatus;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by M.Mustafa Amin Shah
 * on 4/13/2016.
 */
@Component(value = "posOrderBuilder")
public class PosOrderBuilder {

    public PosOrder buildPosOrderEntity(PosOrder posOrder,PosOrderDto posOrderDto) throws BuilderException {
        if(posOrder == null || posOrderDto == null){
            throw new BuilderException("Unable to build the POS Order Entity");
        }

        posOrder.setId(posOrderDto.getId());
        posOrder.setNumberOfItems(posOrderDto.getNumberOfItems());
        posOrder.setPosOrderStatus(PosOrderStatus.PENDING);
        posOrder.setTotalAmount(posOrderDto.getTotalAmount());

        return posOrder;
    }

    public PosOrderDto buildPosOrderDto(PosOrder posOrder) throws BuilderException {
        if(posOrder == null){
            throw new BuilderException("Pos Order Entity Not Available");
        }

        PosOrderDto posOrderDto = new PosOrderDto();

        posOrderDto.setId(posOrder.getId());
        posOrderDto.setPosOrderStatus(posOrder.getPosOrderStatus());
        posOrderDto.setCurrencyId(posOrder.getCurrency().getId());
        posOrderDto.setTotalAmount(posOrder.getTotalAmount());
        posOrderDto.setBatchNumber(posOrder.getBatchNumber());
        posOrderDto.setInvoiceNumber(posOrder.getInvoiceNumber());
        posOrderDto.setNumberOfItems(posOrder.getNumberOfItems());
        posOrderDto.setCustomerId(posOrder.getCustomer().getId());

        List<PosOrderItemDto> posOrderItemDtos = new ArrayList<>();

        for(PosOrderItem posOrderItem: posOrder.getPosOrderItems()){
            PosOrderItemDto posOrderItemDto = new PosOrderItemDto();

            posOrderItemDto.setItemId(posOrderItem.getId());
            posOrderItemDto.setQuantity(posOrderItem.getQuantity());
            posOrderItemDtos.add(posOrderItemDto);
        }

        posOrderDto.setItems(posOrderItemDtos);

        return posOrderDto;
    }
}
