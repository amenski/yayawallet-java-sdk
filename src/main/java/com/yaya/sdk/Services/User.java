package com.yaya.sdk.Services;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.yaya.sdk.ApiRequest.ApiClient;
import com.yaya.sdk.Models.Organization;
import com.yaya.sdk.Models.Profile;

import java.io.IOException;
import java.net.http.HttpResponse;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
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
}
