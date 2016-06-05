package com.core.computism.assasa.common.service.impl;

import com.core.computism.assasa.common.builder.CurrencyBuilder;
import com.core.computism.assasa.common.domain.CurrencyDto;
import com.core.computism.assasa.common.service.CurrencyService;
import com.core.computism.assasa.exception.AssasaBusinessException;
import com.core.computism.assasa.exception.BuilderException;
import com.core.computism.assasa.persistence.entity.common.Currency;
import com.core.computism.assasa.persistence.repository.common.CurrencyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.PersistenceException;
import java.util.List;

/**
 * Created by VD on 5/2/2016.
 */
@Service(value = "currencyService")
public class CurrencyServiceImpl implements CurrencyService {

    @Autowired private CurrencyRepository currencyRepository;
    @Autowired private CurrencyBuilder currencyBuilder;

    @Transactional(propagation = Propagation.REQUIRED, readOnly = false, rollbackFor = AssasaBusinessException.class)
    public CurrencyDto add(CurrencyDto currencyDto) throws AssasaBusinessException {

        try{
            Currency currency = new Currency();
            currency = currencyBuilder.buildCurrencyEntity(currency,currencyDto);

            currency = currencyRepository.save(currency);

            return currencyBuilder.buildCurrencyDto(currency);
        } catch (PersistenceException | BuilderException e){
            throw new AssasaBusinessException("Error Occurred in add Currency");
        }

    }

    @Transactional(readOnly = true)
    public List<CurrencyDto> list() throws AssasaBusinessException {
        try{
            List<Currency> currencies = currencyRepository.findAll();
            return currencyBuilder.buildCurrencyDtoList(currencies);
        } catch (PersistenceException | BuilderException e){
            throw new AssasaBusinessException("Error Occurred in getting currency List");
        }
    }

    @Transactional(readOnly = true)
    public Currency getCurrency(Long currencyId) throws AssasaBusinessException {
        try{
            return currencyRepository.findOne(currencyId);

        } catch (PersistenceException e){
            throw new AssasaBusinessException("Error Occurred in getCurrency");
        }
    }
}
