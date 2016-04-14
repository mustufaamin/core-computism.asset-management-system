package com.core.computism.assasa.pos.builder;

import com.core.computism.assasa.exception.BuilderException;
import com.core.computism.assasa.pos.domain.CityDto;
import com.core.computism.assasa.persistence.entity.cmn.City;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

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
    public List<CityDto> buildCityDtoList(List<City> cities){
        List<CityDto> cityDtos = new ArrayList<>(0);

        for(City city : cities){
            cityDtos.add(buildCityDto(city));
        }
        return cityDtos;
    }
}
