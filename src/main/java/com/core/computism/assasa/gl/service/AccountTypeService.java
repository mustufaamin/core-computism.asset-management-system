package com.core.computism.assasa.gl.service;

import com.core.computism.assasa.exception.ArBusinessException;
import com.core.computism.assasa.gl.dto.AccountTypeDto;

/**
 * Created by VD on 2/21/2016.
 */
public interface AccountTypeService {
    public void saveAccountType(AccountTypeDto accountTypeDto) throws ArBusinessException;
}