package com.demo.springapplication.library.common.model.mb;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class ResponseModel<T> extends BaseResponseObject {
    @JsonProperty("data")
    private T dataObj;

    public ResponseModel() {
    }

    public ResponseModel(String code) {
        super(code);
    }

    public ResponseModel(String code, String description) {
        super(code, description);
    }

    public ResponseModel(String code, String header, String description) {
        super(code, header, description);
    }

    public ResponseModel(Integer code) {
        super(code);
    }

    public ResponseModel(Integer code, String description) {
        super(code, description);
    }

    public ResponseModel(Integer code, String header, String description) {
        super(code, header, description);
    }

    public ResponseModel(ResponseStatusCustomCode responseStatus) {
        super(responseStatus);
    }

    public ResponseModel<T> setCode(String code) {
        super.setCode(code);
        return this;
    }

    public ResponseModel<T> setDescription(String description) {
        super.setDescription(description);
        return this;
    }

    public ResponseModel<T> setHeader(String header) {
        super.setHeader(header);
        return this;
    }

    public ResponseModel<T> setStatus(ResponseStatusCustomCode responseStatus) {
        super.setStatus(responseStatus);
        return this;
    }

    public T getDataObj() {
        return this.dataObj;
    }

    @JsonProperty("data")
    public ResponseModel<T> setDataObj(final T dataObj) {
        this.dataObj = dataObj;
        return this;
    }
}