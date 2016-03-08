package com.core.computism.assasa.web.controller;

import com.core.computism.assasa.util.ServerResponse;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import com.core.computism.assasa.ar.enumtype.ErrorEnumType;
import org.apache.commons.collections.CollectionUtils;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import static java.util.Collections.emptyList;
import static java.util.Collections.singletonList;


/**
 * Created by VD on 2/28/2016.
 */
@RequestMapping(value = "/assasa/", produces = {MediaType.APPLICATION_JSON_VALUE + "; charset=utf-8"})
public abstract class BaseController {

    public static final String DEFAULT_SERVICE_PROVIDER_KEY = "CAREEM";

    private static final String RESULTS = "results";
    private static final String ROWS = "rows";
    private static final String SIZE = "size";
    private static final String SUCCESS = "success";
    private static final String SUCCESS_MESSAGE = "Operation completed successfully.";
    private static final String OPERATION_MESSAGE = "operationMessage";
    private static final String ERROR_CODE = "errorCode";
    private static final String TRACE = "trace";
    private static final String FIELDS = "fields";



    protected <T> ServerResponse<T> toResponse(T data) {
        ServerResponse<T> response = new ServerResponse<>();
        response.setData(data);
        response.setSuccess(true);
        return response;
    }
    protected Map<String, Object> createFailedModelMapWithErrorCode(String errorCode, String msg, String trace, Map<String, String> fields) {
        Map<String, Object> modelMap = new HashMap<>();
        modelMap.put(SUCCESS, false);
        modelMap.put(OPERATION_MESSAGE, msg);
        modelMap.put(ERROR_CODE, errorCode);
        modelMap.put(TRACE, trace);
        if (fields != null && CollectionUtils.isNotEmpty(fields.keySet())) {
            modelMap.put(FIELDS, fields);
        }
        return modelMap;
    }



    protected Map<String, Object> createModelMap(Object row) {
        Map<String, Object> modelMap = new HashMap<String, Object>();
        modelMap.put(SUCCESS, true);
        modelMap.put(ROWS, row != null ? singletonList(row) : emptyList());
        modelMap.put(RESULTS, row != null ? 1 : 0);
        return modelMap;
    }

    protected Map<String, Object> createModelMapWithMessage(Object row) {
        Map<String, Object> modelMap = new HashMap<String, Object>();
        modelMap.put(SUCCESS, true);
        modelMap.put(ROWS, row != null ? singletonList(row) : emptyList());
        modelMap.put(OPERATION_MESSAGE, SUCCESS_MESSAGE);
        modelMap.put(RESULTS, row != null ? 1 : 0);
        return modelMap;
    }

    protected Map<String, Object> createModelMapWithMessage(Collection<? extends Object> rows) {
        Map<String, Object> modelMap = new HashMap<String, Object>();
        modelMap.put(SUCCESS, true);
        modelMap.put(ROWS, rows);
        modelMap.put(OPERATION_MESSAGE, SUCCESS_MESSAGE);
        modelMap.put(RESULTS, rows.size());
        return modelMap;
    }

    protected Map<String, Object> createModelMap(Collection<? extends Object> rows) {
        Map<String, Object> modelMap = new HashMap<String, Object>();
        modelMap.put(SUCCESS, true);
        modelMap.put(ROWS, rows);
        modelMap.put(RESULTS, rows.size());
        return modelMap;
    }

    protected Map<String, Object> createTimeModelMap(Long value) {
        Map<String, Object> modelMap = new HashMap<String, Object>();
        modelMap.put("TIME", value);
        return modelMap;
    }

    protected Map<String, Object> createModelMap(Long size, Collection<? extends Object> rows) {
        Map<String, Object> modelMap = new HashMap<String, Object>();
        modelMap.put(SUCCESS, true);
        modelMap.put(ROWS, rows);
        modelMap.put(RESULTS, rows.size());
        modelMap.put(SIZE, size);
        return modelMap;
    }

    protected Map<String, Object> createSuccessModelMap() {
        Map<String, Object> modelMap = new HashMap<String, Object>();
        modelMap.put(SUCCESS, true);
        return modelMap;
    }

    protected Map<String, Object> createSuccessModelMapWithZeroRows() {
        Map<String, Object> modelMap = new HashMap<String, Object>();
        modelMap.put(SUCCESS, true);
        modelMap.put(ROWS, emptyList());
        modelMap.put(RESULTS, 0);
        return modelMap;
    }

    protected Map<String, Object> createFailedModelMap() {
        Map<String, Object> modelMap = new HashMap<String, Object>();
        modelMap.put(SUCCESS, false);
        modelMap.put(ROWS, emptyList());
        modelMap.put(RESULTS, 0);
        return modelMap;
    }

    protected Map<String, Object> createFailedModelMap(String msg) {
        Map<String, Object> modelMap = new HashMap<String, Object>();
        modelMap.put(SUCCESS, false);
        modelMap.put(OPERATION_MESSAGE, msg);
        return modelMap;
    }

    protected Map<String, Object> createFailedModelMapWithErrorCode(String errorCode, String msg) {
        Map<String, Object> modelMap = new HashMap<String, Object>();
        modelMap.put(SUCCESS, false);
        modelMap.put(OPERATION_MESSAGE, msg);
        modelMap.put(ERROR_CODE, errorCode);
        return modelMap;
    }

    protected Map<String, Object> createFailedModelMapWithErrorCode(ErrorEnumType<? extends Enum<?>> errorEnumType) {
        Map<String, Object> modelMap = new HashMap<String, Object>();
        modelMap.put(SUCCESS, false);
        modelMap.put(OPERATION_MESSAGE, errorEnumType.getErrorMessage());
        modelMap.put(ERROR_CODE, errorEnumType.getErrorCode());
        return modelMap;
    }

    protected Map<String, Object> createFailedModelMapWithRows(String msg) {
        Map<String, Object> modelMap = new HashMap<String, Object>();
        modelMap.put(SUCCESS, false);
        modelMap.put(ROWS, emptyList());
        modelMap.put(RESULTS, 0);
        modelMap.put(OPERATION_MESSAGE, msg);
        return modelMap;
    }

    protected Map<String, Object> createSuccessModelMap(String msg) {
        Map<String, Object> modelMap = new HashMap<String, Object>();
        modelMap.put(SUCCESS, true);
        modelMap.put(OPERATION_MESSAGE, msg);
        return modelMap;
    }

    protected Map<String, Object> createEmptyFailedModelMap() {
        Map<String, Object> modelMap = new HashMap<String, Object>();
        modelMap.put(SUCCESS, false);
        return modelMap;
    }
}
