package com.core.computism.assasa.ar.factory;

import com.core.computism.assasa.ar.dto.ArAccountTypeDto;
import com.core.computism.assasa.exception.ArBusinessException;
import com.core.computism.assasa.persistence.entity.ar.account.ArAccountType;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import static org.springframework.transaction.annotation.Propagation.REQUIRED;

/**
 * Created by VD on 7/21/2016.
 */
@Component
@Transactional(propagation = Propagation.REQUIRED, readOnly = false, rollbackFor = ArBusinessException.class)
public class ArAccountTypeFactory {

    public void getArAccountType(ArAccountTypeDto arAccountTypeDto, ArAccountType arAccountType) throws ArBusinessException {
        arAccountType.setAccountTypeName(arAccountTypeDto.getAccountTypeName());
        arAccountType.setAccountTypeDesc(arAccountTypeDto.getAccountTypeDesc());
        arAccountType.setStatus(arAccountTypeDto.getStatus());
        arAccountType.setCompanyId(arAccountTypeDto.getCompanyId());
        arAccountType.setAccountTypeCode(arAccountTypeDto.getAccountTypeCode());
        arAccountType.setPriority(arAccountTypeDto.getPriority());
        arAccountType.setLeftOverAmount(arAccountTypeDto.getLeftOverAmount());
        arAccountType.setRequiredStatus(arAccountTypeDto.getRequiredStatus());
        arAccountType.setOver30Message(arAccountTypeDto.getOver30Message());
        arAccountType.setOver60Message(arAccountTypeDto.getOver60Message());
        arAccountType.setOver90Message(arAccountTypeDto.getOver90Message());
        arAccountType.setOver120Message(arAccountTypeDto.getOver120Message());
        arAccountType.setShowAgingMessage(arAccountTypeDto.getShowAgingMessage());
    }

    public ArAccountTypeDto buildArAccountTypeDto(ArAccountType arAccountType) throws ArBusinessException {
        ArAccountTypeDto arAccountTypeDto = new ArAccountTypeDto();

        arAccountTypeDto.setArAccountTypeId(arAccountType.getId());
        arAccountTypeDto.setGlAccountId(arAccountType.getGlAccount().getId());
        arAccountTypeDto.setAccountTypeName(arAccountType.getAccountTypeName());
        arAccountTypeDto.setAccountTypeDesc(arAccountType.getAccountTypeDesc());
        arAccountTypeDto.setStatus(arAccountType.getStatus());
        arAccountTypeDto.setCompanyId(arAccountType.getCompanyId());
        arAccountTypeDto.setAccountTypeCode(arAccountType.getAccountTypeCode());
        arAccountTypeDto.setPriority(arAccountType.getPriority());
        arAccountTypeDto.setLeftOverAmount(arAccountType.getLeftOverAmount());
        arAccountTypeDto.setRequiredStatus(arAccountType.getRequiredStatus());
        arAccountTypeDto.setOver30Message(arAccountType.getOver30Message());
        arAccountTypeDto.setOver60Message(arAccountType.getOver60Message());
        arAccountTypeDto.setOver90Message(arAccountType.getOver90Message());
        arAccountTypeDto.setOver120Message(arAccountType.getOver120Message());
        arAccountTypeDto.setShowAgingMessage(arAccountType.getShowAgingMessage());

        return arAccountTypeDto;
    }
}
