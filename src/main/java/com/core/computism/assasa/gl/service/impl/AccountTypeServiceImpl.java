package com.core.computism.assasa.gl.service.impl;

import com.core.computism.assasa.exception.ArBusinessException;
import com.core.computism.assasa.gl.builder.AccountTypeBuilder;
import com.core.computism.assasa.gl.dto.AccountTypeDto;
import com.core.computism.assasa.gl.service.AccountTypeService;
import com.core.computism.assasa.persistence.entity.gl.admin.AccountType;
import com.core.computism.assasa.persistence.repository.gl.AccountTypeRepository;
import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by VD on 2/21/2016.
 */
@Service(value = "accountTypeService")
public class AccountTypeServiceImpl implements AccountTypeService {

    @Autowired
    AccountTypeRepository accountTypeRepository;


    @Override
    @Transactional(propagation = Propagation.REQUIRED, readOnly = false, rollbackFor = ArBusinessException.class)
    public void saveAccountType(AccountTypeDto accountTypeDto) throws ArBusinessException {

        AccountType accountType = new AccountTypeBuilder()
                .setDescription(accountTypeDto.getDescription())
                .setName(accountTypeDto.getName())
                .setNormalBalanceFlag(accountTypeDto.getNormalBalanceFlag())
                .build();

        accountTypeRepository.save(accountType);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, readOnly = false, rollbackFor = ArBusinessException.class)
    public void updateAccountType(AccountTypeDto accountTypeDto) throws ArBusinessException {

        AccountType accountType = accountTypeRepository.findOne(accountTypeDto.getGlAccountId());
        if (accountType == null) {
            throw new ArBusinessException("Unable to find GL Account Type...");
        }

        accountType.setDescription(accountTypeDto.getDescription());
        accountType.setName(accountTypeDto.getName());
        accountType.setNormalBalanceFlag(accountTypeDto.getNormalBalanceFlag());
        accountTypeRepository.save(accountType);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, readOnly = false, rollbackFor = ArBusinessException.class)
    public List<AccountTypeDto> getGLAccountTypes() throws ArBusinessException {
        List<AccountTypeDto> accountTypeDtos = new ArrayList<>();

        List<AccountType> glAccountTypes = accountTypeRepository.findAll();
        if (CollectionUtils.isEmpty(glAccountTypes)) {
            throw new ArBusinessException("Ar Account Types does not exist.");
        }

        for (AccountType accountType : glAccountTypes) {
            AccountTypeDto accountTypeDto = new AccountTypeDto(accountType);
            accountTypeDtos.add(accountTypeDto);
        }
        return accountTypeDtos;
    }
}
