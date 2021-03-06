package com.core.computism.assasa.ar.service.impl;

import com.core.computism.assasa.ar.builder.ArAccountBuilder;
import com.core.computism.assasa.ar.dto.ArAccountDto;
import com.core.computism.assasa.ar.service.ArAccountService;
import com.core.computism.assasa.exception.ArBusinessException;
import com.core.computism.assasa.persistence.entity.ar.account.ArAccount;
import com.core.computism.assasa.persistence.entity.ar.account.ArAccountType;
import com.core.computism.assasa.persistence.entity.pos.Customer;
import com.core.computism.assasa.persistence.repository.ar.ArAccountRepository;

import com.core.computism.assasa.persistence.repository.ar.ArAccountTypeRepository;
import com.core.computism.assasa.persistence.repository.pos.CustomerRepository;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

/**
 * Created by VD on 2/19/2016.
 */
@Service(value = "arAccountService")
public class ArAccountServiceImpl extends BaseService implements ArAccountService {

    private static final Logger LOGGER = Logger.getLogger(ArAccountServiceImpl.class);

    @Autowired
    ArAccountRepository arAccountRepository;

    @Autowired
    CustomerRepository customerRepository;

    @Autowired
    ArAccountTypeRepository arAccountTypeRepository;

    @Override
    @Transactional(propagation = Propagation.REQUIRED, readOnly = false, rollbackFor = ArBusinessException.class)
    public void saveArAccount(ArAccountDto arAccountDto) throws ArBusinessException {

        if (arAccountDto.getCustomerId() == null) {
            throw new ArBusinessException("Provide Customer Id.");
        }

        if (arAccountDto.getAccountTypeId() == null) {
            throw new ArBusinessException("Provide Ar Account Type Id.");
        }

        Customer customer = customerRepository.findOne(arAccountDto.getCustomerId());
        if (customer == null) {
            throw new ArBusinessException("Unable to find Customer.");
        }

        ArAccountType arAccountType = arAccountTypeRepository.findOne(arAccountDto.getAccountTypeId());
        if (arAccountType == null) {
            throw new ArBusinessException("Unable to find Ar Account Type.");
        }

        ArAccount arAccount = new ArAccountBuilder()
                .setCustomer(customer).setAccountType(arAccountType)
                .setCurrentBalance(arAccountDto.getCurrentBalance()).setAccountStatus(arAccountDto.getAccountStatus())
                .setCompanyId(arAccountDto.getCompanyId()).setCreatedBy(arAccountDto.getCreatedBy())
                .setActivationDate(new Date()).build();

        arAccountRepository.save(arAccount);
    }
}
