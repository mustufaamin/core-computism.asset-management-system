package com.core.computism.assasa.gl.service.impl;

import com.core.computism.assasa.exception.ArBusinessException;
import com.core.computism.assasa.gl.builder.AccountTypeBuilder;
import com.core.computism.assasa.gl.dto.AccountTypeDto;
import com.core.computism.assasa.gl.service.AccountTypeService;
import com.core.computism.assasa.persistence.entity.gl.admin.AccountType;
import com.core.computism.assasa.persistence.repository.gl.AccountTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by VD on 2/21/2016.
 */
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
}
