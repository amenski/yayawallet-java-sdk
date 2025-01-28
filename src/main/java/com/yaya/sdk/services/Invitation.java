package com.yaya.sdk.services;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.yaya.sdk.ApiRequest.ApiClient;

import java.io.IOException;
import java.net.http.HttpResponse;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutionException;

public class Invitation {

    private final ApiClient apiClient;
    private final ObjectMapper objectMapper;

    public Invitation(ApiClient apiClient) {
        this.objectMapper = new ObjectMapper();
        this.apiClient = apiClient;
    }

    public com.yaya.sdk.models.Invitation[] findByInviter() throws IOException, InterruptedException, ExecutionException, NoSuchAlgorithmException, InvalidKeyException {
        HttpResponse<String> response = apiClient.apiRequest("GET", "/invitation/find-by-inviter", "", null);
        com.yaya.sdk.models.Invitation[] invitationList = objectMapper.readValue(response.body(), com.yaya.sdk.models.Invitation[].class);
        return invitationList;
    }

    public com.yaya.sdk.models.Invitation createInvitation(String country, String phone, String amount) throws IOException, InterruptedException, ExecutionException, NoSuchAlgorithmException, InvalidKeyException {
        Map<String, Object> payload = new HashMap<>();
        payload.put("country", country);
        payload.put("phone", phone);
        payload.put("amount", amount);
        HttpResponse<String> response = apiClient.apiRequest("POST", "/invitation/create", "", payload);
        com.yaya.sdk.models.Invitation invitation = objectMapper.readValue(response.body(), com.yaya.sdk.models.Invitation.class);
        return invitation;
    }

    public com.yaya.sdk.models.Invitation verifyInvitation(String inviteHash) throws IOException, InterruptedException, ExecutionException, NoSuchAlgorithmException, InvalidKeyException {
        Map<String, Object> payload = new HashMap<>();
        payload.put("invite_hash", inviteHash);
        HttpResponse<String> response = apiClient.apiRequest("POST", "/invitation/find-by-hash", "", payload);
        com.yaya.sdk.models.Invitation invitation = objectMapper.readValue(response.body(), com.yaya.sdk.models.Invitation.class);
        return invitation;
    }

    public com.yaya.sdk.models.Invitation cancelInvitation(String inviteHash) throws IOException, InterruptedException, ExecutionException, NoSuchAlgorithmException, InvalidKeyException {
        HttpResponse<String> response = apiClient.apiRequest("DELETE", "/invitation/cancel/" + inviteHash, "", null);
        com.yaya.sdk.models.Invitation invitation = objectMapper.readValue(response.body(), com.yaya.sdk.models.Invitation.class);
        return invitation;
    }

    public com.yaya.sdk.models.Invitation getOtp(String country, String phone, String inviteHash) throws IOException, InterruptedException, ExecutionException, NoSuchAlgorithmException, InvalidKeyException {
        Map<String, Object> payload = new HashMap<>();
        payload.put("country", country);
        payload.put("phone", phone);
        payload.put("invite_hash", inviteHash);
        HttpResponse<String> response = apiClient.apiRequest("POST", "invitation/otp", "", payload);
        com.yaya.sdk.models.Invitation invitation = objectMapper.readValue(response.body(), com.yaya.sdk.models.Invitation.class);
        return invitation;
    }
}
