package com.core.computism.assasa.kernel.error.type;

public enum ErrorTypePrefix {

    CUSTOMER_ERROR_TYPE ("CC-");

    private String prefix;

    ErrorTypePrefix(String prefix) {
        this.prefix = prefix;
    }

    public String getErrorPrefix() {
        return prefix;
    }

}
