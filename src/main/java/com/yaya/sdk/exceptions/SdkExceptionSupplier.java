package com.yaya.sdk.exceptions;

import java.util.Map;

public enum SdkExceptionSupplier {

    VALIDATION_EXCEPTION(400, "Something went wrong, please contact system administrator."),
    INVALID_FIELD_VALUE(400, "Invalid field value for field: %s"),
    INVALID_PHONE_NUMBER(400, "Invalid phone number: %s"),
    INVALID_AMOUNT(400, "Invalid amount value: %s"),
    INVALID_PACKAGE_CODE(400, "Invalid package code: %s"),

    UNHANDLED_EXCEPTION(500, "Unhandled exception has occurred: %s");

    private final int code;
    private final String messageTemplate;

    SdkExceptionSupplier(int code, String messageTemplate) {
        this.code = code;
        this.messageTemplate = messageTemplate;
    }

    public SdkException get() {
        return new SdkException(code, messageTemplate);
    }

    public SdkException get(String... args) {
        return new SdkException(code, String.format(messageTemplate, (Object[]) args));
    }

    public SdkException get(Map<String, String> metadata) {
        return new SdkException(code, messageTemplate, metadata);
    }

    public SdkException get(String arg, Map<String, String> metadata) {
        return new SdkException(
                code,
                String.format(messageTemplate, arg),
                metadata
        );
    }
}
