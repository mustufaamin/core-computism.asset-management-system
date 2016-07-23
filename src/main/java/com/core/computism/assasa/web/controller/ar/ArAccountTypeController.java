package com.core.computism.assasa.web.controller.ar;

import com.core.computism.assasa.ar.dto.ArAccountTypeDto;
import com.core.computism.assasa.ar.service.ArAccountService;
import com.core.computism.assasa.ar.service.ArAccountTypeService;
import com.core.computism.assasa.exception.ArBusinessException;
import com.core.computism.assasa.util.ServerResponse;
import com.core.computism.assasa.web.controller.BaseController;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

/**
 * Created by VD on 2/20/2016.
 */
@RestController(value = "arAccountTypeController")
@RequestMapping(value = "/arAccountType/", produces = {MediaType.APPLICATION_JSON_VALUE + "; charset=utf-8"})
public class ArAccountTypeController extends BaseController {

    private static final Logger LOGGER = Logger.getLogger(ArAccountTypeController.class);

    @Autowired
    ArAccountService arAccountService;

    @Autowired
    ArAccountTypeService arAccountTypeService;

    @RequestMapping(value = "add", method = RequestMethod.POST)
    public Map<String, Object> addArAccountType(@RequestBody ArAccountTypeDto arAccountTypeDto) throws Exception {
        try {
            arAccountTypeService.saveArAccountType(arAccountTypeDto);
            return createSuccessModelMap();
        } catch (ArBusinessException e) {
            throw new ArBusinessException(e);
        }
    }

    @RequestMapping(value = "arAccountTypes", method = RequestMethod.GET)
    public ServerResponse<List<ArAccountTypeDto>> getArAccountTypes() throws ArBusinessException {
        LOGGER.info("Retrieving ArAccountTypes ...");
        ServerResponse<List<ArAccountTypeDto>> response = toResponse(arAccountTypeService.getArAccountTypes());
        return response;
    }

    @RequestMapping(value = "update", method = RequestMethod.POST)
    public ServerResponse<ArAccountTypeDto> update(@RequestBody ArAccountTypeDto arAccountTypeDto) throws ArBusinessException {
        LOGGER.info("update arAccountTypeDto..");
        ServerResponse<ArAccountTypeDto> response = toResponse(arAccountTypeService.update(arAccountTypeDto));
        return response;
    }

    @RequestMapping(value = "get/{arAccountTypeId}", method = RequestMethod.GET)
    public ServerResponse<ArAccountTypeDto> get(@PathVariable Long arAccountTypeId) throws ArBusinessException {
        LOGGER.info("Retrieving arAccountTypeDto...");
        ServerResponse<ArAccountTypeDto> response = toResponse(arAccountTypeService.getArAccountType(arAccountTypeId));
        return response;
    }

    @RequestMapping(value = "heartbeat", method = {RequestMethod.GET})
    public
    @ResponseBody
    String getHeartBeat() {

        return ("Joey: How you doin! <br/> System: Get lost!");
    }
}

