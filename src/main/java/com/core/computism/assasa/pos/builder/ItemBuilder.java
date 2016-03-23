package com.core.computism.assasa.pos.builder;

import com.core.computism.assasa.exception.BuilderException;
import com.core.computism.assasa.pos.domain.ItemDto;
import com.core.computism.assasa.persistence.entity.pos.PosItem;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by VD on 2/20/2016.
 */
@Component(value = "itemBuilder")
public class ItemBuilder {

    public ItemDto buildItemDto(PosItem posItem) throws BuilderException {
        if (posItem == null) {
            throw new BuilderException("Unable to build Item DTO for [null] Item.");
        }
        ItemDto itemDto = new ItemDto();

        itemDto.setId(posItem.getId());
        itemDto.setItemNumber(posItem.getItemNumber());
        itemDto.setItemUnit(posItem.getItemUnit());
        itemDto.setStockLevel(posItem.getStockLevel());
        itemDto.setMinStockLevel(posItem.getMinStockLevel());
        itemDto.setCostPrice(posItem.getCostPrice());
        itemDto.setSalesPrice(posItem.getSalesPrice());
        itemDto.setLocation(posItem.getLocation());
        itemDto.setItemDescription(posItem.getItemDescription());

        return itemDto;
    }
    public PosItem buildItemEntity( PosItem posItem, ItemDto itemDto) {

        posItem.setItemNumber(itemDto.getItemNumber());
        posItem.setItemUnit(itemDto.getItemUnit());
        posItem.setStockLevel(itemDto.getStockLevel());
        posItem.setMinStockLevel(itemDto.getMinStockLevel());
        posItem.setCostPrice(itemDto.getCostPrice());
        posItem.setSalesPrice(itemDto.getSalesPrice());
        posItem.setLocation(itemDto.getLocation());
        posItem.setItemDescription(itemDto.getItemDescription());
        return posItem;

    }
    public List<ItemDto> buildItemDtoList(List<PosItem> posItems) throws BuilderException {
        if(posItems == null || posItems.size() < 1){
            throw new BuilderException("Unable to build Item DTO List for [null] Item or empty.");
        }

        List<ItemDto> itemDtos = new ArrayList<>();

        for(PosItem posItem : posItems){
            itemDtos.add(buildItemDto(posItem));
        }
        return itemDtos;
    }


}
