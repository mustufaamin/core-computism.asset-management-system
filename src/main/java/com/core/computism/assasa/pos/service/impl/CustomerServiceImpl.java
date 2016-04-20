package com.core.computism.assasa.pos.service.impl;

import com.core.computism.assasa.persistence.repository.pos.CountryRepository;
import com.core.computism.assasa.pos.domain.CustomerDto;
import com.core.computism.assasa.exception.BuilderException;
import com.core.computism.assasa.exception.PosBusinessException;
import com.core.computism.assasa.persistence.entity.cmn.Address;
import com.core.computism.assasa.persistence.entity.cmn.Customer;
import com.core.computism.assasa.persistence.repository.pos.CityRepository;
import com.core.computism.assasa.persistence.repository.pos.CustomerRepository;
import com.core.computism.assasa.pos.service.CustomerService;
import com.core.computism.assasa.pos.builder.CustomerBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.PersistenceException;
import java.util.List;

/**
 * Created by VD on 2/28/2016.
 */
@Service(value = "customerService")
public class CustomerServiceImpl implements CustomerService {

    @Autowired private CustomerRepository customerRepository;
    @Autowired private CityRepository cityRepository;
    @Autowired private CustomerBuilder customerBuilder;
    @Autowired private CountryRepository countryRepository;

    @Override
    @Transactional(propagation = Propagation.REQUIRED, readOnly = false, rollbackFor = PosBusinessException.class)
    public CustomerDto add(CustomerDto customerDto) throws PosBusinessException {
        try{
              Customer customer = customerBuilder.buildCustomerEntity(customerDto);

            Address address = new Address();
            address.setLocationAddress(customerDto.getLocationAddress());
            address.setCity(cityRepository.findOne(customerDto.getCityId()));

            customer.setAddress(address);

            customer = customerRepository.save(customer);
            return customerBuilder.buildCustomerDto(customer);
        }
        catch (BuilderException | PersistenceException e){
            throw new PosBusinessException(e);
        }
    }
    @Transactional(propagation = Propagation.REQUIRED, readOnly = true)
    public CustomerDto getCustomerById(Long customerId) throws PosBusinessException {
        try{
            return customerBuilder.buildCustomerDto(customerRepository.findOne(customerId));
        }catch (BuilderException| PersistenceException e){
            throw new PosBusinessException("Error occurred getCustomerById",e);
        }
    }
    @Transactional(propagation = Propagation.REQUIRED, readOnly = true)
    public List<CustomerDto> getCustomers() throws PosBusinessException {
        try{
            List<Customer> customers = customerRepository.findAll();
            return customerBuilder.buildCustomerDtoList(customers);
        }catch (BuilderException | PersistenceException e){
            throw new PosBusinessException("Error executing get customers",e);
        }
    }

    @Transactional(propagation = Propagation.REQUIRED, readOnly = true)
    public Customer getCustomer(Long customerId) throws PosBusinessException {
        try{
            return customerRepository.findOne(customerId);
        }catch (PersistenceException e){
            throw new PosBusinessException("Error occurred getCustomer",e);
        }
    }



}
