package com.core.computism.assasa.service.impl;

import com.core.computism.assasa.domain.CustomerDto;
import com.core.computism.assasa.exception.BuilderException;
import com.core.computism.assasa.exception.PosBusinessException;
import com.core.computism.assasa.persistence.entity.inventory.Customer;
import com.core.computism.assasa.persistence.repository.inventory.CustomerRepository;
import com.core.computism.assasa.service.CustomerService;
import com.core.computism.assasa.util.builder.CustomerBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.PersistenceException;

/**
 * Created by VD on 2/28/2016.
 */
@Service(value = "customerService")
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private CustomerRepository customerRepository;
    @Autowired
    private CustomerBuilder customerBuilder;

    @Override
    public Long add(CustomerDto customerDto) throws PosBusinessException {
        try{
            Customer customer = customerBuilder.buildCustomerEntity(customerDto);

            customer = customerRepository.save(customer);
            return customer.getId();
        }
        catch (BuilderException | PersistenceException e){
            throw new PosBusinessException(e);
        }
    }
}
