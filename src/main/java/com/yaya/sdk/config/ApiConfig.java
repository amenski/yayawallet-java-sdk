package com.yaya.sdk.config;

public class ApiConfig {
    private final String apiUrl;
    private final String apiPath;
    private final String apiKey;
    private final String apiSecret;

    private ApiConfig(Builder builder) {
        this.apiUrl = builder.apiUrl;
        this.apiPath = builder.apiPath;
        this.apiKey = builder.apiKey;
        this.apiSecret = builder.apiSecret;
    }

    public static ApiConfig fromEnvironment() {
        return new ApiConfig.Builder()
                .apiUrl(getRequiredEnv("YAYA_API_URL"))
                .apiPath(getRequiredEnv("YAYA_API_PATH"))
                .apiKey(getRequiredEnv("YAYA_API_KEY"))
                .apiSecret(getRequiredEnv("YAYA_API_SECRET"))
                .build();
    }

    private static String getRequiredEnv(String name) {
        String value = System.getenv(name);
        if (value == null || value.trim().isEmpty()) {
            throw new IllegalStateException("Required environment variable " + name + " is not set");
        }
        return value;
    }

    public String getApiUrl() {
        return apiUrl;
    }

    public String getApiPath() {
        return apiPath;
    }

    public String getApiKey() {
        return apiKey;
    }

    public String getApiSecret() {
        return apiSecret;
    }

    public static class Builder {
        private String apiUrl;
        private String apiPath;
        private String apiKey;
        private String apiSecret;

        public Builder apiUrl(String apiUrl) {
            this.apiUrl = apiUrl;
            return this;
        }

        public Builder apiPath(String apiPath) {
            this.apiPath = apiPath;
            return this;
        }

        public Builder apiKey(String apiKey) {
            this.apiKey = apiKey;
            return this;
        }

        public Builder apiSecret(String apiSecret) {
            this.apiSecret = apiSecret;
            return this;
        }

        public ApiConfig build() {
            return new ApiConfig(this);
        }
    }
}

