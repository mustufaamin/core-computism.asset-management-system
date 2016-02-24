package com.core.computism.assasa.gl.service.impl;

import com.core.computism.assasa.exception.ArBusinessException;
import com.core.computism.assasa.gl.builder.AccountTypeBuilder;
import com.core.computism.assasa.gl.dto.AccountTypeDto;
import com.core.computism.assasa.gl.entity.AccountType;
import com.core.computism.assasa.gl.repository.AccountTypeRepository;
import com.core.computism.assasa.gl.service.AccountTypeService;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by VD on 2/21/2016.
 */
public class AccountTypeServiceImpl implements AccountTypeService {

    @Autowired
    AccountTypeRepository accountTypeRepository;
    @Override
    public void saveAccountType(AccountTypeDto accountTypeDto) throws ArBusinessException {

        AccountType accountType = new AccountTypeBuilder()
                .setDescription(accountTypeDto.getDescription())
                .setName(accountTypeDto.getName())
                .setNormalBalanceFlag(accountTypeDto.getNormalBalanceFlag())
                .build();

        accountTypeRepository.save(accountType);
    }
}
