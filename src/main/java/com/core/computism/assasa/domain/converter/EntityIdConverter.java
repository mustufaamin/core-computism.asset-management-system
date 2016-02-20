package com.core.computism.assasa.domain.converter;

import com.core.computism.assasa.persistence.entity.ticket.BaseEntity;
import org.apache.log4j.Logger;
import org.dozer.CustomConverter;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * Created by Venturedive on 8/20/2015.
 */
@Component
public class EntityIdConverter implements CustomConverter {

    private static final Logger LOGGER = Logger.getLogger(EntityIdConverter.class);

    @PersistenceContext(unitName = "ticketPersistenceUnit")
    private EntityManager entityManager;

    @Override
    public Object convert(Object destination, Object source, Class<?> destinationClass, Class<?> sourceClass) {

        if (source == null) {
            return null;
        }

        Long sourceId = null;

        if (String.class.isAssignableFrom(sourceClass)) {
            sourceId = Long.parseLong((String) source);
            return entityManager.find(destinationClass, sourceId);

        } else if (Long.class.isAssignableFrom(sourceClass)) {
            sourceId = (Long) source;
            return entityManager.find(destinationClass, sourceId);

        } else if (BaseEntity.class.isAssignableFrom(sourceClass)) {
            return ((BaseEntity) source).getId();

        }
        LOGGER.error("Unable to convert Id from source class [" + sourceClass + "]");
        return null;
    }
}
