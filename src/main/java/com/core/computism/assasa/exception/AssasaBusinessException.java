package com.core.computism.assasa.exception;

import com.core.computism.assasa.kernel.error.ErrorEnumType;
import org.apache.log4j.Logger;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by VD on 2/19/2016.
 */
public class AssasaBusinessException extends Exception {

    private static final Logger LOGGER = Logger.getLogger(AssasaBusinessException.class);
    private String code;
    private String systemMessage;
    private boolean logStackTrace;
    private Map<String, String> fields;

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

    public AssasaBusinessException(ErrorEnumType<? extends Enum<?>> errorEnumType) {
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
        return "AssasaBusinessException{" +
                "code='" + code + '\'' +
                ", systemMessage='" + systemMessage + '\'' +
                ", logStackTrace=" + logStackTrace +
                ", fields=" + fields +
                '}';
    }
}
