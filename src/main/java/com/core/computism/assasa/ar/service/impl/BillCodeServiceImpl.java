package com.core.computism.assasa.ar.service.impl;

import com.core.computism.assasa.ar.builder.BillCodeBuilder;
import com.core.computism.assasa.exception.ArBusinessException;
import com.core.computism.assasa.exception.BuilderException;
import com.core.computism.assasa.exception.PosBusinessException;
import com.core.computism.assasa.ar.dto.BillCodeDto;
import com.core.computism.assasa.ar.service.BillCodeService;
import com.core.computism.assasa.persistence.entity.ar.billing.BillCode;
import com.core.computism.assasa.persistence.entity.gl.admin.GlAccount;
import com.core.computism.assasa.persistence.repository.ar.BillCodeRepository;
import com.core.computism.assasa.persistence.repository.gl.GlAccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.PersistenceException;
import java.util.List;

/**
 * Created by M.Mustufa Amin Shah on 3/23/2016.
 */
@Service(value = "billCodeService")
public class BillCodeServiceImpl implements BillCodeService {

    @Autowired
    private BillCodeRepository billCodeRepository;
    @Autowired
    private BillCodeBuilder billCodeBuilder;

    @Autowired
    GlAccountRepository glAccountRepository;

    @Transactional(propagation = Propagation.REQUIRED, readOnly = false, rollbackFor = ArBusinessException.class)
    public BillCodeDto add(BillCodeDto billCodeDto) throws ArBusinessException {
        try {
            BillCode billCode = new BillCode();

            billCode = billCodeBuilder.buildBillCodeEntity(billCodeDto, billCode);

            GlAccount glAccount = glAccountRepository.findOne(billCodeDto.getGlAccountId());
            billCode.setGlAccount(glAccount);

            billCode = billCodeRepository.save(billCode);
            return billCodeBuilder.buildBillCodeDto(billCode);
        } catch (PersistenceException | BuilderException e) {
            throw new ArBusinessException("Error Occurred In BillCode service Add", e);
        }
    }

    @Transactional(propagation = Propagation.REQUIRED, readOnly = false, rollbackFor = ArBusinessException.class)
    public BillCodeDto update(BillCodeDto billCodeDto) throws ArBusinessException {
        try {
            BillCode billCode = billCodeRepository.getOne(billCodeDto.getId());
            billCode = billCodeBuilder.buildBillCodeEntity(billCodeDto, billCode);

            billCode = billCodeRepository.save(billCode);
            return billCodeBuilder.buildBillCodeDto(billCode);

        } catch (PersistenceException | BuilderException e) {
            throw new ArBusinessException("Error Occurred In BillCode service Update", e);
        }
    }

    @Transactional(propagation = Propagation.REQUIRED, readOnly = true)
    public List<BillCodeDto> list() throws ArBusinessException {
        try {
            List<BillCode> billCodes = billCodeRepository.findAll();
            return billCodeBuilder.buildBillCodeDtoList(billCodes);

        } catch (PersistenceException | BuilderException e) {
            throw new ArBusinessException("Error Occurred In BillCode service Update", e);
        }
    }
    @Transactional(propagation = Propagation.REQUIRED, readOnly = true)
    public List<BillCodeDto> search(String searchKey) throws ArBusinessException {
        try {
            searchKey = "%"+searchKey+"%";
            List<BillCode> billCodes = billCodeRepository.searchBillCodes(searchKey);
            return billCodeBuilder.buildBillCodeDtoList(billCodes);

        } catch (PersistenceException | BuilderException e) {
            throw new ArBusinessException("Error Occurred In BillCode service Update", e);
        }
    }


}
