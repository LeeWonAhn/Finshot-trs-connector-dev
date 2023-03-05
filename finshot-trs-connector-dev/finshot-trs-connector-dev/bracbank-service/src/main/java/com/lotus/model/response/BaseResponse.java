package com.lotus.model.response;

import lombok.Data;

public class BaseResponse {
    private String errorCode;
    private String errorMessage;
    private Object object;

    public BaseResponse(String errorCode, String errorMessage, Object object) {
        this.errorCode = errorCode;
        this.errorMessage = errorMessage;
        this.object = object;
    }

    public String getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public Object getObject() {
        return object;
    }

    public void setObject(Object object) {
        this.object = object;
    }
}
