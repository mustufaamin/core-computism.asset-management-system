package com.core.computism.assasa.customer.builder;

import com.core.computism.assasa.customer.domain.CustomerTypeDto;
import com.core.computism.assasa.exception.BuilderException;
import com.core.computism.assasa.kernel.error.type.CustomerErrorType;
import com.core.computism.assasa.persistence.entity.customer.CustomerType;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by VD on 2/28/2016.
 */
@Component(value = "customerBuilder")
public class CustomerTypeBuilder {

    public CustomerType buildCustomerTypeEntity(CustomerTypeDto customerTypeDto) throws BuilderException {

        if (customerTypeDto == null) {
            throw new BuilderException(CustomerErrorType.CUSTOMER_TYPE_NOT_EXIST);
        }

        CustomerType customerType = new CustomerType();

        customerType.setName(customerTypeDto.getCustomerTypeName());
        customerType.setDescription(customerTypeDto.getDescription());
        customerType.setStatus(customerTypeDto.getStatus());

        return customerType;
    }

    public void buildCustomerTypeEntity(CustomerTypeDto customerTypeDto, CustomerType customerType) throws BuilderException {

        if (customerTypeDto == null) {
            throw new BuilderException(CustomerErrorType.CUSTOMER_TYPE_DTO_NOT_EXIST);
        }
        customerType.setName(customerTypeDto.getCustomerTypeName());
        customerType.setDescription(customerTypeDto.getDescription());
        customerType.setStatus(customerTypeDto.getStatus());
    }

    public CustomerTypeDto buildCustomerTypeDto(CustomerType customerType) throws BuilderException {

        if (customerType == null) {
            throw new BuilderException(CustomerErrorType.CUSTOMER_TYPE_NOT_EXIST);
        }

        CustomerTypeDto customerTypeDto = new CustomerTypeDto();

        customerTypeDto.setCustomerTypeId(customerType.getId());
        customerTypeDto.setCustomerTypeName(customerType.getName());
        customerTypeDto.setDescription(customerType.getDescription());
        customerTypeDto.setStatus(customerType.getStatus());

        return customerTypeDto;
    }

    public List<CustomerTypeDto> buildCustomerTypeDtoList(List<CustomerType> customerTypes) throws BuilderException {
        if (customerTypes == null || customerTypes.size() < 1) {
            throw new BuilderException(CustomerErrorType.CUSTOMER_TYPE_BUILD_DTO);
        }

        List<CustomerTypeDto> customerTypeDtos = new ArrayList<>();

        for (CustomerType customerType : customerTypes) {
            customerTypeDtos.add(buildCustomerTypeDto(customerType));
        }
        return customerTypeDtos;
    }
}
