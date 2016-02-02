package com.core.computism.assetmanagementsystem.exception;

/**
 * Created by Venturedive on 8/18/2015.
 */
public class BuilderException extends Exception {
    private static final long serialVersionUID = 7576659201874502992L;

    public BuilderException() {
        super();
    }

    public BuilderException(String message) {
        super(message);
    }

    public BuilderException(Throwable throwable) {
        super(throwable);
    }

    public BuilderException(String message, Throwable throwable) {
        super(message, throwable);
    }
}
