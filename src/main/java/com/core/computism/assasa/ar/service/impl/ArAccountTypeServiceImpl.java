package com.core.computism.assasa.ar.service.impl;

import com.core.computism.assasa.ar.builder.ArAccountTypeBuilder;
import com.core.computism.assasa.ar.dto.ArAccountTypeDto;
import com.core.computism.assasa.ar.service.ArAccountTypeService;
import com.core.computism.assasa.exception.ArBusinessException;
import com.core.computism.assasa.persistence.entity.ar.account.ArAccountType;
import com.core.computism.assasa.persistence.repository.ar.ArAccountTypeRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by VD on 2/21/2016.
 */
@Service(value = "arAccountTypeService")
public class ArAccountTypeServiceImpl extends BaseService implements ArAccountTypeService {

    @Autowired
    ArAccountTypeRepository arAccountTypeRepository;

    @Override
    @Transactional(propagation = Propagation.REQUIRED, readOnly = false, rollbackFor = ArBusinessException.class)
    public void saveArAccountType(ArAccountTypeDto arAccountTypeDto) throws ArBusinessException {

        ArAccountType arAccountType = new ArAccountTypeBuilder()
                .setAccountTypeName(arAccountTypeDto.getAccountTypeName()).setAccountTypeDesc(arAccountTypeDto.getAccountTypeDesc())
                .setGlAccountId(arAccountTypeDto.getGlAccountId()).setStatus(arAccountTypeDto.getStatus())
                .setCompanyId(arAccountTypeDto.getCompanyId()).setAccountTypeCode(arAccountTypeDto.getAccountTypeCode())
                .setPriority(arAccountTypeDto.getPriority()).setLeftOverAmount(arAccountTypeDto.getLeftOverAmount())
                .setRequiredStatus(arAccountTypeDto.getRequiredStatus()).setOver30Message(arAccountTypeDto.getOver30Message())
                .setOver60Message(arAccountTypeDto.getOver60Message()).setOver90Message(arAccountTypeDto.getOver90Message())
                .setOver120Message(arAccountTypeDto.getOver120Message()).setShowAgingMessage(arAccountTypeDto.getShowAgingMessage())
                .build();

        arAccountTypeRepository.save(arAccountType);
    }
}
