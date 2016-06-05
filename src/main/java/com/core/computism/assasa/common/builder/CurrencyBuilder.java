package com.core.computism.assasa.common.builder;

import com.core.computism.assasa.common.domain.CurrencyDto;
import com.core.computism.assasa.exception.BuilderException;
import com.core.computism.assasa.persistence.entity.common.Currency;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by VD on 5/2/2016.
 */
@Component(value = "currencyBuilder")
public class CurrencyBuilder {

    public CurrencyDto buildCurrencyDto(Currency currency) throws BuilderException {
        if(currency == null){
            throw new BuilderException("Currency object is null");
        }

        CurrencyDto currencyDto = new CurrencyDto();

        currencyDto.setId(currency.getId());
        currencyDto.setName(currency.getName());
        currencyDto.setSymbol(currency.getSymbol());

        return currencyDto;
    }
    public Currency buildCurrencyEntity(Currency currency, CurrencyDto currencyDto) throws BuilderException {

        if(currency == null || currencyDto == null){
            throw new BuilderException("Currency or Currency DTO is Null");
        }
        currency.setName(currencyDto.getName());
        currency.setSymbol(currencyDto.getSymbol());

        return currency;
    }

    public List<CurrencyDto> buildCurrencyDtoList(List<Currency> currencies) throws BuilderException {
        List<CurrencyDto> currencyDtos = new ArrayList<>();

        for(Currency currency : currencies){
            CurrencyDto currencyDto = buildCurrencyDto(currency);
            currencyDtos.add(currencyDto);
        }
        return currencyDtos;
    }

}
