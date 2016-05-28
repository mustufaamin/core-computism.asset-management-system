package com.core.computism.assasa.ar.service;

import com.core.computism.assasa.ar.dto.ArQuotationDto;
import com.core.computism.assasa.exception.AssasaBusinessException;
import com.core.computism.assasa.exception.PosBusinessException;

/**
 * Created by VD on 5/28/2016.
 */
public interface ArQuotationService {
    void save(ArQuotationDto arQuotationDto) throws AssasaBusinessException, PosBusinessException;
}

