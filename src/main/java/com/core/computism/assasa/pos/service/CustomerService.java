package com.core.computism.assasa.pos.service;

import com.core.computism.assasa.exception.AssasaBusinessException;
import com.core.computism.assasa.persistence.entity.cmn.Customer;
import com.core.computism.assasa.pos.domain.CustomerDto;
import com.core.computism.assasa.exception.PosBusinessException;

import java.util.List;

/**
 * Created by Mustafa Amin Shah  on 2/28/2016.
 */
public interface CustomerService {
    CustomerDto add(CustomerDto customerDto) throws PosBusinessException;
    CustomerDto update(CustomerDto customerDto) throws AssasaBusinessException;
    CustomerDto getCustomerById(Long customerId) throws PosBusinessException;
    List<CustomerDto> getCustomers() throws PosBusinessException;
    List<CustomerDto> search(String searchKey) throws AssasaBusinessException;
    Customer getCustomer(Long customerId) throws PosBusinessException;
}
