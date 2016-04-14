package com.core.computism.assasa.ar.service;

import com.core.computism.assasa.ar.dto.AdjustmentDto;
import com.core.computism.assasa.ar.dto.PaymentDto;
import com.core.computism.assasa.exception.ArBusinessException;

/**
 * Created by VD on 3/23/2016.
 */
public interface AdjustmentService {

    public void saveAdjustment(AdjustmentDto adjustmentDto) throws ArBusinessException;

    public void saveNPostAdjustment(AdjustmentDto adjustmentDto) throws ArBusinessException;
}
