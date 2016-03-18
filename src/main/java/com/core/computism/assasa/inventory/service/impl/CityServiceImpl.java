package com.core.computism.assasa.inventory.service.impl;

import com.core.computism.assasa.exception.BuilderException;
import com.core.computism.assasa.exception.PosBusinessException;
import com.core.computism.assasa.inventory.builder.CityBuilder;
import com.core.computism.assasa.inventory.domain.CityDto;
import com.core.computism.assasa.inventory.service.CityService;
import com.core.computism.assasa.persistence.entity.inventory.City;
import com.core.computism.assasa.persistence.repository.inventory.CityRepository;
import com.core.computism.assasa.persistence.repository.inventory.CountryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by M.Mustafa Amin Shah on 3/13/2016.
 */
@Service(value = "cityService")
public class CityServiceImpl implements CityService {

    @Autowired CityRepository cityRepository;
    @Autowired CityBuilder cityBuilder;
    @Autowired CountryRepository countryRepository;

    @Override
    @Transactional(propagation = Propagation.REQUIRED, readOnly = false, rollbackFor = PosBusinessException.class)
    public Long add(CityDto cityDto) throws PosBusinessException {
        try {
            City city = cityBuilder.buildCityEntity(cityDto);
            city.setCountry(countryRepository.findOne(cityDto.getCountry_id()));
            city = cityRepository.save(city);

            return city.getId();
        } catch (BuilderException e) {
            throw new PosBusinessException("Error Occurred While saving City",e);
        }
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, readOnly = true)
    public CityDto getCity(Long id) {
        return cityBuilder.buildCityDto(cityRepository.findOne(id));
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, readOnly = true)
    public List<CityDto> getCitiesByCountry(Long countryId){
        List<City> cities = cityRepository.findCityByCountryId(countryId);
        return cityBuilder.buildCityDtoList(cities);
    }


}
