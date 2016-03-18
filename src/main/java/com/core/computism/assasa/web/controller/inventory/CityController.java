package com.core.computism.assasa.web.controller.inventory;

import com.core.computism.assasa.exception.PosBusinessException;
import com.core.computism.assasa.inventory.domain.CityDto;
import com.core.computism.assasa.inventory.service.CityService;
import com.core.computism.assasa.util.ServerResponse;
import com.core.computism.assasa.web.controller.BaseController;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by VD on 3/13/2016.
 */
@RestController
@RequestMapping(value = "city/")
public class CityController extends BaseController {
    private static final Logger LOGGER = Logger.getLogger(CityController.class);

    @Autowired
    CityService cityService;

    @RequestMapping(value = "get/{cityId}", method = RequestMethod.GET)
    public ServerResponse<CityDto> get(@PathVariable Long cityId) throws PosBusinessException {
        LOGGER.info("Retrieving Cities ...");
        ServerResponse<CityDto> response = toResponse(cityService.getCity(cityId));
        return response;
    }
    @RequestMapping(value = "getCities/{countryId}", method = RequestMethod.GET)
    public ServerResponse<List<CityDto>> getCitiesByCountry(@PathVariable Long countryId) throws PosBusinessException {
        LOGGER.info("Retrieving Cities ...");
        ServerResponse<List<CityDto>> response = toResponse(cityService.getCitiesByCountry(countryId));
        return response;
    }

}
