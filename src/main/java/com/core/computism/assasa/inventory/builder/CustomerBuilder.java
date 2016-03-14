package com.core.computism.assasa.inventory.builder;

import com.core.computism.assasa.exception.BuilderException;
import com.core.computism.assasa.inventory.domain.CustomerDto;
import com.core.computism.assasa.persistence.entity.inventory.Address;
import com.core.computism.assasa.persistence.entity.inventory.Customer;
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

        return customer;
    }
    public CustomerDto buildCustomerDto(Customer customer) throws BuilderException {

        if(customer == null){
            throw new BuilderException("Customer Entity not found");
        }

        CustomerDto customerDto = new CustomerDto();

        customerDto.setFirstName(customer.getFirstName());
        customerDto.setLastName(customer.getLastName());
        customerDto.setLocationAddress(customer.getAddress().getLocationAddress());
        customerDto.setCityId(customer.getAddress().getCity().getId());
        customerDto.setEmail(customer.getEmail());
        customerDto.setMobileNumber(customer.getMobileNumber());
        customerDto.setPhoneNumber(customer.getPhoneNumber());

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