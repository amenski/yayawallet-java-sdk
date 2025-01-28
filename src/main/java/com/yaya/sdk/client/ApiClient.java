package com.yaya.sdk.client;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.yaya.sdk.config.ApiConfig;
import com.yaya.sdk.config.ErrorResponse;
import com.yaya.sdk.exceptions.AirtimeServiceException;
import com.yaya.sdk.exceptions.ApiException;
import com.yaya.sdk.models.Time;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import java.io.IOException;
import java.net.URI;
import java.net.URLEncoder;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.charset.StandardCharsets;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.time.Duration;
import java.util.Base64;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

public class ApiClient {

    public enum HttpMethod {
        GET, POST, PUT, DELETE
    }

    private static final String HMAC_ALGORITHM = "HmacSHA256";
    private static final String CONTENT_TYPE = "application/json";

    private final String apiUrl;
    private final String apiPath;
    private final String apiKey;
    private final String apiSecret;
    private final ObjectMapper objectMapper;
    private final HttpClient httpClient;

    public ApiClient(ApiConfig config) {
        this.apiUrl = Objects.requireNonNull(config.getApiUrl(), "API URL cannot be null");
        this.apiPath = Objects.requireNonNull(config.getApiPath(), "API path cannot be null");
        this.apiKey = Objects.requireNonNull(config.getApiKey(), "API key cannot be null");
        this.apiSecret = Objects.requireNonNull(config.getApiSecret(), "API secret cannot be null");

        this.objectMapper = new ObjectMapper().configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);

        this.httpClient = HttpClient.newBuilder()
                .connectTimeout(Duration.ofSeconds(10))
                .build();
    }

    public <T> T sendRequest(HttpMethod method,
                             String path,
                             Map<String, String> queryParams,
                             Object body,
                             Class<T> responseType,
                             String errorMessage) throws ApiException {
        try {
            String url = buildUrl(path, queryParams);
            String jsonBody = serializeBody(body);
            Time serverTime = getServerTime();

            HttpRequest request = buildRequest(method, url, serverTime.getTime(), path, jsonBody);
            HttpResponse<String> response = executeRequest(request);

            return deserializeResponse(response, responseType);
        } catch (Exception e) {
            throw new ApiException(errorMessage, e);
        }
    }

    private Time getServerTime() throws ApiException {
        try {
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(apiUrl + "/time"))
                    .header("Content-Type", CONTENT_TYPE)
                    .GET()
                    .build();

            HttpResponse<String> response = executeRequest(request);
            return objectMapper.readValue(response.body(), Time.class);
        } catch (Exception e) {
            throw new ApiException("Failed to fetch server time", e);
        }
    }

    private HttpRequest buildRequest(HttpMethod method,
                                     String url,
                                     long timestamp,
                                     String path,
                                     String jsonBody) throws ApiException {
        try {
            String signature = generateSignature(timestamp, method.name(), apiPath + path, jsonBody);

            HttpRequest.Builder builder = HttpRequest.newBuilder()
                    .uri(URI.create(url))
                    .header("Content-Type", CONTENT_TYPE)
                    .header("YAYA-API-KEY", apiKey)
                    .header("YAYA-API-TIMESTAMP", String.valueOf(timestamp))
                    .header("YAYA-API-SIGN", signature);

            switch (method) {
                case GET:
                    return builder.GET().build();
                case POST:
                    return builder.POST(HttpRequest.BodyPublishers.ofString(jsonBody, StandardCharsets.UTF_8)).build();
                case PUT:
                    return builder.PUT(HttpRequest.BodyPublishers.ofString(jsonBody, StandardCharsets.UTF_8)).build();
                case DELETE:
                    return builder.DELETE().build();
                default:
                    throw new IllegalArgumentException("Unsupported HTTP method: " + method);
            }
        } catch (Exception e) {
            throw new ApiException("Failed to build request", e);
        }
    }

    private String buildUrl(String path, Map<String, String> queryParams) {
        StringBuilder url = new StringBuilder(apiUrl + path);
        if (queryParams != null && !queryParams.isEmpty()) {
            url.append('?').append(
                    queryParams.entrySet().stream()
                            .map(entry -> entry.getKey() + "=" + URLEncoder.encode(entry.getValue(), StandardCharsets.UTF_8))
                            .collect(Collectors.joining("&"))
            );
        }
        return url.toString();
    }

    private String generateSignature(long timestamp,
                                     String method,
                                     String path,
                                     String jsonBody) throws NoSuchAlgorithmException, InvalidKeyException {
        String preHashString = timestamp + method + path + jsonBody;
        Mac hmac = Mac.getInstance(HMAC_ALGORITHM);
        hmac.init(new SecretKeySpec(apiSecret.getBytes(StandardCharsets.UTF_8), HMAC_ALGORITHM));
        byte[] hash = hmac.doFinal(preHashString.getBytes(StandardCharsets.UTF_8));
        return Base64.getEncoder().encodeToString(hash);
    }

    private String serializeBody(Object body) throws JsonProcessingException {
        return body != null ? objectMapper.writeValueAsString(body) : "";
    }

    private <T> T deserializeResponse(HttpResponse<String> response, Class<T> responseType) throws IOException, ApiException {
        if (response.statusCode() < 200 || response.statusCode() >= 300) {
            ErrorResponse error = objectMapper.readValue(response.body(), ErrorResponse.class);
            throw new ApiException(error.getMessage(), response.statusCode());
        }
        return responseType != null ? objectMapper.readValue(response.body(), responseType) : null;
    }

    private HttpResponse<String> executeRequest(HttpRequest request) throws IOException, InterruptedException {
        return httpClient.send(request, HttpResponse.BodyHandlers.ofString());
    }
}


