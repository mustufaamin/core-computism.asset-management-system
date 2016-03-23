package com.core.computism.assasa.pos.service;

import com.core.computism.assasa.pos.domain.CustomerDto;
import com.core.computism.assasa.exception.PosBusinessException;

import java.util.List;

/**
 * Created by Mustafa Amin Shah  on 2/28/2016.
 */
public interface CustomerService {
    Long add(CustomerDto customerDto) throws PosBusinessException;
    CustomerDto getCustomer(Long customerId) throws PosBusinessException;
    List<CustomerDto> getCustomers() throws PosBusinessException;
}
