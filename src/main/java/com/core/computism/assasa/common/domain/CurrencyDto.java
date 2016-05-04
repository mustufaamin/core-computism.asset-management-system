package com.core.computism.assasa.common.domain;

/**
 * Created by VD on 5/2/2016.
 */
public class CurrencyDto {
    private Long id;
    private String name;
    private String symbol;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }
}
