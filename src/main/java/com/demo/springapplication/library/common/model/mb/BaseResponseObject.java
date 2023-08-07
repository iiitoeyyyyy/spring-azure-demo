package com.demo.springapplication.library.common.model.mb;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

import java.io.Serializable;

@Getter
@Setter
@Accessors(chain = true)
public class BaseResponseObject implements Serializable {
    private ResponseStatusCustomCode status;

    public BaseResponseObject() {
        this(new ResponseStatusCustomCode());
    }

    public BaseResponseObject(ResponseStatusCustomCode status) {
        this.status = status;
    }

    public BaseResponseObject(String code) {
        this(new ResponseStatusCustomCode(code));
    }

    public BaseResponseObject(String code, String description) {
        this(new ResponseStatusCustomCode(code, description));
    }

    public BaseResponseObject(String code, String header, String description) {
        this(new ResponseStatusCustomCode(code, header, description));
    }

    public BaseResponseObject(Integer code) {
        this(new ResponseStatusCustomCode(code));
    }

    public BaseResponseObject(Integer code, String description) {
        this(new ResponseStatusCustomCode(code, description));
    }

    public BaseResponseObject(Integer code, String header, String description) {
        this(new ResponseStatusCustomCode(code, header, description));
    }

    @JsonIgnore
    public String getCode() {
        return status.getCode();
    }

    public BaseResponseObject setCode(String code) {
        status.setCode(code);
        return this;
    }

    @JsonIgnore
    public String getHeader() {
        return status.getHeader();
    }

    public BaseResponseObject setHeader(String header) {
        status.setHeader(header);
        return this;
    }

    @JsonIgnore
    public String getDescription() {
        return status.getDescription();
    }

    public BaseResponseObject setDescription(String description) {
        status.setDescription(description);
        return this;
    }

    @Override
    public String toString() {
        return "{" + "status=" + status + '}';
    }
}


