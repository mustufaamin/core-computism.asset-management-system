package com.core.computism.assasa.inventory.builder;

import com.core.computism.assasa.exception.BuilderException;
import com.core.computism.assasa.inventory.domain.CountryDto;
import com.core.computism.assasa.persistence.entity.inventory.Country;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by M.Mustufa Amin Shah on 3/13/2016.
 */
@Component(value = "countryBuilder")
public class CountryBuilder {
    public Country buildCountryEntity(CountryDto countryDto) throws BuilderException {
        if(countryDto == null){
            throw new BuilderException("city Dto not present");
        }
        Country country = new Country();

        country.setName(countryDto.getName());
        return country;
    }

    public CountryDto builderCountryDto(Country country) throws BuilderException {
        if(country == null){
            throw new BuilderException("City Entity not Present");
        }
        CountryDto countryDto = new CountryDto();

        countryDto.setId(country.getId());
        countryDto.setName(country.getName());

        return countryDto;
    }

    public List<CountryDto> buildCountryDtoList(List<Country> countries) throws BuilderException {
        List<CountryDto> countryDtos = new ArrayList<>(0);
        for(Country country: countries){
            countryDtos.add(builderCountryDto(country));
        }
        return countryDtos;
    }
}
