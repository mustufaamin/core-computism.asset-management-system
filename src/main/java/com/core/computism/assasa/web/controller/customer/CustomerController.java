package com.core.computism.assasa.web.controller.customer;

import com.core.computism.assasa.exception.AssasaBusinessException;
import com.core.computism.assasa.customer.domain.CustomerDto;
import com.core.computism.assasa.customer.service.CustomerService;
import com.core.computism.assasa.util.ServerResponse;
import com.core.computism.assasa.web.controller.BaseController;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
    public ServerResponse<CustomerDto> add(@RequestBody CustomerDto customerDto) throws AssasaBusinessException {
        LOGGER.info("Adding Customer..");
        ServerResponse<CustomerDto> response = toResponse(customerService.add(customerDto));
        return response;
    }

    @RequestMapping(value = "update", method = RequestMethod.POST)
    public ServerResponse<CustomerDto> update(@RequestBody CustomerDto customerDto) throws AssasaBusinessException {
        LOGGER.info("Adding Customer..");
        ServerResponse<CustomerDto> response = toResponse(customerService.update(customerDto));
        return response;
    }

    @RequestMapping(value = "list",method = RequestMethod.GET)
    public ServerResponse<List<CustomerDto>> listCustomers() throws AssasaBusinessException {
        LOGGER.info("List Customers ...");
        ServerResponse<List<CustomerDto>> response = toResponse(customerService.getCustomers());
        return response;

    }

    @RequestMapping(value = "search/{searchKey}", method = RequestMethod.GET)
    public ServerResponse<List<CustomerDto>> search(@PathVariable String searchKey) throws AssasaBusinessException {
        LOGGER.info("search Customer..");
        ServerResponse<List<CustomerDto>> response = toResponse(customerService.search(searchKey));
        return response;
    }

}
