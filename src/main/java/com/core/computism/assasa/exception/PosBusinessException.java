package com.core.computism.assasa.exception;

import org.apache.log4j.Logger;

/**
 * Created by VD on 2/19/2016.
 */
public class PosBusinessException extends Exception{

    private static final Logger LOGGER = Logger.getLogger(PosBusinessException.class);

    public PosBusinessException() {
        super();
    }

    public PosBusinessException(String message) {
        super(message);
        LOGGER.error(message);
    }

    public PosBusinessException(Throwable throwable) {
        super(throwable);
        LOGGER.error(throwable);
    }

    public PosBusinessException(String message, Throwable throwable) {
        super(message, throwable);
        LOGGER.error(message, throwable);
    }

}
