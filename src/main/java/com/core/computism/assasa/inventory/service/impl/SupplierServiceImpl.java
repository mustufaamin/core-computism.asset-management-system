package com.core.computism.assasa.inventory.service.impl;

import com.core.computism.assasa.inventory.domain.SupplierDto;
import com.core.computism.assasa.exception.BuilderException;
import com.core.computism.assasa.exception.PosBusinessException;
import com.core.computism.assasa.persistence.entity.inventory.Supplier;
import com.core.computism.assasa.persistence.repository.inventory.SupplierRepository;
import com.core.computism.assasa.inventory.service.SupplierService;
import com.core.computism.assasa.inventory.builder.SupplierBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.PersistenceException;

/**
 * Created by VD on 2/28/2016.
 */
@Service(value = "supplierService")
public class SupplierServiceImpl implements SupplierService {

    @Autowired
    private SupplierRepository supplierRepository;

    @Autowired
    private SupplierBuilder supplierBuilder;

    public Long addSupplier(SupplierDto supplierDto) throws PosBusinessException {
        try {
            Supplier supplier = supplierBuilder.buildSupplierEntity(supplierDto);

            supplier = supplierRepository.save(supplier);
            return supplier.getId();
        }
        catch (BuilderException | PersistenceException e){
            e.printStackTrace();
            throw new PosBusinessException(e);
        }
    }
}
