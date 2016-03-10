package com.core.computism.assasa.gl.service.impl;

import com.core.computism.assasa.exception.ArBusinessException;
import com.core.computism.assasa.gl.builder.GlAccountBuilder;
import com.core.computism.assasa.gl.dto.GlAccountDto;
import com.core.computism.assasa.gl.service.GlAccountService;
import com.core.computism.assasa.persistence.entity.gl.admin.GlAccount;
import com.core.computism.assasa.persistence.repository.gl.GlAccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by Mustufa Amin Shah on 2/27/2016.
 */
@Service(value = "glAccountServiceImpl")
public class GlAccountServiceImpl implements GlAccountService {

    /*@Autowired
    GlAccountRepository glAccountRepository;*/

    @Override
    @Transactional(propagation = Propagation.REQUIRED, readOnly = false, rollbackFor = ArBusinessException.class)
    public void saveGlAccount(GlAccountDto glAccountDto) throws ArBusinessException {

        GlAccount glAccount = new GlAccountBuilder()
                .setCompanyId(glAccountDto.getCompanyId())
                .setDepartmentId(glAccountDto.getDepartmentId())
                .setMajorAccountNumber(glAccountDto.getMajorAccountNumber())
                .setAccountTypeId(glAccountDto.getAccountTypeId())
                .setAccountUsageType(glAccountDto.getAccountUsageType())
                .setShortDescription(glAccountDto.getShortDescription())
                .setLongDescription(glAccountDto.getLongDescription())
                .setActivationDate(glAccountDto.getActivationDate())
                .setTerminationDate(glAccountDto.getTerminationDate())
                .setExtAcctNum(glAccountDto.getExtAcctNum())
                .setChangedBy(glAccountDto.getChangedBy())
                .setStatus(glAccountDto.getStatus())
                .setTransferred(glAccountDto.getTransferred())
                .setDetailedViewOnPosting(glAccountDto.getDetailedViewOnPosting())
                .setAllowManualJEEntriesAgainstCA(glAccountDto.getAllowManualJEEntriesAgainstCA())
                .setMultiCurrency(glAccountDto.getMultiCurrency())
                .setAccountNature(glAccountDto.getAccountNature()).build();

       /* glAccountRepository.save(glAccount);*/
    }
}
