package com.core.computism.assasa.exception;

import org.apache.log4j.Logger;

/**
 * Created by Venturedive on 8/18/2015.
 */
public class BrainBusinessException extends Exception {
    private static final long serialVersionUID = -4418716700680302975L;
    private static final Logger LOGGER = Logger.getLogger(BrainBusinessException.class);

    public BrainBusinessException() {
        super();
    }

    public BrainBusinessException(String message) {
        super(message);
        LOGGER.error(message);
    }

    public BrainBusinessException(Throwable throwable) {
        super(throwable);
        LOGGER.error(throwable);
    }

    public BrainBusinessException(String message, Throwable throwable) {
        super(message, throwable);
        LOGGER.error(message, throwable);
    }
}
