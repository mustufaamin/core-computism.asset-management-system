package com.core.computism.assasa.web.controller.ar;

import com.core.computism.assasa.ar.dto.AddOnChargeDto;
import com.core.computism.assasa.ar.dto.BillCodeDto;
import com.core.computism.assasa.ar.service.AddOnChargeService;
import com.core.computism.assasa.ar.service.BillCodeService;
import com.core.computism.assasa.exception.ArBusinessException;
import com.core.computism.assasa.util.ServerResponse;
import com.core.computism.assasa.web.controller.BaseController;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by Faizan Iftikhar on 7/11/2016.
 */
@RestController
@RequestMapping(value = "addOnCharge/")
public class AddOnChargeController extends BaseController {

    private static final Logger LOGGER = Logger.getLogger(BillCodeController.class);

    @Autowired
    private AddOnChargeService addOnChargeService;

    @RequestMapping(value = "add", method = RequestMethod.POST)
    public ServerResponse<AddOnChargeDto> add(@RequestBody AddOnChargeDto addOnChargeDto) throws ArBusinessException {
        LOGGER.info("Adding AddOnCharge..");
        ServerResponse<AddOnChargeDto> response = toResponse(addOnChargeService.add(addOnChargeDto));
        return response;
    }

    @RequestMapping(value = "update", method = RequestMethod.POST)
    public ServerResponse<AddOnChargeDto> update(@RequestBody AddOnChargeDto addOnChargeDto) throws ArBusinessException {
        LOGGER.info("update AddOnCharge..");
        ServerResponse<AddOnChargeDto> response = toResponse(addOnChargeService.update(addOnChargeDto));
        return response;
    }

    @RequestMapping(value = "list/status/{statusId}", method = RequestMethod.GET)
    public ServerResponse<List<AddOnChargeDto>> list(@PathVariable Integer statusId) throws ArBusinessException {
        LOGGER.info("List AddOnCharge..");
        ServerResponse<List<AddOnChargeDto>> response = toResponse(addOnChargeService.getAddOnChargeByStatus(statusId));
        return response;
    }
}
