package com.core.computism.assasa.ar.service;

import com.core.computism.assasa.ar.dto.AddOnGroupDto;
import com.core.computism.assasa.exception.ArBusinessException;

import java.util.List;

/**
 * Created by VD on 7/11/2016.
 */
public interface AddOnGroupService {

    AddOnGroupDto add(AddOnGroupDto addOnGroupDto) throws ArBusinessException;

    AddOnGroupDto update(AddOnGroupDto addOnChargeDto) throws ArBusinessException;

    List<AddOnGroupDto> getAddOnGroupByStatus(Integer addOnGroupStatus) throws ArBusinessException;
}
