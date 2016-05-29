package com.core.computism.assasa.common.service;

import com.core.computism.assasa.common.domain.CurrencyDto;
import com.core.computism.assasa.exception.AssasaBusinessException;
import com.core.computism.assasa.persistence.entity.common.Currency;

import java.util.List;

/**
 * Created by VD on 5/2/2016.
 */
public interface CurrencyService {
    CurrencyDto add(CurrencyDto currencyDto) throws AssasaBusinessException;
    List<CurrencyDto> list() throws AssasaBusinessException;
    Currency getCurrency(Long currencyId) throws AssasaBusinessException;
}
