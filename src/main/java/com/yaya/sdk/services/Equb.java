package com.yaya.sdk.services;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.yaya.sdk.ApiRequest.ApiClient;
import com.yaya.sdk.models.*;

import java.io.IOException;
import java.net.http.HttpResponse;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutionException;

public class Equb {
    private final ApiClient apiClient;
    private final ObjectMapper objectMapper;

    public Equb(ApiClient apiClient) {
        this.objectMapper = new ObjectMapper();
        this.apiClient = apiClient;
    }

    public TransactionAltered createEqub(String equbAccount, String title, String description, String location, String latitude, String longitude, String period, String amount, String privateParam) throws IOException, InterruptedException, ExecutionException, NoSuchAlgorithmException, InvalidKeyException {
        Map<String, Object> payload = new HashMap<>();
        payload.put("equb_account", equbAccount);
        payload.put("title", title);
        payload.put("description", description);
        payload.put("location", location);
        payload.put("latitude", latitude);
        payload.put("longitude", longitude);
        payload.put("period", period);
        payload.put("amount", amount);
        payload.put("private", privateParam);
        HttpResponse<String> response = apiClient.apiRequest("POST", "/equb/create", "", payload);
        TransactionAltered equb = objectMapper.readValue(response.body(), TransactionAltered.class);
        return equb;
    }

    public TransactionAltered UpdateEqub(String id, String title, String description, String location, String latitude, String longitude, String period, String amount, String privateParam) throws IOException, InterruptedException, ExecutionException, NoSuchAlgorithmException, InvalidKeyException {
        Map<String, Object> payload = new HashMap<>();
        payload.put("title", title);
        payload.put("description", description);
        payload.put("location", location);
        payload.put("latitude", latitude);
        payload.put("longitude", longitude);
        payload.put("period", period);
        payload.put("amount", amount);
        payload.put("private", privateParam);
        HttpResponse<String> response = apiClient.apiRequest("PUT", "/equb/update/" + id, "", payload);
        TransactionAltered equb = objectMapper.readValue(response.body(), TransactionAltered.class);
        return equb;
    }

    public EqubPayment[] equbPayments(String ID) throws IOException, InterruptedException, ExecutionException, NoSuchAlgorithmException, InvalidKeyException {
        HttpResponse<String> response = apiClient.apiRequest("GET", "/equb/payments/" + ID, "", null);
        EqubPayment[] equbPayments = objectMapper.readValue(response.body(), EqubPayment[].class);
        return equbPayments;
    }

    public EqubRound[] equbRoundsByID(String ID) throws IOException, InterruptedException, ExecutionException, NoSuchAlgorithmException, InvalidKeyException {
        HttpResponse<String> response = apiClient.apiRequest("GET", "/equb/rounds/" + ID, "", null);
        EqubRound[] equbRounds = objectMapper.readValue(response.body(), EqubRound[].class);
        return equbRounds;
    }

    public EqubRound[] equbRoundsByName(String name) throws IOException, InterruptedException, ExecutionException, NoSuchAlgorithmException, InvalidKeyException {
        HttpResponse<String> response = apiClient.apiRequest("GET", "/equb/rounds/by-name/" + name, "", null);
        EqubRound[] equbRounds = objectMapper.readValue(response.body(), EqubRound[].class);
        return equbRounds;
    }

    public Profile createNewRoundOfEqub() throws IOException, InterruptedException, ExecutionException, NoSuchAlgorithmException, InvalidKeyException {
        HttpResponse<String> response = apiClient.apiRequest("GET", "/user/profile", "", null);
        Profile profile = objectMapper.readValue(response.body(), Profile.class);
        return profile;
    }

    public EqubWrapper findEqubsByUser() throws IOException, InterruptedException, ExecutionException, NoSuchAlgorithmException, InvalidKeyException {
        HttpResponse<String> response = apiClient.apiRequest("GET", "/equb/find-by-user", "", null);
        EqubWrapper equb = objectMapper.readValue(response.body(), EqubWrapper.class);
        return equb;
    }

    public com.yaya.sdk.models.Equb findEqubByID(String ID) throws IOException, InterruptedException, ExecutionException, NoSuchAlgorithmException, InvalidKeyException {
        HttpResponse<String> response = apiClient.apiRequest("GET", "/equb/find/" + ID, "", null);
        com.yaya.sdk.models.Equb equb = objectMapper.readValue(response.body(), com.yaya.sdk.models.Equb.class);
        return equb;
    }

    public com.yaya.sdk.models.Equb findEqubByName(String name) throws IOException, InterruptedException, ExecutionException, NoSuchAlgorithmException, InvalidKeyException {
        HttpResponse<String> response = apiClient.apiRequest("GET", "/equb/find-by-name/" + name, "", null);
        com.yaya.sdk.models.Equb equb = objectMapper.readValue(response.body(), com.yaya.sdk.models.Equb.class);
        return equb;
    }

    public EqubWrapper[] findMembersOfEqub(String ID) throws IOException, InterruptedException, ExecutionException, NoSuchAlgorithmException, InvalidKeyException {
        HttpResponse<String> response = apiClient.apiRequest("GET", "/equb/" + ID + "/members", "", null);
        EqubWrapper[] equb = objectMapper.readValue(response.body(), EqubWrapper[].class);
        return equb;
    }
}
