package com.core.computism.assasa.ar.service;

import com.core.computism.assasa.ar.dto.ArAccountDto;
import com.core.computism.assasa.exception.ArBusinessException;

/**
 * Created by VD on 2/19/2016.
 */
public interface ArAccountService {
    public void saveArAccount(ArAccountDto arAccountDto) throws ArBusinessException;
}
