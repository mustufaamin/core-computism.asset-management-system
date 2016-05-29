package com.core.computism.assasa.kernel.error;

public interface ErrorEnumType<E extends Enum<E>> extends IntegerEnumType<E> {
    String getErrorCode();
    String getErrorMessage();
}
