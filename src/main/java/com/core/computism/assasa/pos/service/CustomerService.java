package com.core.computism.assasa.pos.service;

import com.core.computism.assasa.exception.AssasaBusinessException;
import com.core.computism.assasa.persistence.entity.customer.Customer;
import com.core.computism.assasa.pos.domain.CustomerDto;
import com.core.computism.assasa.exception.PosBusinessException;

import java.util.List;

/**
 * Created by Mustafa Amin Shah  on 2/28/2016.
 */
public interface CustomerService {
    CustomerDto add(CustomerDto customerDto) throws AssasaBusinessException;
    CustomerDto update(CustomerDto customerDto) throws AssasaBusinessException;
    CustomerDto getCustomerById(Long customerId) throws AssasaBusinessException;
    List<CustomerDto> getCustomers() throws AssasaBusinessException;
    List<CustomerDto> search(String searchKey) throws AssasaBusinessException;
    Customer getCustomer(Long customerId) throws AssasaBusinessException;
}
