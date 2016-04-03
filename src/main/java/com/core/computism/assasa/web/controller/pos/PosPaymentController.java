package com.core.computism.assasa.web.controller.pos;

import com.core.computism.assasa.exception.PosBusinessException;
import com.core.computism.assasa.pos.domain.PosPaymentDto;
import com.core.computism.assasa.pos.service.PosPaymentService;
import com.core.computism.assasa.util.ServerResponse;
import com.core.computism.assasa.web.controller.BaseController;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

/**
 * Created by M.Mustafa Amin Shah on 4/2/2016.
 */

@RequestMapping(value = "posPayment/")
public class PosPaymentController extends BaseController {
    private static final Logger LOGGER = Logger.getLogger(PosPaymentController.class);

    @Autowired private PosPaymentService posPaymentService;

    @RequestMapping(value = "add", method = RequestMethod.POST)
    public ServerResponse<PosPaymentDto> add(@RequestBody PosPaymentDto posPaymentDto) throws PosBusinessException {
        LOGGER.info("Adding item ...");
        ServerResponse<PosPaymentDto> response = toResponse(posPaymentService.add(posPaymentDto));
        return response;
    }
    @RequestMapping(value = "update", method = RequestMethod.POST)
    public ServerResponse<PosPaymentDto> update(@RequestBody PosPaymentDto posPaymentDto) throws PosBusinessException {
        LOGGER.info("Updating item ...");
        ServerResponse<PosPaymentDto> response = toResponse(posPaymentService.update(posPaymentDto));
        return response;
    }
    @RequestMapping(value = "list", method = RequestMethod.GET)
    public ServerResponse<List<PosPaymentDto>> list() throws PosBusinessException {
        LOGGER.info("Listing Payments item ...");
        ServerResponse<List<PosPaymentDto>> response = toResponse(posPaymentService.list());
        return response;
    }
}
