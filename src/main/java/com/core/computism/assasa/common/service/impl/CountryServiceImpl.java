package com.core.computism.assasa.common.service.impl;

import com.core.computism.assasa.exception.BuilderException;
import com.core.computism.assasa.exception.PosBusinessException;
import com.core.computism.assasa.common.builder.CountryBuilder;
import com.core.computism.assasa.common.domain.CountryDto;
import com.core.computism.assasa.common.service.CountryService;
import com.core.computism.assasa.persistence.entity.common.Country;
import com.core.computism.assasa.persistence.repository.common.CountryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Mustafa Amin Shah on 3/13/2016.
 */
@Service(value = "countryService")
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
            throw new PosBusinessException("Error occurred Country add",e);
        }
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, readOnly = true)
    public CountryDto findCountry(Long id) throws PosBusinessException {
        try {
            return countryBuilder.builderCountryDto(countryRepository.findOne(id));
        } catch (BuilderException e) {
            throw new PosBusinessException("Error Occurred on getCountry", e);
        }
    }
    @Override
    @Transactional(propagation = Propagation.REQUIRED, readOnly = true)
    public List<CountryDto> findAllCountries() throws PosBusinessException {
        try {
            List<Country> countries = countryRepository.findAll();
            return countryBuilder.buildCountryDtoList(countries);
        } catch (BuilderException e) {
            throw new PosBusinessException("Error Occurred getCountties", e);
        }
    }
}
