package com.core.computism.assasa.ar.enumtype;

public interface ErrorEnumType<E extends Enum<E>> extends IntegerEnumType<E> {
    String getErrorCode();
    String getErrorMessage();
}
