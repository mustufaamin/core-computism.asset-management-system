package com.core.computism.assasa.ar.service.impl;

import com.core.computism.assasa.ar.builder.AddOnChargeBuilder;
import com.core.computism.assasa.ar.dto.AddOnChargeDto;
import com.core.computism.assasa.ar.service.AddOnChargeService;
import com.core.computism.assasa.common.domain.BatchDto;
import com.core.computism.assasa.exception.ArBusinessException;
import com.core.computism.assasa.exception.BuilderException;
import com.core.computism.assasa.persistence.entity.ar.billing.AddOnCharge;
import com.core.computism.assasa.persistence.entity.common.Batch;
import com.core.computism.assasa.persistence.repository.ar.AddOnChargeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.PersistenceException;
import java.util.List;

/**
 * Created by Faizan Iftikhar on 7/12/2016.
 */
@Service(value = "addOnChargeService")
public class AddOnChargeServiceImpl implements AddOnChargeService {

    @Autowired
    AddOnChargeRepository addOnChargeRepository;
    @Autowired
    AddOnChargeBuilder addOnChargeBuilder;

    @Override
    @Transactional(propagation = Propagation.REQUIRED, readOnly = false, rollbackFor = ArBusinessException.class)
    public AddOnChargeDto add(AddOnChargeDto addOnChargeDto) throws ArBusinessException {
        try {
            AddOnCharge addOnCharge = new AddOnCharge();
            addOnCharge = addOnChargeBuilder.buildAddOnChargeEntity(addOnChargeDto, addOnCharge);

            addOnCharge = addOnChargeRepository.save(addOnCharge);
            return addOnChargeBuilder.buildAddOnChargeDto(addOnCharge);
        } catch (BuilderException e) {
            throw new ArBusinessException("Error Occurred While saving Add-On Charge", e);
        }
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, readOnly = false, rollbackFor = ArBusinessException.class)
    public AddOnChargeDto update(AddOnChargeDto addOnChargeDto) throws ArBusinessException {
        try {
            AddOnCharge addOnCharge = addOnChargeRepository.getOne(addOnChargeDto.getId());
            addOnCharge = addOnChargeBuilder.buildAddOnChargeEntity(addOnChargeDto, addOnCharge);

            addOnCharge = addOnChargeRepository.save(addOnCharge);
            return addOnChargeBuilder.buildAddOnChargeDto(addOnCharge);

        } catch (PersistenceException | BuilderException e) {
            throw new ArBusinessException("Error Occurred In Add-On Charge service Update", e);
        }
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, readOnly = true)
    public List<AddOnChargeDto> getAddOnChargeByStatus(Integer addOnChargeStatus) throws ArBusinessException {
        try {
            List<AddOnCharge> addOnCharges = addOnChargeRepository.findAddOnChargesByStatus(addOnChargeStatus);
            return addOnChargeBuilder.buildAddOnChargeDtoList(addOnCharges);
        } catch (BuilderException e) {
            throw new ArBusinessException("Error Occurred In BillCode service Update", e);
        }
    }
}
