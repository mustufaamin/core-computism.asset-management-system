package com.core.computism.assasa.pos.service.impl;

import com.core.computism.assasa.exception.BuilderException;
import com.core.computism.assasa.exception.PosBusinessException;
import com.core.computism.assasa.persistence.entity.pos.PosPaymentType;
import com.core.computism.assasa.persistence.repository.pos.PosPaymentTypeRepository;
import com.core.computism.assasa.pos.builder.PosPaymentTypeBuilder;
import com.core.computism.assasa.pos.domain.PosPaymentTypeDto;
import com.core.computism.assasa.pos.service.PosPaymentTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Persistable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.PersistenceException;
import java.util.List;

/**
 * Created by M.Mustufa Amin Shah on 4/3/2016.
 */
@Service(value = "posPaymentTypeService")
public class PosPaymentTypeServiceImpl implements PosPaymentTypeService {

    @Autowired private PosPaymentTypeRepository posPaymentTypeRepository;
    @Autowired private PosPaymentTypeBuilder posPaymentTypeBuilder;

    @Override
    @Transactional(propagation = Propagation.REQUIRED, readOnly = false, rollbackFor = PosBusinessException.class)
    public PosPaymentTypeDto add(PosPaymentTypeDto posPaymentTypeDto) throws PosBusinessException {
        try{
            PosPaymentType posPaymentType =  new PosPaymentType();
            posPaymentType = posPaymentTypeBuilder.buildPosPaymentTypeEntity(posPaymentType,posPaymentTypeDto);

            posPaymentTypeRepository.save(posPaymentType);

            return posPaymentTypeBuilder.buildPosPaymentTypeDto(posPaymentType);

        }catch (PersistenceException | BuilderException e){
            throw new PosBusinessException("Error Occurred While Adding the Pos Payment Type",e);
        }
    }
    @Override
    @Transactional(propagation = Propagation.REQUIRED, readOnly = false, rollbackFor = PosBusinessException.class)
    public PosPaymentTypeDto update(PosPaymentTypeDto posPaymentTypeDto) throws PosBusinessException {
        try{
            PosPaymentType posPaymentType =  posPaymentTypeRepository.findOne(posPaymentTypeDto.getId());
            posPaymentType = posPaymentTypeBuilder.buildPosPaymentTypeEntity(posPaymentType,posPaymentTypeDto);

            posPaymentTypeRepository.save(posPaymentType);

            return posPaymentTypeBuilder.buildPosPaymentTypeDto(posPaymentType);

        }catch (PersistenceException | BuilderException e){
            throw new PosBusinessException("Error Occurred While Updating the Pos Payment Type",e);
        }
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, readOnly = true)
    public List<PosPaymentTypeDto> list() throws PosBusinessException {
        try {
            List<PosPaymentType> posPaymentTypes = posPaymentTypeRepository.findAll();
            return posPaymentTypeBuilder.buildPaymentTypeDtoList(posPaymentTypes);

        } catch (PersistenceException | BuilderException e){
            throw new PosBusinessException("Error Occurred While Listing the Pos Payment Type",e);
        }
    }



}
