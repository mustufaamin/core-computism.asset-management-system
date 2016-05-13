package com.core.computism.assasa.web.controller.ar;

import com.core.computism.assasa.ar.dto.AdjustmentDto;
import com.core.computism.assasa.ar.dto.BillCodeDto;
import com.core.computism.assasa.ar.service.AdjustmentService;
import com.core.computism.assasa.exception.ArBusinessException;
import com.core.computism.assasa.util.ServerResponse;
import com.core.computism.assasa.web.controller.BaseController;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by VD on 4/14/2016.
 */
@Controller(value = "adjustmentController")
@RequestMapping(value = "/adjustments/", produces = {MediaType.APPLICATION_JSON_VALUE + "; charset=utf-8"})
public class AdjustmentController extends BaseController {
    private static final Logger LOGGER = Logger.getLogger(PaymentController.class);

    @Autowired
    AdjustmentService adjustmentService;

    @RequestMapping(value = "addAdjustment", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.ACCEPTED)
    public void addAdjustmnet(@RequestBody AdjustmentDto adjustmentDto) throws ArBusinessException {
        try {
            adjustmentService.saveAdjustment(adjustmentDto);
        } catch (ArBusinessException e) {
            LOGGER.error(e);
        }
    }

    @RequestMapping(value = "saveNPostAdjustment", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.ACCEPTED)
    public void saveNPostAdjustment(@RequestBody AdjustmentDto adjustmentDto) throws ArBusinessException {
        try {
            adjustmentService.saveNPostAdjustment(adjustmentDto);
        } catch (ArBusinessException e) {
            LOGGER.error(e);
        }
    }
    @RequestMapping(value = "list/{arAccountId}", method = RequestMethod.GET)
    public ServerResponse<List<AdjustmentDto>> list(@PathVariable Integer arAccountId) throws ArBusinessException {
        LOGGER.info("List Adjustment..");
        ServerResponse<List<AdjustmentDto>> response = toResponse(adjustmentService.getAdjustmentsByArAccountId(arAccountId));
        return response;
    }
}
