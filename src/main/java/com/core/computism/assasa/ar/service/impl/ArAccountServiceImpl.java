package com.core.computism.assasa.ar.service.impl;

import com.core.computism.assasa.ar.builder.ArAccountBuilder;
import com.core.computism.assasa.ar.dto.ArAccountDto;
import com.core.computism.assasa.ar.service.ArAccountService;
import com.core.computism.assasa.exception.ArBusinessException;
import com.core.computism.assasa.persistence.entity.ar.account.ArAccount;
import com.core.computism.assasa.persistence.repository.ar.ArAccountRepository;
import com.core.computism.assasa.service.impl.BaseService;
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

    @Override
    @Transactional(propagation = Propagation.REQUIRED, readOnly = false, rollbackFor = ArBusinessException.class)
    public void saveArAccount(ArAccountDto arAccountDto) throws ArBusinessException {

        ArAccount arAccount = new ArAccountBuilder()
                .setCustomerId(arAccountDto.getCustomerId()).setAccountTypeId(arAccountDto.getAccountTypeId())
                .setCurrentBalance(arAccountDto.getCurrentBalance()).setAccountStatus(arAccountDto.getAccountStatus())
                .setCompanyId(arAccountDto.getCompanyId()).setCreatedBy(arAccountDto.getCreatedBy())
                .setActivationDate(new Date()).build();

        arAccountRepository.save(arAccount);
    }
}
