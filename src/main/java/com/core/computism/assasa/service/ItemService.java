package com.core.computism.assasa.service;

import com.core.computism.assasa.domain.ItemDto;
import com.core.computism.assasa.exception.PosBusinessException;

/**
 * Created by VD on 2/19/2016.
 */
public interface ItemService {
    Long addItem(ItemDto itemDto) throws PosBusinessException;
    Long addItemType(String typeName) throws PosBusinessException;
}
