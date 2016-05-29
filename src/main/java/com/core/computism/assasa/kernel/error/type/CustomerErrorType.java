package com.core.computism.assasa.kernel.error.type;


import com.core.computism.assasa.kernel.error.ErrorEnumType;

/**
 * Created by Faizan on 05/23/2016.
 */
public enum CustomerErrorType implements ErrorEnumType<CustomerErrorType> {

    INVALID_ID (1, "Invalid customer id."),
    CUSTOMER_NOT_EXIST (2, "Customer does not exist."),
    INVALID_CUSTOMER_TYPE_ID (3, "Invalid customer type id."),
    CUSTOMER_TYPE_NOT_EXIST (4, "Customer Type does not exist."),
    CUSTOMER_TYPE_DTO_NOT_EXIST (5, "Customer Type Dto does not exist."),
    CUSTOMER_TYPE_BUILD_DTO(6,"Unable to build Customer Type DTO List for [null] Customer Type or empty.");

    private int code;
    private String errorMessage;

    CustomerErrorType(int code, String errorMessage) {
        this.code = code;
        this.errorMessage = errorMessage;
    }

    @Override
    public int getCode() {
        return code;
    }

    @Override
    public String getErrorCode() {
        return ErrorTypePrefix.CUSTOMER_ERROR_TYPE.getErrorPrefix() + String.format("%04d", code);
    }

    @Override
    public String getErrorMessage() {
        return errorMessage;
    }
}
