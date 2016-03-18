package com.core.computism.assasa.web.controller.inventory;

import com.core.computism.assasa.inventory.domain.SupplierDto;
import com.core.computism.assasa.exception.PosBusinessException;
import com.core.computism.assasa.inventory.service.SupplierService;
import com.core.computism.assasa.web.controller.BaseController;
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
