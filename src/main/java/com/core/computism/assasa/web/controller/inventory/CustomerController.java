package com.core.computism.assasa.web.controller.inventory;

import com.core.computism.assasa.inventory.domain.CustomerDto;
import com.core.computism.assasa.exception.PosBusinessException;
import com.core.computism.assasa.inventory.service.CustomerService;
import com.core.computism.assasa.util.ServerResponse;
import com.core.computism.assasa.web.controller.BaseController;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by VD on 2/28/2016.
 */
@RestController
@RequestMapping(value = "customer/")
public class CustomerController extends BaseController {

    private static final Logger LOGGER = Logger.getLogger(CustomerController.class);

    @Autowired
    CustomerService customerService;

    @RequestMapping(value = "add", method = RequestMethod.POST)
    public Long add(@RequestBody CustomerDto customerDto) throws PosBusinessException {
        LOGGER.info("Adding Customer..");
        return customerService.add(customerDto);
    }

    @RequestMapping(value = "list",method = RequestMethod.GET)
    public ServerResponse<List<CustomerDto>> listCustomers() throws PosBusinessException {
        LOGGER.info("List Customers ...");
        ServerResponse<List<CustomerDto>> response = toResponse(customerService.getCustomers());
        return response;

    }
}
