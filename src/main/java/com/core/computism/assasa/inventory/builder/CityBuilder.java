package com.core.computism.assasa.inventory.builder;

import com.core.computism.assasa.exception.BuilderException;
import com.core.computism.assasa.inventory.domain.CityDto;
import com.core.computism.assasa.persistence.entity.inventory.City;
import com.core.computism.assasa.persistence.repository.inventory.CountryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by Mustafa Amin Shah on 3/13/2016.
 */
@Component(value = "cityBuilder")
public class CityBuilder {

    public City buildCityEntity(CityDto cityDto) throws BuilderException {

        if(cityDto == null){
            throw new BuilderException("city Dto not present");
        }
        City city = new City();

        city.setId(cityDto.getId());
        city.setName(cityDto.getName());
        city.setState(cityDto.getState());

        return city;
    }
    public CityDto buildCityDto(City city){
        CityDto cityDto = new CityDto();

        cityDto.setId(city.getId());
        cityDto.setName(city.getName());
        cityDto.setState(city.getState());
        cityDto.setCountry_id(city.getCountry().getId());

        return cityDto;
    }
}
