package com.core.computism.assasa.pos.service.impl;

import com.core.computism.assasa.exception.AssasaBusinessException;
import com.core.computism.assasa.kernel.error.type.CustomerErrorType;
import com.core.computism.assasa.persistence.entity.customer.CustomerType;
import com.core.computism.assasa.persistence.repository.common.CountryRepository;
import com.core.computism.assasa.persistence.repository.customer.CustomerTypeRepository;
import com.core.computism.assasa.pos.domain.CustomerDto;
import com.core.computism.assasa.exception.BuilderException;
import com.core.computism.assasa.exception.PosBusinessException;
import com.core.computism.assasa.persistence.entity.common.Address;
import com.core.computism.assasa.persistence.entity.customer.Customer;
import com.core.computism.assasa.persistence.repository.common.CityRepository;
import com.core.computism.assasa.persistence.repository.customer.CustomerRepository;
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

    @Autowired
    private CustomerRepository customerRepository;
    @Autowired
    private CityRepository cityRepository;
    @Autowired
    private CustomerBuilder customerBuilder;
    @Autowired
    private CountryRepository countryRepository;
    @Autowired
    private CustomerTypeRepository customerTypeRepository;

    @Override
    @Transactional(propagation = Propagation.REQUIRED, readOnly = false, rollbackFor = AssasaBusinessException.class)
    public CustomerDto add(CustomerDto customerDto) throws AssasaBusinessException {
        try {
            Customer customer = customerBuilder.buildCustomerEntity(customerDto);

            Address address = new Address();
            address.setLocationAddress(customerDto.getLocationAddress());
            address.setCity(cityRepository.findOne(customerDto.getCityId()));

            CustomerType customerType = customerTypeRepository.findOne(customerDto.getCustomerTypeId());
            if (customerType == null) {
                throw new AssasaBusinessException(CustomerErrorType.CUSTOMER_NOT_EXIST);
            }
            customer.setAddress(address);
            customer.setCustomerType(customerType);
            customer = customerRepository.save(customer);

            return customerBuilder.buildCustomerDto(customer);
        } catch (BuilderException | PersistenceException e) {
            throw new AssasaBusinessException(e);
        }
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, readOnly = false, rollbackFor = AssasaBusinessException.class)
    public CustomerDto update(CustomerDto customerDto) throws AssasaBusinessException {
        try {

            Customer customer = customerRepository.findOne(customerDto.getId());
            customerBuilder.buildCustomerEntity(customerDto, customer);
            Address address = customer.getAddress();
            address.setLocationAddress(customerDto.getLocationAddress());
            address.setCity(cityRepository.findOne(customerDto.getCityId()));
            customer.setAddress(address);

            customer = customerRepository.save(customer);
            return customerBuilder.buildCustomerDto(customer);
        } catch (BuilderException | PersistenceException e) {
            throw new AssasaBusinessException(e);
        }
    }

    @Transactional(propagation = Propagation.REQUIRED, readOnly = true)
    public CustomerDto getCustomerById(Long customerId) throws AssasaBusinessException {
        try {
            return customerBuilder.buildCustomerDto(customerRepository.findOne(customerId));
        } catch (BuilderException | PersistenceException e) {
            throw new AssasaBusinessException("Error occurred getCustomerById", e);
        }
    }

    @Transactional(propagation = Propagation.REQUIRED, readOnly = true)
    public List<CustomerDto> getCustomers() throws AssasaBusinessException {
        try {
            List<Customer> customers = customerRepository.findAll();
            return customerBuilder.buildCustomerDtoList(customers);
        } catch (BuilderException | PersistenceException e) {
            throw new AssasaBusinessException("Error executing get customers", e);
        }
    }

    @Transactional(propagation = Propagation.REQUIRED, readOnly = true)
    public Customer getCustomer(Long customerId) throws AssasaBusinessException {
        try {
            return customerRepository.findOne(customerId);
        } catch (PersistenceException e) {
            throw new AssasaBusinessException("Error occurred getCustomer", e);
        }
    }

    @Transactional(propagation = Propagation.REQUIRED, readOnly = true)
    public List<CustomerDto> search(String searchKey) throws AssasaBusinessException {
        try {
            searchKey = "%" + searchKey + "%";
            List<Customer> customers = customerRepository.searchCustomers(searchKey);
            return customerBuilder.buildCustomerDtoList(customers);

        } catch (PersistenceException | BuilderException e) {
            throw new AssasaBusinessException("Error Occurred In BillCode service Update", e);
        }
    }


}
