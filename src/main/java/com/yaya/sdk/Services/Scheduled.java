package com.yaya.sdk.Services;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.yaya.sdk.ApiRequest.ApiClient;
import com.yaya.sdk.Models.TransactionList;

import java.io.IOException;
import java.net.http.HttpResponse;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutionException;

public class Scheduled {
    private final ApiClient apiClient;
    private final ObjectMapper objectMapper;

    public Scheduled(ApiClient apiClient) {
        this.objectMapper = new ObjectMapper();
        this.apiClient = apiClient;
    }

    public com.yaya.sdk.Models.Scheduled create(String account_number, String amount, String reason, String recurring, String start_at, String meta_data) throws IOException, InterruptedException, ExecutionException, NoSuchAlgorithmException, InvalidKeyException {
        Map<String, Object> payload = new HashMap<>();
        payload.put("account_number", account_number);
        payload.put("amount", amount);
        payload.put("reason", reason);
        payload.put("recurring", recurring);
        payload.put("start_at", start_at);
        payload.put("meta_data", meta_data);
        HttpResponse<String> response = apiClient.apiRequest("POST", "/scheduled-payment/create", "", payload);
        com.yaya.sdk.Models.Scheduled scheduled = objectMapper.readValue(response.body(), com.yaya.sdk.Models.Scheduled.class);
        return scheduled;
    }

    public com.yaya.sdk.Models.Scheduled[] getList() throws IOException, InterruptedException, ExecutionException, NoSuchAlgorithmException, InvalidKeyException {
        HttpResponse<String> response = apiClient.apiRequest("GET", "/scheduled-payment/list", "", null);
        com.yaya.sdk.Models.Scheduled[] scheduledList = objectMapper.readValue(response.body(), com.yaya.sdk.Models.Scheduled[].class);
        return scheduledList;
    }

    public com.yaya.sdk.Models.Scheduled archive(String id) throws IOException, InterruptedException, ExecutionException, NoSuchAlgorithmException, InvalidKeyException {
        HttpResponse<String> response = apiClient.apiRequest("GET", "/scheduled-payment/archive/" + id, "", null);
        com.yaya.sdk.Models.Scheduled scheduled = objectMapper.readValue(response.body(), com.yaya.sdk.Models.Scheduled.class);
        return scheduled;
    }
}
