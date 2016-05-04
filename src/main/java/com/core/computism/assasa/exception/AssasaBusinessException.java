package com.core.computism.assasa.exception;

import org.apache.log4j.Logger;

/**
 * Created by VD on 2/19/2016.
 */
public class AssasaBusinessException extends Exception{

    private static final Logger LOGGER = Logger.getLogger(AssasaBusinessException.class);

    public AssasaBusinessException() {
        super();
    }

    public AssasaBusinessException(String message) {
        super(message);
        LOGGER.error(message);
    }

    public AssasaBusinessException(Throwable throwable) {
        super(throwable);
        LOGGER.error(throwable);
    }

    public AssasaBusinessException(String message, Throwable throwable) {
        super(message, throwable);
        LOGGER.error(message, throwable);
    }

}
