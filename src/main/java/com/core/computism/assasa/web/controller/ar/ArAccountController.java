package com.core.computism.assasa.web.controller.ar;

import com.core.computism.assasa.ar.dto.ArAccountDto;
import com.core.computism.assasa.ar.dto.ArAccountTypeDto;
import com.core.computism.assasa.ar.service.ArAccountService;
import com.core.computism.assasa.ar.service.ArAccountTypeService;
import com.core.computism.assasa.exception.ArBusinessException;
import com.core.computism.assasa.web.controller.BaseController;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.List;

/**
 * Created by VD on 2/20/2016.
 */
@Controller(value = "arAccountController")
@RequestMapping(value = "/arAccount/", produces = {MediaType.APPLICATION_JSON_VALUE + "; charset=utf-8"})
public class ArAccountController extends BaseController {

    private static final Logger LOGGER = Logger.getLogger(ArAccountController.class);

    @Autowired
    ArAccountService arAccountService;

    @Autowired
    ArAccountTypeService arAccountTypeService;

    @RequestMapping(value = "addAccount", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.ACCEPTED)
    public void addAccount(@RequestBody ArAccountDto arAccountDto) throws Exception {
        try {
            arAccountService.saveArAccount(arAccountDto);
        } catch (ArBusinessException e) {
            LOGGER.error(e);
        }
    }

    @RequestMapping(value = "addAccountType", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.ACCEPTED)
    public void addArAccountType(@RequestBody ArAccountTypeDto arAccountTypeDto) throws Exception {
        try {
            arAccountTypeService.saveArAccountType(arAccountTypeDto);
        } catch (ArBusinessException e) {
            LOGGER.error(e);
        }
    }

    @RequestMapping(value = "arAccountTypes", method = RequestMethod.GET)
    public @ResponseBody
    List<ArAccountTypeDto> getArAccountTypes() throws ArBusinessException {
        List<ArAccountTypeDto> arAccountTypeDtos = null;
        try {
            arAccountTypeDtos = arAccountTypeService.getArAccountTypes();
        } catch (ArBusinessException e) {
            LOGGER.error(e);
        }
        return arAccountTypeDtos;
    }

    @RequestMapping(value = "heartbeat", method = {RequestMethod.GET})
    public
    @ResponseBody
    String getHeartBeat() {

        return ("Joey: How you doin! <br/> System: Get lost!");
    }
}

