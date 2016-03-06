package com.core.computism.assasa.util.builder;

import com.core.computism.assasa.domain.CustomerDto;
import com.core.computism.assasa.exception.BuilderException;
import com.core.computism.assasa.persistence.entity.inventory.Address;
import com.core.computism.assasa.persistence.entity.inventory.Customer;
import org.springframework.stereotype.Component;

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
        Address address = new Address();

        customer.setFirstName(customerDto.getFirstName());
        customer.setLastName(customerDto.getLastName());
        customer.setEmail(customerDto.getEmail());
        customer.setPhoneNumber(customerDto.getPhoneNumber());
        customer.setMobileNumber(customerDto.getMobileNumber());

        address.setLocationAddress(customerDto.getLocationAddress());
        address.setCity(customerDto.getCity());
        address.setCountry(customerDto.getCountry());

        customer.setAddress(address);

        return customer;
    }
}
