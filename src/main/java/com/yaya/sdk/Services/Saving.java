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

public class Saving {
    private final ApiClient apiClient;
    private final ObjectMapper objectMapper;

    public Saving(ApiClient apiClient) {
        this.objectMapper = new ObjectMapper();
        this.apiClient = apiClient;
    }

    public com.yaya.sdk.Models.Saving createSaving(String amount, String action) throws IOException, InterruptedException, ExecutionException, NoSuchAlgorithmException, InvalidKeyException {
        Map<String, Object> payload = new HashMap<>();
        payload.put("amount", amount);
        payload.put("action", action);
        HttpResponse<String> response = apiClient.apiRequest("POST", "/saving/create", "", payload);
        com.yaya.sdk.Models.Saving saving = objectMapper.readValue(response.body(), com.yaya.sdk.Models.Saving.class);
        return saving;
    }

    public com.yaya.sdk.Models.Saving createSaving(String amount) throws IOException, InterruptedException, ExecutionException, NoSuchAlgorithmException, InvalidKeyException {
        Map<String, Object> payload = new HashMap<>();
        payload.put("amount", amount);
        payload.put("action", "deposit");
        HttpResponse<String> response = apiClient.apiRequest("POST", "/saving/create", "", payload);
        com.yaya.sdk.Models.Saving saving = objectMapper.readValue(response.body(), com.yaya.sdk.Models.Saving.class);
        return saving;
    }

    public com.yaya.sdk.Models.Withdrawal[] withdrawals() throws IOException, InterruptedException, ExecutionException, NoSuchAlgorithmException, InvalidKeyException {
        HttpResponse<String> response = apiClient.apiRequest("GET", "/saving/withdrawals", "", null);
        com.yaya.sdk.Models.Withdrawal[] withdrawals = objectMapper.readValue(response.body(), com.yaya.sdk.Models.Withdrawal[].class);
        return withdrawals;
    }
}
