package com.core.computism.assasa.pos.service;

import com.core.computism.assasa.exception.PosBusinessException;
import com.core.computism.assasa.pos.domain.PosPaymentDto;

import java.util.List;

/**
 * Created by VD on 3/29/2016.
 */
public interface PosPaymentService {

    PosPaymentDto add(PosPaymentDto posPaymentDto) throws PosBusinessException;
    PosPaymentDto update(PosPaymentDto posPaymentDto) throws PosBusinessException;
    List<PosPaymentDto> list() throws PosBusinessException;
}

