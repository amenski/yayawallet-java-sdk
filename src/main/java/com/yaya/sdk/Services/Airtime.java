package com.yaya.sdk.Services;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.yaya.sdk.ApiRequest.ApiClient;

import java.io.IOException;
import java.net.http.HttpResponse;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutionException;

public class Airtime {
    private final ApiClient apiClient;
    private final ObjectMapper objectMapper;

    public Airtime(ApiClient apiClient) {
        this.objectMapper = new ObjectMapper();
        this.apiClient = apiClient;
    }

    public com.yaya.sdk.Models.Airtime buyAirtime(String phone, String amount) throws IOException, InterruptedException, ExecutionException, NoSuchAlgorithmException, InvalidKeyException {
        Map<String, Object> payload = new HashMap<>();
        payload.put("phone", phone);
        payload.put("amount", amount);
        HttpResponse<String> response = apiClient.apiRequest("POST", "/airtime/buy", "", payload);
        com.yaya.sdk.Models.Airtime airtime = objectMapper.readValue(response.body(), com.yaya.sdk.Models.Airtime.class);
        return airtime;
    }

    public com.yaya.sdk.Models.Airtime[] listRecharges() throws IOException, InterruptedException, ExecutionException, NoSuchAlgorithmException, InvalidKeyException {
        HttpResponse<String> response = apiClient.apiRequest("GET", "/airtime/", "", null);
        com.yaya.sdk.Models.Airtime[] airtimes = objectMapper.readValue(response.body(), com.yaya.sdk.Models.Airtime[].class);
        return airtimes;
    }

    public com.yaya.sdk.Models.Airtime buyPackage(String phone, String packageCode) throws IOException, InterruptedException, ExecutionException, NoSuchAlgorithmException, InvalidKeyException {
        Map<String, Object> payload = new HashMap<>();
        payload.put("phone", phone);
        payload.put("package", packageCode);
        HttpResponse<String> response = apiClient.apiRequest("POST", "/airtime/buy", "", payload);
        com.yaya.sdk.Models.Airtime airtime = objectMapper.readValue(response.body(), com.yaya.sdk.Models.Airtime.class);
        return airtime;
    }

    public com.yaya.sdk.Models.Package[] listPackages(String phone) throws IOException, InterruptedException, ExecutionException, NoSuchAlgorithmException, InvalidKeyException {
        Map<String, Object> payload = new HashMap<>();
        payload.put("phone", phone);
        HttpResponse<String> response = apiClient.apiRequest("POST", "/airtime/packages", "", payload);
        com.yaya.sdk.Models.Package[] packages = objectMapper.readValue(response.body(), com.yaya.sdk.Models.Package[].class);
        return packages;
    }
}
