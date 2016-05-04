package com.core.computism.assasa.web.controller.common;

import com.core.computism.assasa.common.domain.CurrencyDto;
import com.core.computism.assasa.common.service.CurrencyService;
import com.core.computism.assasa.exception.AssasaBusinessException;
import com.core.computism.assasa.exception.PosBusinessException;
import com.core.computism.assasa.pos.domain.PosItemDto;
import com.core.computism.assasa.util.ServerResponse;
import com.core.computism.assasa.web.controller.BaseController;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by VD on 5/2/2016.
 */
@RestController
@RequestMapping(value = "/currency/")
public class CurrencyController extends BaseController {
    private static final Logger LOGGER = Logger.getLogger(CurrencyController.class);

    @Autowired private CurrencyService currencyService;

    @RequestMapping(value = "add", method = RequestMethod.GET)
    public ServerResponse<CurrencyDto> add(@RequestBody CurrencyDto currencyDto) throws PosBusinessException, AssasaBusinessException {

        LOGGER.info("Adding Currency ...");
        ServerResponse<CurrencyDto> response = toResponse(currencyService.add(currencyDto));
        return response;
    }

    @RequestMapping(value = "list", method = RequestMethod.GET)
    public ServerResponse<List<CurrencyDto>> add() throws PosBusinessException, AssasaBusinessException {

        LOGGER.info("List Currency ...");
        ServerResponse<List<CurrencyDto>> response = toResponse(currencyService.list());
        return response;
    }
}
