package com.core.computism.assasa.exception;

import com.core.computism.assasa.kernel.error.ErrorEnumType;
import org.apache.log4j.Logger;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Salman on 8/18/2015.
 */
public class BuilderException extends Exception {
    private static final long serialVersionUID = 7576659201874502992L;

    private static final Logger LOGGER = Logger.getLogger(AssasaBusinessException.class);
    private String code;
    private String systemMessage;
    private boolean logStackTrace;
    private Map<String, String> fields;

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

    public BuilderException(ErrorEnumType<? extends Enum<?>> errorEnumType) {
        super(errorEnumType.getErrorMessage());
        this.code = errorEnumType.getErrorCode();
        this.systemMessage = errorEnumType.getErrorMessage();
        fields = new HashMap<String, String>();
        this.logStackTrace = false;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getSystemMessage() {
        return systemMessage;
    }

    public void setSystemMessage(String systemMessage) {
        this.systemMessage = systemMessage;
    }

    public boolean isLogStackTrace() {
        return logStackTrace;
    }

    public void setLogStackTrace(boolean logStackTrace) {
        this.logStackTrace = logStackTrace;
    }

    public Map<String, String> getFields() {
        return fields;
    }

    public void setFields(Map<String, String> fields) {
        this.fields = fields;
    }

    @Override
    public String toString() {
        return "BuilderException{" +
                "code='" + code + '\'' +
                ", systemMessage='" + systemMessage + '\'' +
                ", logStackTrace=" + logStackTrace +
                ", fields=" + fields +
                '}';
    }
}
