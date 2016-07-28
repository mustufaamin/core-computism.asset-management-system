package com.core.computism.assasa.ar.service;

import com.core.computism.assasa.ar.dto.AddOnChargeDto;
import com.core.computism.assasa.ar.dto.BillCodeDto;
import com.core.computism.assasa.exception.ArBusinessException;

import java.util.List;

/**
 * Created by VD on 7/11/2016.
 */
public interface AddOnChargeService {

    AddOnChargeDto add(AddOnChargeDto addOnChargeDto) throws ArBusinessException;

    AddOnChargeDto update(AddOnChargeDto addOnChargeDto) throws ArBusinessException;

    List<AddOnChargeDto> getAddOnChargeByStatus(Integer addOnChargeStatus) throws ArBusinessException;

    List<AddOnChargeDto> list() throws ArBusinessException;
}
