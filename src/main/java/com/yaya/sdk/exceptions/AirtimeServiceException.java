package com.yaya.sdk.exceptions;

public class AirtimeServiceException extends Exception {
    public AirtimeServiceException(String message) {
        super(message);
    }

    public AirtimeServiceException(String message, Throwable cause) {
        super(message, cause);
    }

    public AirtimeServiceException(Throwable cause) {
        super(cause);
    }
}
