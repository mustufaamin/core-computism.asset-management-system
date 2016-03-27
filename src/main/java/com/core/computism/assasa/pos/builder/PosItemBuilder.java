package com.core.computism.assasa.pos.builder;

import com.core.computism.assasa.exception.BuilderException;
import com.core.computism.assasa.pos.domain.PosItemDto;
import com.core.computism.assasa.persistence.entity.pos.PosItem;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by VD on 2/20/2016.
 */
@Component(value = "posItemBuilder")
public class PosItemBuilder {

    public PosItemDto buildItemDto(PosItem posItem) throws BuilderException {
        if (posItem == null) {
            throw new BuilderException("Unable to build Item DTO for [null] Item.");
        }
        PosItemDto posItemDto = new PosItemDto();

        posItemDto.setId(posItem.getId());
        posItemDto.setItemNumber(posItem.getItemNumber());
        posItemDto.setItemUnit(posItem.getItemUnit());
        posItemDto.setStockLevel(posItem.getStockLevel());
        posItemDto.setMinStockLevel(posItem.getMinStockLevel());
        posItemDto.setCostPrice(posItem.getCostPrice());
        posItemDto.setSalesPrice(posItem.getSalesPrice());
        posItemDto.setLocation(posItem.getLocation());
        posItemDto.setItemDescription(posItem.getItemDescription());

        return posItemDto;
    }
    public PosItem buildItemEntity( PosItem posItem, PosItemDto posItemDto) {

        posItem.setItemNumber(posItemDto.getItemNumber());
        posItem.setItemUnit(posItemDto.getItemUnit());
        posItem.setStockLevel(posItemDto.getStockLevel());
        posItem.setMinStockLevel(posItemDto.getMinStockLevel());
        posItem.setCostPrice(posItemDto.getCostPrice());
        posItem.setSalesPrice(posItemDto.getSalesPrice());
        posItem.setLocation(posItemDto.getLocation());
        posItem.setItemDescription(posItemDto.getItemDescription());
        return posItem;

    }
    public List<PosItemDto> buildItemDtoList(List<PosItem> posItems) throws BuilderException {
        List<PosItemDto> posItemDtos = new ArrayList<>();

        for(PosItem posItem : posItems){
            posItemDtos.add(buildItemDto(posItem));
        }
        return posItemDtos;
    }


}
