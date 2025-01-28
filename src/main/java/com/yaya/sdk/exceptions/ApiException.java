package com.yaya.sdk.exceptions;

public class ApiException extends Exception {
    private final int statusCode;

    public ApiException(String message) {
        this(message, null, 0);
    }

    public ApiException(String message, Throwable cause) {
        this(message, cause, 0);
    }

    public ApiException(String message, int statusCode) {
        this(message, null, statusCode);
    }

    public ApiException(String message, Throwable cause, int statusCode) {
        super(message, cause);
        this.statusCode = statusCode;
    }

    public int getStatusCode() {
        return statusCode;
    }
}