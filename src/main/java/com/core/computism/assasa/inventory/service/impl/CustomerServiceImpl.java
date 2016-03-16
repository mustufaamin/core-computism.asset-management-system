package com.core.computism.assasa.inventory.service.impl;

import com.core.computism.assasa.inventory.domain.CustomerDto;
import com.core.computism.assasa.exception.BuilderException;
import com.core.computism.assasa.exception.PosBusinessException;
import com.core.computism.assasa.persistence.entity.inventory.Address;
import com.core.computism.assasa.persistence.entity.inventory.Customer;
import com.core.computism.assasa.persistence.repository.inventory.CityRepository;
import com.core.computism.assasa.persistence.repository.inventory.CustomerRepository;
import com.core.computism.assasa.inventory.service.CustomerService;
import com.core.computism.assasa.inventory.builder.CustomerBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.PersistenceException;
import java.util.Date;
import java.util.List;

/**
 * Created by VD on 2/28/2016.
 */
@Service(value = "customerService")
public class CustomerServiceImpl implements CustomerService {

    @Autowired private CustomerRepository customerRepository;
    @Autowired private CityRepository cityRepository;
    @Autowired private CustomerBuilder customerBuilder;

    @Override
    @Transactional(propagation = Propagation.REQUIRED, readOnly = false, rollbackFor = PosBusinessException.class)
    public Long add(CustomerDto customerDto) throws PosBusinessException {
        try{
            Customer customer = customerBuilder.buildCustomerEntity(customerDto);

            Address address = new Address();
            address.setLocationAddress(customerDto.getLocationAddress());
            address.setCity(cityRepository.findOne(customerDto.getCityId()));
//            address.setCreationDate(new Date());
//            address.setLastModifiedDate(new Date());
//            address.setVersion(1L);

            customer.setAddress(address);

            customer = customerRepository.save(customer);
            return customer.getId();
        }
        catch (BuilderException | PersistenceException e){
            e.printStackTrace();
            throw new PosBusinessException(e);
        }
    }
    @Transactional(propagation = Propagation.REQUIRED, readOnly = true)
    public CustomerDto getCustomer(Long customerId) throws PosBusinessException {
        try{
            return customerBuilder.buildCustomerDto(customerRepository.findOne(customerId));
        }catch (BuilderException| PersistenceException e){
            throw new PosBusinessException("Error occurred getCustomer",e);
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



}
