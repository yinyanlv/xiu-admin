package com.bugong.xiuadmin.common.response;

public class ExceptionResponse {

    private String message;
    private String stackTrace;

    public ExceptionResponse(String message) {
        this.message = message;
    }

    public ExceptionResponse(String message, String stackTrace) {
        this.message = message;
        this.stackTrace = stackTrace;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getStackTrace() {
        return stackTrace;
    }

    public void setStackTrace(String stackTrace) {
        this.stackTrace = stackTrace;
    }
}
