package com.core.computism.assasa.pos.builder;

import com.core.computism.assasa.exception.BuilderException;
import com.core.computism.assasa.pos.domain.CustomerDto;
import com.core.computism.assasa.persistence.entity.cmn.City;
import com.core.computism.assasa.persistence.entity.cmn.Customer;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by VD on 2/28/2016.
 */
@Component(value = "customerBuilder")
public class CustomerBuilder {

    public Customer buildCustomerEntity(CustomerDto customerDto) throws BuilderException {

        if(customerDto == null){
            throw new BuilderException("customer Dto not present");
        }

        Customer customer = new Customer();

        customer.setFirstName(customerDto.getFirstName());
        customer.setLastName(customerDto.getLastName());
        customer.setEmail(customerDto.getEmail());
        customer.setPhoneNumber(customerDto.getPhoneNumber());
        customer.setMobileNumber(customerDto.getMobileNumber());
        customer.setCustomerStatus(customerDto.getCustomerStatus());
        customer.setCustomerTypeId(customerDto.getCustomerTypeId());

        return customer;
    }

    public void buildCustomerEntity(CustomerDto customerDto,Customer customer) throws BuilderException {

        if(customerDto == null){
            throw new BuilderException("customer Dto not present");
        }
        customer.setFirstName(customerDto.getFirstName());
        customer.setLastName(customerDto.getLastName());
        customer.setEmail(customerDto.getEmail());
        customer.setPhoneNumber(customerDto.getPhoneNumber());
        customer.setMobileNumber(customerDto.getMobileNumber());
        customer.setCustomerStatus(customerDto.getCustomerStatus());
        customer.setCustomerTypeId(customerDto.getCustomerTypeId());

    }
    public CustomerDto buildCustomerDto(Customer customer) throws BuilderException {

        if(customer == null){
            throw new BuilderException("Customer Entity not found");
        }

        CustomerDto customerDto = new CustomerDto();

        customerDto.setId(customer.getId());
        customerDto.setFirstName(customer.getFirstName());
        customerDto.setLastName(customer.getLastName());
        customerDto.setLocationAddress(customer.getAddress().getLocationAddress());
        customerDto.setEmail(customer.getEmail());
        customerDto.setMobileNumber(customer.getMobileNumber());
        customerDto.setPhoneNumber(customer.getPhoneNumber());
        customerDto.setCustomerStatus(customer.getCustomerStatus());
        customerDto.setCustomerTypeId(customer.getCustomerTypeId());

        City city = customer.getAddress().getCity();
        customerDto.setCityId(city.getId());
        customerDto.setCityName(city.getName());
        customerDto.setCountryId(city.getCountry().getId());
        customerDto.setCountryName(city.getCountry().getName());

        return customerDto;
    }

    public List<CustomerDto> buildCustomerDtoList(List<Customer> customers) throws BuilderException {
        if(customers == null || customers.size() < 1){
            throw new BuilderException("Unable to build Item DTO List for [null] Item or empty.");
        }

        List<CustomerDto> customerDtos = new ArrayList<>();

        for(Customer customer: customers){
            customerDtos.add( buildCustomerDto(customer));
        }
        return customerDtos;
    }
}
