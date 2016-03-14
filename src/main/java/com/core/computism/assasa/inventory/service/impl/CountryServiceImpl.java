package com.core.computism.assasa.inventory.service.impl;

import com.core.computism.assasa.exception.BuilderException;
import com.core.computism.assasa.exception.PosBusinessException;
import com.core.computism.assasa.inventory.builder.CountryBuilder;
import com.core.computism.assasa.inventory.domain.CountryDto;
import com.core.computism.assasa.inventory.service.CountryService;
import com.core.computism.assasa.persistence.entity.inventory.Country;
import com.core.computism.assasa.persistence.repository.inventory.CountryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by Mustafa Amin Shah on 3/13/2016.
 */
public class CountryServiceImpl implements CountryService{
    @Autowired private CountryBuilder countryBuilder;
    @Autowired private CountryRepository countryRepository;

    @Override
    @Transactional(propagation = Propagation.REQUIRED, readOnly = false, rollbackFor = PosBusinessException.class)
    public Long add(CountryDto countryDto) throws PosBusinessException {
        try {
            Country country = countryBuilder.buildCountryEntity(countryDto);
            country = countryRepository.save(country);

            return country.getId();
        }catch (BuilderException e){
            throw new PosBusinessException("Error occurred while adding the country",e);
        }
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, readOnly = true)
    public CountryDto getCountry(Long id) throws PosBusinessException {
        try {
            return countryBuilder.builderCountryDto(countryRepository.findOne(id));
        } catch (BuilderException e) {
            throw new PosBusinessException("Error Occurred While fetching Country", e);
        }
    }
}
