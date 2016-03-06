package com.core.computism.assasa.ar.service;

import com.core.computism.assasa.ar.dto.ArAccountDto;
import com.core.computism.assasa.ar.dto.ArAccountTypeDto;
import com.core.computism.assasa.exception.ArBusinessException;
import com.core.computism.assasa.exception.BrainBusinessException;

/**
 * Created by VD on 2/21/2016.
 */
public interface ArAccountTypeService {
    public void saveArAccountType(ArAccountTypeDto arAccountTypeDto) throws ArBusinessException;
}
