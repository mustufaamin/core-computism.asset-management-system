package com.core.computism.assasa.pos.service;

import com.core.computism.assasa.exception.PosBusinessException;
import com.core.computism.assasa.pos.domain.PosPaymentTypeDto;

import java.util.List;

/**
 * Created by M.Mustafa Amin Shah on 4/3/2016.
 */
public interface PosPaymentTypeService {

    List<PosPaymentTypeDto> list() throws PosBusinessException;
    PosPaymentTypeDto update(PosPaymentTypeDto posPaymentTypeDto) throws PosBusinessException;
    PosPaymentTypeDto add(PosPaymentTypeDto posPaymentTypeDto) throws PosBusinessException;
}
