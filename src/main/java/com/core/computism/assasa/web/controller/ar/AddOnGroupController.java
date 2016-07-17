package com.core.computism.assasa.web.controller.ar;

import com.core.computism.assasa.ar.dto.AddOnChargeDto;
import com.core.computism.assasa.ar.dto.AddOnGroupDto;
import com.core.computism.assasa.ar.service.AddOnChargeService;
import com.core.computism.assasa.ar.service.AddOnGroupService;
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
@RequestMapping(value = "addOnGroup/")
public class AddOnGroupController extends BaseController {

    private static final Logger LOGGER = Logger.getLogger(AddOnGroupController.class);

    @Autowired
    private AddOnGroupService addOnGroupService;

    @RequestMapping(value = "add", method = RequestMethod.POST)
    public ServerResponse<AddOnGroupDto> add(@RequestBody AddOnGroupDto addOnGroupDto) throws ArBusinessException {
        LOGGER.info("Adding AddOnGroup..");
        ServerResponse<AddOnGroupDto> response = toResponse(addOnGroupService.add(addOnGroupDto));
        return response;
    }

    @RequestMapping(value = "update", method = RequestMethod.POST)
    public ServerResponse<AddOnGroupDto> update(@RequestBody AddOnGroupDto addOnGroupDto) throws ArBusinessException {
        LOGGER.info("update addOnGroupDto..");
        ServerResponse<AddOnGroupDto> response = toResponse(addOnGroupService.update(addOnGroupDto));
        return response;
    }

    @RequestMapping(value = "list/status/{statusId}", method = RequestMethod.GET)
    public ServerResponse<List<AddOnGroupDto>> list(@PathVariable Integer statusId) throws ArBusinessException {
        LOGGER.info("List addOnGroupDto..");
        ServerResponse<List<AddOnGroupDto>> response = toResponse(addOnGroupService.getAddOnGroupByStatus(statusId));
        return response;
    }
}
