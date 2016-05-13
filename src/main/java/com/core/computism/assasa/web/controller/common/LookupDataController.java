package com.core.computism.assasa.web.controller.common;

import com.core.computism.assasa.ar.type.BillCodeType;
import com.core.computism.assasa.common.domain.CurrencyDto;
import com.core.computism.assasa.common.domain.LookupDataDto;
import com.core.computism.assasa.common.service.CurrencyService;
import com.core.computism.assasa.exception.AssasaBusinessException;
import com.core.computism.assasa.exception.PosBusinessException;
import com.core.computism.assasa.util.ServerResponse;
import com.core.computism.assasa.web.controller.BaseController;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by VD on 5/12/2016.
 */
@RestController
@RequestMapping(value = "/lookupData/")
public class LookupDataController extends BaseController  {
    private static final Logger LOGGER = Logger.getLogger(LookupDataController.class);

    @Autowired
    private CurrencyService currencyService;

    @RequestMapping(value = "billCodeTypes", method = RequestMethod.GET)
    public ServerResponse<List<LookupDataDto>> getBillCodeLookup() throws PosBusinessException, AssasaBusinessException {

        ServerResponse<List<LookupDataDto>> response = toResponse(BillCodeType.getList());
        return response;
    }
    @RequestMapping(value = "glAccounts", method = RequestMethod.GET)
    public ServerResponse<List<LookupDataDto>> getGlAccountLookup() throws PosBusinessException, AssasaBusinessException {
        ServerResponse<List<LookupDataDto>> response = toResponse(BillCodeType.getList());
        return response;
    }
}
