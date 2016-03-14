package com.core.computism.assasa.inventory.service;

import com.core.computism.assasa.exception.PosBusinessException;
import com.core.computism.assasa.inventory.domain.CountryDto;

/**
 * Created by VD on 3/13/2016.
 */
public interface CountryService {
    Long add(CountryDto countryDto) throws PosBusinessException;
    public CountryDto getCountry(Long id) throws PosBusinessException ;
}
