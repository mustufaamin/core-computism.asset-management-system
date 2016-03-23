package com.core.computism.assasa.pos.service;

import com.core.computism.assasa.exception.PosBusinessException;
import com.core.computism.assasa.pos.domain.CountryDto;

import java.util.List;

/**
 * Created by M.Mustufa Amin Shah on 3/13/2016.
 */
public interface CountryService {
    Long add(CountryDto countryDto) throws PosBusinessException;
    public CountryDto findCountry(Long id) throws PosBusinessException ;
    List<CountryDto> findAllCountries() throws PosBusinessException;
}
