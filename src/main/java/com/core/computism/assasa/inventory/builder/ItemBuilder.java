package com.core.computism.assasa.inventory.builder;

import com.core.computism.assasa.exception.BuilderException;
import com.core.computism.assasa.inventory.domain.ItemDto;
import com.core.computism.assasa.persistence.entity.inventory.Item;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by VD on 2/20/2016.
 */
@Component(value = "itemBuilder")
public class ItemBuilder {

    public ItemDto buildItemDto(Item item) throws BuilderException {
        if (item == null) {
            throw new BuilderException("Unable to build Item DTO for [null] Item.");
        }
        ItemDto itemDto = new ItemDto();

        itemDto.setId(item.getId());
        itemDto.setItemNumber(item.getItemNumber());
        itemDto.setItemUnit(item.getItemUnit());
        itemDto.setStockLevel(item.getStockLevel());
        itemDto.setMinStockLevel(item.getMinStockLevel());
        itemDto.setCostPrice(item.getCostPrice());
        itemDto.setSalesPrice(item.getSalesPrice());
        itemDto.setLocation(item.getLocation());
        itemDto.setItemDescription(item.getItemDescription());

        return itemDto;
    }
    public Item buildItemEntity( Item item, ItemDto itemDto) {

        item.setItemNumber(itemDto.getItemNumber());
        item.setItemUnit(itemDto.getItemUnit());
        item.setStockLevel(itemDto.getStockLevel());
        item.setMinStockLevel(itemDto.getMinStockLevel());
        item.setCostPrice(itemDto.getCostPrice());
        item.setSalesPrice(itemDto.getSalesPrice());
        item.setLocation(itemDto.getLocation());
        item.setItemDescription(itemDto.getItemDescription());
        return item;

    }
    public List<ItemDto> buildItemDtoList(List<Item> items) throws BuilderException {
        if(items == null || items.size() < 1){
            throw new BuilderException("Unable to build Item DTO List for [null] Item or empty.");
        }

        List<ItemDto> itemDtos = new ArrayList<>();

        for(Item item : items){
            itemDtos.add(buildItemDto(item));
        }
        return itemDtos;
    }


}
