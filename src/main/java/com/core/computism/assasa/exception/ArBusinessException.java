package com.core.computism.assasa.exception;

import org.apache.log4j.Logger;

/**
 * Created by VD on 2/21/2016.
 */
public class ArBusinessException extends Exception {

    private static final long serialVersionUID = -4418716700680302975L;
    private static final Logger LOGGER = Logger.getLogger(BrainBusinessException.class);

    public ArBusinessException() {
        super();
    }

    public ArBusinessException(String message) {
        super(message);
        LOGGER.error(message);
    }

    public ArBusinessException(Throwable throwable) {
        super(throwable);
        LOGGER.error(throwable);
    }

    public ArBusinessException(String message, Throwable throwable) {
        super(message, throwable);
        LOGGER.error(message, throwable);
    }
}
