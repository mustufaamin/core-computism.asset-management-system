package com.core.computism.assasa.pos.service;

import com.core.computism.assasa.pos.domain.PosItemDto;
import com.core.computism.assasa.exception.PosBusinessException;

import java.util.List;

/**
 * Created by VD on 2/19/2016.
 */
public interface PosItemService {
    Long add(PosItemDto posItemDto) throws PosBusinessException;
    Long update(PosItemDto posItemDto) throws PosBusinessException;
    PosItemDto get(Long itemId) throws PosBusinessException;
    Long addItemType(String typeName) throws PosBusinessException;
    List<PosItemDto> list() throws PosBusinessException;

}
