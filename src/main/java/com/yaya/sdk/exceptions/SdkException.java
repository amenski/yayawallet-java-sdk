package com.yaya.sdk.exceptions;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class SdkException extends Exception {
    private final int code;
    private final Map<String, String> metadata;

    public SdkException(int code, String message) {
        this(code, message, Collections.emptyMap());
    }

    public SdkException(int code, String message, Map<String, String> metadata) {
        super(message);
        this.code = code;
        this.metadata = Collections.unmodifiableMap(new HashMap<>(metadata));
    }

    public int getCode() {
        return code;
    }

    public Map<String, String> getMetadata() {
        return metadata;
    }
}
