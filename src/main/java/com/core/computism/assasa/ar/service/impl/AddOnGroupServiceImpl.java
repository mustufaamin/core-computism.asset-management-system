package com.core.computism.assasa.ar.service.impl;

import com.core.computism.assasa.ar.builder.AddOnGroupBuilder;
import com.core.computism.assasa.ar.dto.AddOnGroupDetailDto;
import com.core.computism.assasa.ar.dto.AddOnGroupDto;
import com.core.computism.assasa.ar.service.AddOnChargeService;
import com.core.computism.assasa.ar.service.AddOnGroupService;
import com.core.computism.assasa.exception.ArBusinessException;
import com.core.computism.assasa.exception.BuilderException;
import com.core.computism.assasa.persistence.entity.ar.billing.AddOnCharge;
import com.core.computism.assasa.persistence.entity.ar.billing.AddOnGroup;
import com.core.computism.assasa.persistence.entity.ar.billing.AddOnGroupDetail;
import com.core.computism.assasa.persistence.repository.ar.AddOnChargeRepository;
import com.core.computism.assasa.persistence.repository.ar.AddOnGroupRepository;
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
 * Created by Faizan Iftikhar on 7/12/2016.
 */
@Service(value = "addOnChargeService")
public class AddOnGroupServiceImpl implements AddOnGroupService {

    @Autowired
    AddOnGroupRepository addOnGroupRepository;

    @Autowired
    GlAccountRepository glAccountRepository;

    @Autowired
    AddOnGroupBuilder addOnGroupBuilder;

    @Autowired
    AddOnChargeRepository addOnChargeRepository;

    @Override
    @Transactional(propagation = Propagation.REQUIRED, readOnly = false, rollbackFor = ArBusinessException.class)
    public AddOnGroupDto add(AddOnGroupDto addOnGroupDto) throws ArBusinessException {
        try {

            if (CollectionUtils.isEmpty(addOnGroupDto.getAddOnGroupDetailDtos())) {
                throw new ArBusinessException("Provide Add-On Group List.");
            }
            AddOnGroup addOnGroup = new AddOnGroup();
            addOnGroup = addOnGroupBuilder.buildAddOnChargeEntity(addOnGroupDto, addOnGroup);

            /*Populate List Of Group detail*/
            populateAddOnGroupDetails(addOnGroupDto.getAddOnGroupDetailDtos(), addOnGroup);

            addOnGroup = addOnGroupRepository.save(addOnGroup);
            return addOnGroupBuilder.buildAddOnGroupDto(addOnGroup);
        } catch (BuilderException e) {
            throw new ArBusinessException("Error Occurred While saving Add-On Group", e);
        }
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, readOnly = false, rollbackFor = ArBusinessException.class)
    public AddOnGroupDto update(AddOnGroupDto addOnGroupDto) throws ArBusinessException {
        try {

            if (CollectionUtils.isEmpty(addOnGroupDto.getAddOnGroupDetailDtos())) {
                throw new ArBusinessException("Provide Add-On Group List.");
            }
            AddOnGroup addOnGroup = addOnGroupRepository.getOne(addOnGroupDto.getAddOnGroupId());
            addOnGroup = addOnGroupBuilder.buildAddOnChargeEntity(addOnGroupDto, addOnGroup);


            addOnGroup = addOnGroupRepository.save(addOnGroup);
            return addOnGroupBuilder.buildAddOnGroupDto(addOnGroup);

        } catch (PersistenceException | BuilderException e) {
            throw new ArBusinessException("Error Occurred In Add-On Group service Update", e);
        }
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, readOnly = true)
    public List<AddOnGroupDto> getAddOnGroupByStatus(Integer addOnChargeStatus) throws ArBusinessException {
        try {

            if (addOnChargeStatus == null) {
                throw new ArBusinessException("Invalid add-on Group status.");
            }
            List<AddOnGroup> addOnGroups = addOnGroupRepository.findAddOnGroupsByStatus(addOnChargeStatus);
            return addOnGroupBuilder.buildAddOnGroupDtoList(addOnGroups);
        } catch (BuilderException e) {
            throw new ArBusinessException("Error Occurred In Group service Update", e);
        }
    }

    @Transactional(propagation = Propagation.REQUIRED, readOnly = false, rollbackFor = ArBusinessException.class)
    private List<AddOnGroupDetail> populateAddOnGroupDetails(List<AddOnGroupDetailDto> addOnGroupDetailDtos, AddOnGroup addOnGroup) throws BuilderException {
        List<AddOnGroupDetail> addOnGroupDetails = new ArrayList<>();
        for(AddOnGroupDetailDto addOnGroupDetailDto : addOnGroupDetailDtos) {
            AddOnGroupDetail addOnGroupDetail = new AddOnGroupDetail();
            AddOnCharge addOnCharge = addOnChargeRepository.findOne(Long.valueOf(addOnGroupDetailDto.getAddOnChargeId()));
            addOnGroupDetail.setAddOnCharge(addOnCharge);
            addOnGroupDetail.setAddOnGroup(addOnGroup);
            addOnGroupDetails.add(addOnGroupDetail);
        }
        return addOnGroupDetails;
    }
}
