package com.core.computism.assasa.pos.service;

import com.core.computism.assasa.exception.PosBusinessException;
import com.core.computism.assasa.pos.domain.CityDto;

import java.util.List;

/**
 * Created by Mustafa Amin on 3/13/2016.
 */
public interface CityService {
    Long add(CityDto cityDto) throws PosBusinessException;
    CityDto getCity(Long id);
    List<CityDto> getCitiesByCountry(Long countryId);
}
