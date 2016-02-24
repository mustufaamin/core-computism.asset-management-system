package com.core.computism.assasa.web.controller.gl;

import com.core.computism.assasa.exception.ArBusinessException;
import com.core.computism.assasa.gl.dto.AccountTypeDto;
import com.core.computism.assasa.gl.service.AccountTypeService;
import com.core.computism.assasa.web.controller.BaseController;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Created by VD on 2/21/2016.
 */
public class AccountTypeController extends BaseController {

    private static final Logger LOGGER = Logger.getLogger(AccountTypeController.class);

    @Autowired
    AccountTypeService accountTypeService;

    @RequestMapping(value = "addAccountType", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.ACCEPTED)
    public void addArAccountType(@RequestBody AccountTypeDto accountTypeDto) throws Exception {
        try {
            accountTypeService.saveAccountType(accountTypeDto);
        } catch (ArBusinessException e) {
            LOGGER.error(e);
        }
    }
}
