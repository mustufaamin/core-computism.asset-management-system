package com.core.computism.assasa.web.controller.ar;

import com.core.computism.assasa.ar.dto.*;
import com.core.computism.assasa.ar.service.ArAccountService;
import com.core.computism.assasa.ar.service.ArAccountTypeService;
import com.core.computism.assasa.exception.ArBusinessException;
import com.core.computism.assasa.util.ServerResponse;
import com.core.computism.assasa.web.controller.BaseController;
import jdk.nashorn.internal.runtime.ECMAException;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.List;
import java.util.Map;

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
    public Map<String, Object> addAccount(@RequestBody ArAccountDto arAccountDto) throws Exception {
        try {
            arAccountService.saveArAccount(arAccountDto);
            return createSuccessModelMap();
        } catch (ArBusinessException e) {
            throw new Exception(e);
        }
    }

    @RequestMapping(value = "addAccountType", method = RequestMethod.POST)
    public Map<String, Object> addArAccountType(@RequestBody ArAccountTypeDto arAccountTypeDto) throws Exception {
        try {
            arAccountTypeService.saveArAccountType(arAccountTypeDto);
            return createSuccessModelMap();
        } catch (ArBusinessException e) {
            throw new ArBusinessException(e);
        }
    }

    @RequestMapping(value = "list", method = RequestMethod.GET)
    public @ResponseBody
    ServerResponse<List<ArAccountSearchResponseDto>>  getArAccountList() throws ArBusinessException {
        ServerResponse<List<ArAccountSearchResponseDto>> response = toResponse(arAccountService.getArAccounts());
        return response;
    }

    @RequestMapping(value = "search/{searchKey}", method = RequestMethod.GET)
    public
    @ResponseBody
    ServerResponse<List<ArAccountSearchDto>> getArAccountBySearchKey(
            @PathVariable String searchKey
    ) throws ArBusinessException {
        ServerResponse<List<ArAccountSearchDto>> response = toResponse(arAccountService.getArAccountBySearchKey(searchKey));
        return response;
    }

    @RequestMapping(value = "arAccountTypes", method = RequestMethod.GET)
    public @ResponseBody ServerResponse<List<ArAccountTypeDto>> getArAccountTypes() throws ArBusinessException {
        List<ArAccountTypeDto> arAccountTypeDtos = null;
        try {
            arAccountTypeDtos = arAccountTypeService.getArAccountTypes();
            ServerResponse<List< ArAccountTypeDto >> response = toResponse(arAccountTypeDtos);
            return response;
        } catch (ArBusinessException e) {
            throw new ArBusinessException(e);
        }
    }

    @RequestMapping(value = "heartbeat", method = {RequestMethod.GET})
    public
    @ResponseBody
    String getHeartBeat() {

        return ("Joey: How you doin! <br/> System: Get lost!");
    }
}

