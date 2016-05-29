package com.core.computism.assasa.customer.service.impl;

import com.core.computism.assasa.customer.builder.CustomerTypeBuilder;
import com.core.computism.assasa.customer.domain.CustomerTypeDto;
import com.core.computism.assasa.customer.service.CustomerTypeService;
import com.core.computism.assasa.exception.AssasaBusinessException;
import com.core.computism.assasa.exception.BuilderException;
import com.core.computism.assasa.kernel.error.type.CustomerErrorType;
import com.core.computism.assasa.persistence.entity.customer.CustomerType;
import com.core.computism.assasa.persistence.repository.customer.CustomerTypeRepository;
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
public class CustomerTypeServiceImpl implements CustomerTypeService {

    @Autowired
    private CustomerTypeBuilder customerTypeBuilder;

    @Autowired
    private CustomerTypeRepository customerTypeRepository;

    @Override
    @Transactional(propagation = Propagation.REQUIRED, readOnly = false, rollbackFor = AssasaBusinessException.class)
    public CustomerTypeDto add(CustomerTypeDto customerTypeDto) throws AssasaBusinessException {
        try {
            CustomerType customerType = customerTypeBuilder.buildCustomerTypeEntity(customerTypeDto);
            if (customerType == null) {
                throw new AssasaBusinessException(CustomerErrorType.CUSTOMER_NOT_EXIST);
            }
            customerType = customerTypeRepository.save(customerType);

            return customerTypeBuilder.buildCustomerTypeDto(customerType);
        } catch (BuilderException | PersistenceException e) {
            throw new AssasaBusinessException(e);
        }
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, readOnly = false, rollbackFor = AssasaBusinessException.class)
    public CustomerTypeDto update(CustomerTypeDto customerTypeDto) throws AssasaBusinessException {
        try {

            CustomerType customerType = customerTypeRepository.findOne(customerTypeDto.getCustomerTypeId());
            customerTypeBuilder.buildCustomerTypeEntity(customerTypeDto, customerType);

            customerType = customerTypeRepository.save(customerType);
            return customerTypeBuilder.buildCustomerTypeDto(customerType);
        } catch (BuilderException | PersistenceException e) {
            throw new AssasaBusinessException(e);
        }
    }

    @Transactional(propagation = Propagation.REQUIRED, readOnly = true)
    public CustomerTypeDto getCustomerTypeById(Long customerTypeId) throws AssasaBusinessException {
        try {
            return customerTypeBuilder.buildCustomerTypeDto(customerTypeRepository.findOne(customerTypeId));
        } catch (BuilderException | PersistenceException e) {
            throw new AssasaBusinessException("Error occurred while getting CustomerTypeById", e);
        }
    }

    @Transactional(propagation = Propagation.REQUIRED, readOnly = true)
    public List<CustomerTypeDto> getCustomerTypes() throws AssasaBusinessException {
        try {
            List<CustomerType> customerTypes = customerTypeRepository.findAll();
            return customerTypeBuilder.buildCustomerTypeDtoList(customerTypes);
        } catch (BuilderException | PersistenceException e) {
            throw new AssasaBusinessException("Error executing while fetching customer types", e);
        }
    }

    @Transactional(propagation = Propagation.REQUIRED, readOnly = true)
    public CustomerType getCustomerType(Long customerTypeId) throws AssasaBusinessException {
        try {
            return customerTypeRepository.findOne(customerTypeId);
        } catch (PersistenceException e) {
            throw new AssasaBusinessException("Error occurred fetch Customer Type", e);
        }
    }

    @Transactional(propagation = Propagation.REQUIRED, readOnly = true)
    public List<CustomerTypeDto> search(String searchKey) throws AssasaBusinessException {
        try {
            searchKey = "%" + searchKey + "%";
            List<CustomerType> customerTypes = customerTypeRepository.searchCustomerTypes(searchKey);
            return customerTypeBuilder.buildCustomerTypeDtoList(customerTypes);

        } catch (PersistenceException | BuilderException e) {
            throw new AssasaBusinessException("Error Occurred In customer type fetch.", e);
        }
    }


}
