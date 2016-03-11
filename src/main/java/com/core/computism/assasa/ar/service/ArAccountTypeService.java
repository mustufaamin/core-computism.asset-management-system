package com.core.computism.assasa.ar.service;

import com.core.computism.assasa.ar.dto.ArAccountTypeDto;
import com.core.computism.assasa.exception.ArBusinessException;

/**
 * Created by VD on 2/21/2016.
 */
public interface ArAccountTypeService {
    public void saveArAccountType(ArAccountTypeDto arAccountTypeDto) throws ArBusinessException;
}
