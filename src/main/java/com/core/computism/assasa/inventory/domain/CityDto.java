package com.core.computism.assasa.inventory.domain;

/**
 * Created by Mustafa Amin Shah on 3/13/2016.
 */
public class CityDto {

    private Long id;
    private String name;
    private String state;
    private Long country_id;

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

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public Long getCountry_id() {
        return country_id;
    }

    public void setCountry_id(Long country_id) {
        this.country_id = country_id;
    }
}
