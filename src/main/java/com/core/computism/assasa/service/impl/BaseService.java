package com.core.computism.assasa.service.impl;

import com.core.computism.assasa.util.DomainEntityBuilder;
import org.apache.log4j.Logger;
import org.dozer.Mapper;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by Venturedive on 8/18/2015.
 */
public abstract class BaseService {

    protected Logger logger = Logger.getLogger(getClass());

    @Autowired
    private Mapper mapper;

    public <T, I> T builder(Class<?> c, I instance) {
        return (T) new DomainEntityBuilder<>((Class) c, instance, mapper);
    }

    protected boolean isValidId(Long id) {
        return id != null && id.longValue() > 0L;
    }
}
