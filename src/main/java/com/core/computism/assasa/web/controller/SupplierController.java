package com.core.computism.assasa.web.controller;

import com.core.computism.assasa.domain.SupplierDto;
import com.core.computism.assasa.exception.PosBusinessException;
import com.core.computism.assasa.persistence.entity.inventory.Supplier;
import com.core.computism.assasa.service.SupplierService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by VD on 2/28/2016.
 */
@RestController
@RequestMapping(value = "supplier/")
public class SupplierController extends BaseController {

    private static final Logger LOGGER = Logger.getLogger(SupplierController.class);

    @Autowired
    private SupplierService supplierService;

    @RequestMapping(value = "add", method = RequestMethod.POST)
    public Long add(@RequestBody SupplierDto supplierDto) throws PosBusinessException {
        LOGGER.info("Adding item ...");
        return supplierService.addSupplier(supplierDto);
    }
}
