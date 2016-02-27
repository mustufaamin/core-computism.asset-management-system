package com.core.computism.assasa.gl.service;

import com.core.computism.assasa.exception.ArBusinessException;
import com.core.computism.assasa.gl.dto.GlAccountDto;

/**
 * Created by VD on 2/27/2016.
 */
public interface GlAccountService {
    public void saveGlAccount(GlAccountDto glAccountDto) throws ArBusinessException;
}
