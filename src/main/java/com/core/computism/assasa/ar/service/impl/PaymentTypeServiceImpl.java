package com.core.computism.assasa.ar.service.impl;

import com.core.computism.assasa.ar.builder.PaymentTypeBuilder;
import com.core.computism.assasa.ar.dto.PaymentTypeDto;
import com.core.computism.assasa.ar.service.PaymentTypeService;
import com.core.computism.assasa.exception.ArBusinessException;
import com.core.computism.assasa.persistence.entity.ar.PaymentType;
import com.core.computism.assasa.persistence.repository.ar.PaymentTypeRepository;
import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by VD on 3/14/2016.
 */
@Service(value = "arPaymentTypeServiceImpl")
public class PaymentTypeServiceImpl implements PaymentTypeService {

    @Autowired
    PaymentTypeRepository paymentTypeRepository;

    @Override
    @Transactional(propagation = Propagation.REQUIRED, readOnly = false, rollbackFor = ArBusinessException.class)
    public void savePaymentType(PaymentTypeDto paymentTypeDto) throws ArBusinessException {
        PaymentType paymentType = new PaymentTypeBuilder().
                setPaymentTypeName(paymentTypeDto.getPaymentTypeName()).setPaymentTypeDesc(paymentTypeDto.getPaymentTypeDesc()).
                setGlAccountId(paymentTypeDto.getGlAccountId()).setStatus(paymentTypeDto.getStatus()).
                setModuleId(paymentTypeDto.getModuleId()).setCompanyId(paymentTypeDto.getCompanyId()).
                setAddOnGroupId(paymentTypeDto.getAddOnGroupId()).setDisplayPriority(paymentTypeDto.getDisplayPriority()).
                setDescription(paymentTypeDto.getDescription()).build();
        paymentTypeRepository.save(paymentType);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, readOnly = false, rollbackFor = ArBusinessException.class)
    public List<PaymentTypeDto> getPaymentTypes() throws ArBusinessException {
        List<PaymentTypeDto> paymentTypeDtos = new ArrayList<>();
        try {


            List<PaymentType> paymentTypes = paymentTypeRepository.findAll();
            if (CollectionUtils.isEmpty(paymentTypes)) {
                throw new ArBusinessException("Unable to find Payment Types");
            }

            for (PaymentType paymentType : paymentTypes) {
                PaymentTypeDto paymentTypeDto = new PaymentTypeDto(paymentType);
                paymentTypeDtos.add(paymentTypeDto);
            }
        }catch (Exception ex){
            ex.printStackTrace();
        }
        return paymentTypeDtos;
    }
}
