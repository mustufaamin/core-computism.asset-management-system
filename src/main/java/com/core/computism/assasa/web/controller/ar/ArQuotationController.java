package com.core.computism.assasa.web.controller.ar;

import com.core.computism.assasa.ar.Response;
import com.core.computism.assasa.ar.dto.ArAccountDto;
import com.core.computism.assasa.ar.dto.ArQuotationDto;
import com.core.computism.assasa.ar.service.ArQuotationService;
import com.core.computism.assasa.exception.ArBusinessException;
import com.core.computism.assasa.exception.AssasaBusinessException;
import com.core.computism.assasa.exception.PosBusinessException;
import com.core.computism.assasa.web.controller.BaseController;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.Map;

/**
 * Created by VD on 5/28/2016.
 */
@Controller(value = "arQuotationController")
@RequestMapping(value = "/ar/quotation/", produces = {MediaType.APPLICATION_JSON_VALUE + "; charset=utf-8"})
public class ArQuotationController extends BaseController {
    private static final Logger LOGGER = Logger.getLogger(ArQuotationController.class);

    @Autowired
    private ArQuotationService arQuotationService;

    @RequestMapping(value = "save", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.OK)
    public void addAccount(@RequestBody ArQuotationDto arQuotationDto) throws AssasaBusinessException, PosBusinessException {
        LOGGER.info("Saving Quotation....");
        arQuotationService.save(arQuotationDto);
    }


}
