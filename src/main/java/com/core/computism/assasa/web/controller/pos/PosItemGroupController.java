package com.core.computism.assasa.web.controller.pos;

import com.core.computism.assasa.exception.PosBusinessException;
import com.core.computism.assasa.pos.domain.PosItemGroupDto;
import com.core.computism.assasa.pos.service.PosItemGroupService;
import com.core.computism.assasa.util.ServerResponse;
import com.core.computism.assasa.web.controller.BaseController;
import com.core.computism.assasa.web.controller.customer.CustomerController;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by M.Mustufa Amin Shah on 3/27/2016.
 */
@RestController
@RequestMapping(value = "itemGroups/")
public class PosItemGroupController extends BaseController {

    private static final Logger LOGGER = Logger.getLogger(CustomerController.class);

    @Autowired private PosItemGroupService posItemGroupService;

    @RequestMapping(value = "add", method = RequestMethod.POST)
    public ServerResponse<PosItemGroupDto> add(@RequestBody PosItemGroupDto posItemGroupDto) throws PosBusinessException {
        LOGGER.info("Adding Customer..");
        ServerResponse<PosItemGroupDto> response = toResponse(posItemGroupService.add(posItemGroupDto));
        return response;
    }
    @RequestMapping(value = "list",method = RequestMethod.GET)
    public ServerResponse<List<PosItemGroupDto>> listItemGroups() throws PosBusinessException {
        LOGGER.info("List Customers ...");
        ServerResponse<List<PosItemGroupDto>> response = toResponse(posItemGroupService.list());
        return response;
    }

}
