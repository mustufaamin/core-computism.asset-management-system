package com.core.computism.assasa.pos.service;

import com.core.computism.assasa.exception.PosBusinessException;
import com.core.computism.assasa.persistence.entity.pos.PosItem;
import com.core.computism.assasa.persistence.entity.pos.PosOrder;
import com.core.computism.assasa.pos.domain.PosItemDto;

import java.util.List;

/**
 * Created by VD on 2/19/2016.
 */
public interface PosItemService {
    PosItemDto add(PosItemDto posItemDto) throws PosBusinessException;
    PosItemDto update(PosItemDto posItemDto) throws PosBusinessException;
    PosItemDto get(Long itemId) throws PosBusinessException;
    Long addItemType(String typeName) throws PosBusinessException;
    List<PosItemDto> list() throws PosBusinessException;
    PosItem findPosItemById(Long itemId) throws PosBusinessException;
    void removeItemStock(PosOrder posOrder ) throws PosBusinessException;
}
