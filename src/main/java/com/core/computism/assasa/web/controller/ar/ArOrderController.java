package com.core.computism.assasa.web.controller.ar;

import com.core.computism.assasa.ar.dto.ArQuotationDto;
import com.core.computism.assasa.ar.service.ArOrderService;
import com.core.computism.assasa.exception.ArBusinessException;
import com.core.computism.assasa.exception.AssasaBusinessException;
import com.core.computism.assasa.exception.PosBusinessException;
import com.core.computism.assasa.web.controller.BaseController;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by VD on 5/29/2016.
 */
@RestController
@RequestMapping(value = "/ar/order/")
public class ArOrderController extends BaseController {

    private static final Logger LOGGER = Logger.getLogger(ArOrderController.class);

    @Autowired private ArOrderService arOrderService;

    @RequestMapping(value = "generate/{quotationId}", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.OK)
    public void addAccount(@PathVariable Long quotationId) throws  ArBusinessException {
        LOGGER.info("Saving Quotation....");
        arOrderService.generateOrder(quotationId);
    }
}
