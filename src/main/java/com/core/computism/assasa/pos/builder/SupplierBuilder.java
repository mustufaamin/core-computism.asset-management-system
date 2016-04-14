package com.core.computism.assasa.pos.builder;

import com.core.computism.assasa.exception.BuilderException;
import com.core.computism.assasa.pos.domain.SupplierDto;
import com.core.computism.assasa.persistence.entity.cmn.Address;
import com.core.computism.assasa.persistence.entity.pos.Supplier;
import org.springframework.stereotype.Component;

/**
 * Created by VD on 2/28/2016.
 */

@Component(value = "supplierBuilder")
public class SupplierBuilder {
    public Supplier buildSupplierEntity(SupplierDto supplierDto) throws BuilderException {

        if(supplierDto == null){
            throw new BuilderException("Supplier DTO is Null");
        }

        Supplier supplier = new Supplier();
        Address address = new Address();

        supplier.setName(supplierDto.getName());
        supplier.setMobileNumber(supplierDto.getMobileNumber());
        supplier.setPhoneNumber(supplierDto.getPhoneNumber());
        supplier.setOfficeNumber(supplierDto.getOfficeNumber());

        address.setLocationAddress(supplierDto.getLocationAddress());
//        address.setCity(supplierDto.getCity());
//        address.setCountry(supplierDto.getCountry());

        supplier.setAddress(address);

        return supplier;
    }
}
