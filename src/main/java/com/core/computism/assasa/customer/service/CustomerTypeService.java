package com.core.computism.assasa.customer.service;

import com.core.computism.assasa.customer.domain.CustomerDto;
import com.core.computism.assasa.customer.domain.CustomerTypeDto;
import com.core.computism.assasa.exception.AssasaBusinessException;
import com.core.computism.assasa.persistence.entity.customer.Customer;
import com.core.computism.assasa.persistence.entity.customer.CustomerType;

import java.util.List;

/**
 * Created by VD on 5/23/2016.
 */
public interface CustomerTypeService {
    CustomerTypeDto add(CustomerTypeDto customerTypeDto) throws AssasaBusinessException;

    CustomerTypeDto update(CustomerTypeDto customerTypeDto) throws AssasaBusinessException;

    CustomerTypeDto getCustomerTypeById(Long customerTypeId) throws AssasaBusinessException;

    List<CustomerTypeDto> getCustomerTypes() throws AssasaBusinessException;

    List<CustomerTypeDto> search(String searchKey) throws AssasaBusinessException;

    CustomerType getCustomerType(Long customerTypeId) throws AssasaBusinessException;
}
