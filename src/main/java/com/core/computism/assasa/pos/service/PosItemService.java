package com.core.computism.assasa.pos.service;

import com.core.computism.assasa.pos.domain.ItemDto;
import com.core.computism.assasa.exception.PosBusinessException;

import java.util.List;

/**
 * Created by VD on 2/19/2016.
 */
public interface PosItemService {
    Long add(ItemDto itemDto) throws PosBusinessException;
    Long update(ItemDto itemDto) throws PosBusinessException;
    ItemDto get(Long itemId) throws PosBusinessException;
    Long addItemType(String typeName) throws PosBusinessException;
    List<ItemDto> list() throws PosBusinessException;

}
