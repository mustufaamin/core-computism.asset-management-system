package com.core.computism.assasa.web.controller.pos;

import com.core.computism.assasa.exception.PosBusinessException;
import com.core.computism.assasa.pos.domain.CountryDto;
import com.core.computism.assasa.pos.service.CountryService;
import com.core.computism.assasa.util.ServerResponse;
import com.core.computism.assasa.web.controller.BaseController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import org.apache.log4j.Logger;

import java.util.List;

/**
 * Created by M.Mustufa Amin Shah on 3/18/2016.
 */
@RestController
@RequestMapping(value = "country/")
public class CountryController extends BaseController {
    private static final Logger LOGGER = Logger.getLogger(CountryController.class);

    @Autowired CountryService countryService;

    @RequestMapping(value = "getAll", method = RequestMethod.GET)
    public ServerResponse<List<CountryDto>> getAllCountries() throws PosBusinessException {
        LOGGER.info("Retrieving Countries ...");
        ServerResponse<List<CountryDto>> response = toResponse(countryService.findAllCountries());
        return response;
    }


}
