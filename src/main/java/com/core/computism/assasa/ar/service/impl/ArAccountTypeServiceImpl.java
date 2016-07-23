package com.core.computism.assasa.ar.service.impl;

import com.core.computism.assasa.ar.builder.ArAccountTypeBuilder;
import com.core.computism.assasa.ar.dto.ArAccountTypeDto;
import com.core.computism.assasa.ar.factory.ArAccountTypeFactory;
import com.core.computism.assasa.ar.service.ArAccountTypeService;
import com.core.computism.assasa.exception.ArBusinessException;
import com.core.computism.assasa.persistence.entity.ar.account.ArAccountType;
import com.core.computism.assasa.persistence.entity.gl.admin.GlAccount;
import com.core.computism.assasa.persistence.repository.ar.ArAccountTypeRepository;
import com.core.computism.assasa.persistence.repository.gl.GlAccountRepository;
import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.PersistenceException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by VD on 2/21/2016.
 */
@Service(value = "arAccountTypeService")
public class ArAccountTypeServiceImpl extends BaseService implements ArAccountTypeService {

    @Autowired
    ArAccountTypeRepository arAccountTypeRepository;

    @Autowired
    GlAccountRepository glAccountRepository;

    @Autowired
    ArAccountTypeFactory arAccountTypeFactory;

    @Override
    @Transactional(propagation = Propagation.REQUIRED, readOnly = false, rollbackFor = ArBusinessException.class)
    public void saveArAccountType(ArAccountTypeDto arAccountTypeDto) throws ArBusinessException {

        if (arAccountTypeDto.getGlAccountId() == null) {
            throw new ArBusinessException("Provide Gl Account Id.");
        }

        GlAccount glAccount = glAccountRepository.findOne(arAccountTypeDto.getGlAccountId());
        if (glAccount == null) {
            throw new ArBusinessException("Unable to find Gl Account.");
        }

        ArAccountType arAccountType = new ArAccountTypeBuilder()
                .setAccountTypeName(arAccountTypeDto.getAccountTypeName()).setAccountTypeDesc(arAccountTypeDto.getAccountTypeDesc())
                .setGlAccount(glAccount).setStatus(arAccountTypeDto.getStatus())
                .setCompanyId(arAccountTypeDto.getCompanyId()).setAccountTypeCode(arAccountTypeDto.getAccountTypeCode())
                .setPriority(arAccountTypeDto.getPriority()).setLeftOverAmount(arAccountTypeDto.getLeftOverAmount())
                .setRequiredStatus(arAccountTypeDto.getRequiredStatus()).setOver30Message(arAccountTypeDto.getOver30Message())
                .setOver60Message(arAccountTypeDto.getOver60Message()).setOver90Message(arAccountTypeDto.getOver90Message())
                .setOver120Message(arAccountTypeDto.getOver120Message()).setShowAgingMessage(arAccountTypeDto.getShowAgingMessage())
                .build();

        arAccountTypeRepository.save(arAccountType);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, readOnly = false, rollbackFor = ArBusinessException.class)
    public ArAccountTypeDto update(ArAccountTypeDto arAccountTypeDto) throws ArBusinessException {
        try {
            ArAccountType arAccountType = arAccountTypeRepository.getOne(arAccountTypeDto.getArAccountTypeId());
            if (arAccountTypeDto.getGlAccountId() != null && !arAccountTypeDto.getGlAccountId().equals(arAccountType.getGlAccount().getId())) {
                GlAccount glAccount = glAccountRepository.findOne(arAccountTypeDto.getGlAccountId());
                arAccountType.setGlAccount(glAccount);
            }
            arAccountTypeFactory.getArAccountType(arAccountTypeDto, arAccountType);
            arAccountTypeRepository.save(arAccountType);

            return arAccountTypeFactory.buildArAccountTypeDto(arAccountType);

        } catch (PersistenceException e) {
            throw new ArBusinessException("Error Occurred In ArAccountTypeDto service Update", e);
        }
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, readOnly = true)
    public ArAccountTypeDto getArAccountType(Long id) throws ArBusinessException {
        return arAccountTypeFactory.buildArAccountTypeDto(arAccountTypeRepository.findOne(id));
    }

    @Override
    public List<ArAccountTypeDto> getArAccountTypes() throws ArBusinessException {

        List<ArAccountTypeDto> arAccountTypeDtos = new ArrayList<>();
        List<ArAccountType> arAccountTypes = arAccountTypeRepository.findAll();

        if (CollectionUtils.isEmpty(arAccountTypes)) {
            throw new ArBusinessException("Ar Account Types does not exist.");
        }

        for (ArAccountType arAccountType : arAccountTypes) {
            ArAccountTypeDto arAccountTypeDto = new ArAccountTypeDto(arAccountType);
            arAccountTypeDtos.add(arAccountTypeDto);
        }
        return arAccountTypeDtos;
    }
}
