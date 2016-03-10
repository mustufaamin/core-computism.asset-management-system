package com.core.computism.assasa.web.controller;

import com.core.computism.assasa.inventory.domain.CustomerDto;
import com.core.computism.assasa.exception.PosBusinessException;
import com.core.computism.assasa.inventory.service.CustomerService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by VD on 2/28/2016.
 */
@RestController
@RequestMapping(value = "customer/")
public class CustomerController extends BaseController {

    private static final Logger LOGGER = Logger.getLogger(SupplierController.class);

    @Autowired
    CustomerService customerService;

    @RequestMapping(value = "add", method = RequestMethod.POST)
    public Long add(@RequestBody CustomerDto customerDto) throws PosBusinessException {
        LOGGER.info("Adding item ...");
        return customerService.add(customerDto);
    }
}
