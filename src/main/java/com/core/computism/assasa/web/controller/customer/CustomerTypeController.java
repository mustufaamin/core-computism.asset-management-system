package com.core.computism.assasa.web.controller.customer;

import com.core.computism.assasa.customer.domain.CustomerTypeDto;
import com.core.computism.assasa.customer.service.CustomerTypeService;
import com.core.computism.assasa.exception.AssasaBusinessException;
import com.core.computism.assasa.customer.domain.CustomerDto;
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
 * Created by VD on 5/23/2016.
 */
@RestController
@RequestMapping(value = "/customerType/")
public class CustomerTypeController extends BaseController {

    private static final Logger LOGGER = Logger.getLogger(CustomerTypeController.class);

    @Autowired
    CustomerTypeService customerTypeService;

    @RequestMapping(value = "add", method = RequestMethod.POST)
    public ServerResponse<CustomerTypeDto> add(@RequestBody CustomerTypeDto customerTypeDto) throws AssasaBusinessException {
        LOGGER.info("Adding Customer Type..");
        ServerResponse<CustomerTypeDto> response = toResponse(customerTypeService.add(customerTypeDto));
        return response;
    }

    @RequestMapping(value = "update", method = RequestMethod.POST)
    public ServerResponse<CustomerTypeDto> update(@RequestBody CustomerTypeDto customerTypeDto) throws AssasaBusinessException {
        LOGGER.info("Adding Customer Type..");
        ServerResponse<CustomerTypeDto> response = toResponse(customerTypeService.update(customerTypeDto));
        return response;
    }

    @RequestMapping(value = "list",method = RequestMethod.GET)
    public ServerResponse<List<CustomerTypeDto>> listCustomerTypes() throws AssasaBusinessException {
        LOGGER.info("List Customers Types...");
        ServerResponse<List<CustomerTypeDto>> response = toResponse(customerTypeService.getCustomerTypes());
        return response;

    }

    @RequestMapping(value = "search/{searchKey}", method = RequestMethod.GET)
    public ServerResponse<List<CustomerTypeDto>> search(@PathVariable String searchKey) throws AssasaBusinessException {
        LOGGER.info("search Customer Types..");
        ServerResponse<List<CustomerTypeDto>> response = toResponse(customerTypeService.search(searchKey));
        return response;
    }
}
