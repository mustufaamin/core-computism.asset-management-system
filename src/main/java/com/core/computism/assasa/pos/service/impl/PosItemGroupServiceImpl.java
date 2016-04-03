package com.core.computism.assasa.pos.service.impl;

import com.core.computism.assasa.exception.BuilderException;
import com.core.computism.assasa.exception.PosBusinessException;
import com.core.computism.assasa.persistence.entity.pos.PosItemGroup;
import com.core.computism.assasa.persistence.repository.ar.BillCodeRepository;
import com.core.computism.assasa.persistence.repository.pos.PosItemGroupRepository;
import com.core.computism.assasa.pos.builder.PosItemGroupBuilder;
import com.core.computism.assasa.pos.domain.PosItemGroupDto;
import com.core.computism.assasa.pos.service.PosItemGroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.PersistenceException;
import java.util.List;

/**
 * Created by M.Mustufa Amn Shah on 3/27/2016.
 */
@Service(value = "posItemGroupService")
public class PosItemGroupServiceImpl implements PosItemGroupService {
    @Autowired private PosItemGroupRepository posItemGroupRepository;
    @Autowired private BillCodeRepository billCodeRepository;
    @Autowired private PosItemGroupBuilder posItemGroupBuilder;

    @Override
    @Transactional(propagation = Propagation.REQUIRED, readOnly = false, rollbackFor = PosBusinessException.class)
    public PosItemGroupDto add(PosItemGroupDto posItemGroupDto) throws PosBusinessException {
        try {
            PosItemGroup posItemGroup = new PosItemGroup();
            posItemGroup = posItemGroupBuilder.buildItemGroupEntity(posItemGroup,posItemGroupDto);

            posItemGroup.setBillCode(billCodeRepository.findOne(posItemGroupDto.getBillCodeId()));

            posItemGroupRepository.save(posItemGroup);

            return posItemGroupBuilder.buildPosItemGroupDto(posItemGroup);
        } catch (PersistenceException | BuilderException e){
            throw new PosBusinessException("Error Occurred in Add positemGroup",e);
        }
    }
    @Override
    @Transactional(propagation = Propagation.REQUIRED, readOnly = false, rollbackFor = PosBusinessException.class)
    public PosItemGroupDto update(PosItemGroupDto posItemGroupDto) throws PosBusinessException {
        try {
            PosItemGroup posItemGroup = posItemGroupRepository.findOne(posItemGroupDto.getId());
            posItemGroup = posItemGroupBuilder.buildItemGroupEntity(posItemGroup,posItemGroupDto);

            posItemGroup.setBillCode(billCodeRepository.findOne(posItemGroupDto.getBillCodeId()));

            posItemGroupRepository.save(posItemGroup);

            return posItemGroupBuilder.buildPosItemGroupDto(posItemGroup);
        } catch (PersistenceException | BuilderException e){
            throw new PosBusinessException("Error Occurred in Add positemGroup",e);
        }
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, readOnly = true)
    public List<PosItemGroupDto> list() throws PosBusinessException {
        try{
            List<PosItemGroup> posItemGroups = posItemGroupRepository.findAll();
            return posItemGroupBuilder.buildPosItemGroupList(posItemGroups);
        } catch (PersistenceException | BuilderException e){
            throw new PosBusinessException(e);
        }
    }
    @Override
    @Transactional(propagation = Propagation.REQUIRED, readOnly = true)
    public List<PosItemGroupDto> listByBillCode(Long billCodeId) throws PosBusinessException {
        try{
            List<PosItemGroup> posItemGroups = posItemGroupRepository.findByBillCodeId(billCodeId);
            return posItemGroupBuilder.buildPosItemGroupList(posItemGroups);
        } catch (PersistenceException | BuilderException e){
            throw new PosBusinessException(e);
        }
    }
}
