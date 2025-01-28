package com.yaya.sdk.services;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.yaya.sdk.ApiRequest.ApiClient;
import com.yaya.sdk.models.Organization;
import com.yaya.sdk.models.Profile;

import java.io.IOException;
import java.net.http.HttpResponse;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutionException;

public class User {
    private final ApiClient apiClient;
    private final ObjectMapper objectMapper;

    public User(ApiClient apiClient) {
        this.objectMapper = new ObjectMapper();
        this.apiClient = apiClient;
    }

    public Organization getOrganization() throws IOException, InterruptedException, ExecutionException, NoSuchAlgorithmException, InvalidKeyException {
        HttpResponse<String> response = apiClient.apiRequest("GET", "/user/organization", "", null);
        Organization organization = objectMapper.readValue(response.body(), Organization.class);
        return organization;
    }

    public Profile getProfile() throws IOException, InterruptedException, ExecutionException, NoSuchAlgorithmException, InvalidKeyException {
        HttpResponse<String> response = apiClient.apiRequest("GET", "/user/profile", "", null);
        Profile profile = objectMapper.readValue(response.body(), Profile.class);
        return profile;
    }

    public com.yaya.sdk.models.User searchUser(String query) throws IOException, InterruptedException, ExecutionException, NoSuchAlgorithmException, InvalidKeyException {
        Map<String, Object> payload = new HashMap<>();
        payload.put("query", query);
        HttpResponse<String> response = apiClient.apiRequest("POST", "/user/search", "", payload);
        com.yaya.sdk.models.User user = objectMapper.readValue(response.body(), com.yaya.sdk.models.User.class);
        return user;
    }

    public com.yaya.sdk.models.User getBalance() throws IOException, InterruptedException, ExecutionException, NoSuchAlgorithmException, InvalidKeyException {
        HttpResponse<String> response = apiClient.apiRequest("GET", "/user/balance", "", null);
        com.yaya.sdk.models.User balance = objectMapper.readValue(response.body(), com.yaya.sdk.models.User.class);
        return balance;
    }

    public com.yaya.sdk.models.User createCustomerUser(
            String invitationHash,
            String name,
            String email,
            String phone,
            String gender,
            String dateOfBirth,
            String region,
            String address,
            String password,
            String accountName,
            String fin,
            String photoBase64,
            String idFrontBase64,
            String idBackBase64,
            String metaData
    ) throws IOException, InterruptedException, ExecutionException, NoSuchAlgorithmException, InvalidKeyException {
        Map<String, Object> payload = new HashMap<>();
        payload.put("invitation_hash", invitationHash);
        payload.put("name", name);
        payload.put("email", email);
        payload.put("phone", phone);
        payload.put("gender", gender);
        payload.put("date_of_birth", dateOfBirth);
        payload.put("region", region);
        payload.put("address", address);
        payload.put("password", password);
        payload.put("account_name", accountName);
        payload.put("fin", fin);
        payload.put("photo_base64", photoBase64);
        payload.put("id_front_base64", idFrontBase64);
        payload.put("id_back_base64", idBackBase64);
        payload.put("meta_data", metaData);
        HttpResponse<String> response = apiClient.apiRequest("POST", "/user/register", "", payload);
        com.yaya.sdk.models.User user = objectMapper.readValue(response.body(), com.yaya.sdk.models.User.class);
        return user;
    }

    public com.yaya.sdk.models.User createBusinessUser(
            String invitationHash,
            String name,
            String email,
            String phone,
            String gender,
            String dateOfBirth,
            String region,
            String address,
            String password,
            String accountName,
            String mcc,
            String fin,
            String photoBase64,
            String idFrontBase64,
            String idBackBase64,
            String tinNumber,
            String licenseNumber,
            String tinDocBase64,
            String licenseDocBase64,
            String metaData
    ) throws IOException, InterruptedException, ExecutionException, NoSuchAlgorithmException, InvalidKeyException {
        Map<String, Object> payload = new HashMap<>();
        payload.put("invitation_hash", invitationHash);
        payload.put("name", name);
        payload.put("email", email);
        payload.put("phone", phone);
        payload.put("gender", gender);
        payload.put("date_of_birth", dateOfBirth);
        payload.put("region", region);
        payload.put("address", address);
        payload.put("password", password);
        payload.put("account_name", accountName);
        payload.put("mcc", mcc);
        payload.put("fin", fin);
        payload.put("photo_base64", photoBase64);
        payload.put("id_front_base64", idFrontBase64);
        payload.put("id_back_base64", idBackBase64);
        payload.put("tin_number", tinNumber);
        payload.put("license_number", licenseNumber);
        payload.put("tin_doc_base64", tinDocBase64);
        payload.put("license_doc_base64", licenseDocBase64);
        payload.put("meta_data", metaData);
        HttpResponse<String> response = apiClient.apiRequest("POST", "/user/register-business", "", payload);
        com.yaya.sdk.models.User user = objectMapper.readValue(response.body(), com.yaya.sdk.models.User.class);
        return user;
    }
}
