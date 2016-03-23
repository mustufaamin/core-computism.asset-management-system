package com.core.computism.assasa.web.controller.ar;

import com.core.computism.assasa.ar.dto.BillCodeDto;
import com.core.computism.assasa.ar.service.BillCodeService;
import com.core.computism.assasa.exception.ArBusinessException;
import com.core.computism.assasa.util.ServerResponse;
import com.core.computism.assasa.web.controller.BaseController;
import com.mysql.fabric.Server;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by M.Mustafa Amin Shah on 3/23/2016.
 */
@RestController
@RequestMapping(value = "billCodes/")
public class BillCodeController extends BaseController{

    private static final Logger LOGGER = Logger.getLogger(BillCodeController.class);

    @Autowired private BillCodeService billCodeService;

    @RequestMapping(value = "add", method = RequestMethod.POST)
    public ServerResponse<BillCodeDto> add(@RequestBody BillCodeDto billCodeDto) throws ArBusinessException {
        LOGGER.info("Adding BillCode..");
        ServerResponse<BillCodeDto> response  = toResponse(billCodeService.add(billCodeDto));
        return response;
    }
    @RequestMapping(value = "update", method = RequestMethod.POST)
    public ServerResponse<BillCodeDto> update(@RequestBody BillCodeDto billCodeDto) throws ArBusinessException {
        LOGGER.info("update BillCode..");
        ServerResponse<BillCodeDto> response  = toResponse(billCodeService.update(billCodeDto));
        return response;
    }
    @RequestMapping(value = "list", method = RequestMethod.GET)
    public ServerResponse<List<BillCodeDto>> list() throws ArBusinessException {
        LOGGER.info("List BillCode..");
        ServerResponse<List<BillCodeDto>> response  = toResponse(billCodeService.list());
        return response;
    }
}
