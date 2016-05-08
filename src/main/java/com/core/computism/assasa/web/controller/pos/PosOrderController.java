package com.core.computism.assasa.web.controller.pos;

import com.core.computism.assasa.ar.dto.ArAccountDto;
import com.core.computism.assasa.ar.dto.BillCodeDto;
import com.core.computism.assasa.exception.ArBusinessException;
import com.core.computism.assasa.exception.AssasaBusinessException;
import com.core.computism.assasa.exception.PosBusinessException;
import com.core.computism.assasa.pos.domain.PosOrderDto;
import com.core.computism.assasa.pos.service.PosOrderService;
import com.core.computism.assasa.util.ServerResponse;
import com.core.computism.assasa.web.controller.BaseController;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by VD on 4/10/2016.
 */
@RestController
@RequestMapping(value = "/order/", produces = {MediaType.APPLICATION_JSON_VALUE + "; charset=utf-8"})
public class PosOrderController extends BaseController{

    private static final Logger LOGGER = Logger.getLogger(PosOrderController.class);
    @Autowired private PosOrderService posOrderService;

    @RequestMapping(value = "save", method = RequestMethod.POST)
    public ServerResponse<PosOrderDto> saveOrder(@RequestBody PosOrderDto posOrderDto) throws PosBusinessException, AssasaBusinessException {
        LOGGER.info("Saving Order....");
        ServerResponse<PosOrderDto> response = toResponse(posOrderService.save(posOrderDto));
        return response;

    }
}
