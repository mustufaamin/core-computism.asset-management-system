package com.core.computism.assasa.ar.service.impl;

import com.core.computism.assasa.ar.builder.ArAccountBuilder;
import com.core.computism.assasa.ar.dto.ArAccountDto;
import com.core.computism.assasa.ar.dto.ArAccountSearchDto;
import com.core.computism.assasa.ar.dto.ArAccountSearchResponseDto;
import com.core.computism.assasa.ar.service.ArAccountService;
import com.core.computism.assasa.exception.ArBusinessException;
import com.core.computism.assasa.persistence.entity.ar.account.ArAccount;
import com.core.computism.assasa.persistence.entity.ar.account.ArAccountType;
import com.core.computism.assasa.persistence.entity.customer.Customer;
import com.core.computism.assasa.persistence.repository.ar.ArAccountRepository;

import com.core.computism.assasa.persistence.repository.ar.ArAccountTypeRepository;
import com.core.computism.assasa.persistence.repository.customer.CustomerRepository;
import org.apache.commons.collections.CollectionUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

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

    @Override
    public List<ArAccountSearchResponseDto> getArAccounts() throws ArBusinessException {

        List<ArAccountSearchResponseDto> arAccountSearchResponseDtos = new ArrayList<>();
        List<ArAccount> arAccounts = arAccountRepository.findAll();

        if (CollectionUtils.isEmpty(arAccounts)) {
            throw new ArBusinessException("Ar Accounts does not exist.");
        }

        for (ArAccount arAccount : arAccounts) {
            ArAccountSearchResponseDto arAccountSearchResponseDto = new ArAccountSearchResponseDto(arAccount);
            arAccountSearchResponseDtos.add(arAccountSearchResponseDto);
        }
        return arAccountSearchResponseDtos;
    }

    @Override
    public List<ArAccountSearchDto> getArAccountBySearchKey(String searchKey) throws ArBusinessException {
        List<ArAccountSearchDto> arAccountSearchDtos = new ArrayList<>();
        List<ArAccount> arAccounts = arAccountRepository.getArAccountBySearchKey(searchKey);
        for (ArAccount arAccount : arAccounts) {
            ArAccountSearchDto arAccountSearchDto = new ArAccountSearchDto(arAccount);
            arAccountSearchDtos.add(arAccountSearchDto);
        }
        return arAccountSearchDtos;
    }

    @Override
    public ArAccount getArAccountById(Long arAccountId) throws ArBusinessException {
        ArAccount arAccount = arAccountRepository.getOne(arAccountId);
        return arAccount;
    }
}
