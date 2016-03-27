package com.core.computism.assasa.pos.service;

import com.core.computism.assasa.exception.PosBusinessException;
import com.core.computism.assasa.pos.domain.PosItemGroupDto;

import java.util.List;

/**
 * Created by M.Mustufa Amin Shah on 3/27/2016.
 */
public interface PosItemGroupService  {
    PosItemGroupDto add(PosItemGroupDto posItemGroupDto) throws PosBusinessException;
    PosItemGroupDto update(PosItemGroupDto posItemGroupDto) throws PosBusinessException;
    List<PosItemGroupDto> list() throws PosBusinessException;
    List<PosItemGroupDto> listByBillCode(Long billCodeId) throws PosBusinessException;
}
