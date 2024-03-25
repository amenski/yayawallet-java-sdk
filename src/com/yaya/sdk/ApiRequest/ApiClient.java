package com.yaya.sdk.ApiRequest;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.charset.StandardCharsets;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.*;

import com.yaya.sdk.Models.Time;
import com.fasterxml.jackson.databind.ObjectMapper;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;

public class ApiClient {

    private static final String API_URL = System.getenv("YAYA_API_URL");
    private static final String API_PATH = System.getenv("YAYA_API_PATH");
    private static final String API_KEY = System.getenv("YAYA_API_KEY");
    private static final String API_SECRET = System.getenv("YAYA_API_SECRET");

    private final ObjectMapper objectMapper;
    private final HttpClient httpClient;

    public ApiClient() {
        this.objectMapper = new ObjectMapper();
        this.httpClient = HttpClient.newHttpClient();
    }

    public HttpResponse<String> apiRequest(String method, String path, String params, Object body)
            throws IOException, InterruptedException, NoSuchAlgorithmException, InvalidKeyException {
        String url = API_URL + path + params;
        String apiPath = API_PATH + path;

        long unixTime = getTime().getTime();
        String jsonBody = body != null ? objectMapper.writeValueAsString(body) : "";
        String signedPayload = generateSignature(unixTime, method, apiPath, jsonBody);

        HttpRequest.Builder requestBuilder = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .headers("Content-Type", "application/json",
                        "YAYA-API-KEY", API_KEY,
                        "YAYA-API-TIMESTAMP", String.valueOf(unixTime),
                        "YAYA-API-SIGN", signedPayload);
        HttpRequest request = requestBuilder.method(method, HttpRequest.BodyPublishers.noBody()).build();

        if (method.equals("POST")) {
            request = requestBuilder.method(method, HttpRequest.BodyPublishers.ofString(jsonBody, StandardCharsets.UTF_8)).build();
        }


        HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());

        if (response.statusCode() != 200 && response.statusCode() != 201) {
            throw new RuntimeException("API returned error: " + response.body());
        }

        return response;
    }

    private Time getTime() throws IOException, InterruptedException {
        String url = API_URL + "/time" ;

        HttpRequest.Builder requestBuilder = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .headers("Content-Type", "application/json");

        HttpRequest request = requestBuilder.method("GET", HttpRequest.BodyPublishers.noBody()).build();
        HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());

        if (response.statusCode() != 200 && response.statusCode() != 201) {
            throw new RuntimeException("API returned error: " + response.body());
        }

        return objectMapper.readValue(response.body(), Time.class);
    }

    private String generateSignature(long unixTime, String method, String apiPath, String jsonBody)
            throws NoSuchAlgorithmException, InvalidKeyException {
        String preHashString = String.format("%s%s%s%s", unixTime, method, apiPath, jsonBody);
        byte[] secretBytes = API_SECRET.getBytes(StandardCharsets.UTF_8);
        Mac hmac = Mac.getInstance("HmacSHA256");
        hmac.init(new SecretKeySpec(secretBytes, "HmacSHA256"));
        byte[] hash = hmac.doFinal(preHashString.getBytes(StandardCharsets.UTF_8));
        return Base64.getEncoder().encodeToString(hash);
    }
}

