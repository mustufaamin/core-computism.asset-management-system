package com.core.computism.assasa.inventory.service;

import com.core.computism.assasa.exception.PosBusinessException;
import com.core.computism.assasa.inventory.domain.CityDto;

/**
 * Created by Mustafa Amin on 3/13/2016.
 */
public interface CityService {
    Long add(CityDto cityDto) throws PosBusinessException;
    public CityDto getCity(Long id);
}
