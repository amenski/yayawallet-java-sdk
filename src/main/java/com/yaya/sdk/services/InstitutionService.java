package com.yaya.sdk.services;

import com.yaya.sdk.client.ApiClient;
import com.yaya.sdk.config.ApiEndpoints;
import com.yaya.sdk.exceptions.ApiException;

import java.util.HashMap;
import java.util.Map;

import static com.yaya.sdk.client.ApiClient.HttpMethod.POST;

public class InstitutionService {

    private final ApiClient apiClient;

    public InstitutionService(ApiClient apiClient) {
        this.apiClient = apiClient;
    }

    public com.yaya.sdk.models.Institution[] listInstitution(String country) throws ApiException {
        Map<String, Object> payload = new HashMap<>();
        payload.put("country", country);
        return apiClient.sendRequest(POST, ApiEndpoints.INSTITUTION_LIST, new HashMap<>(), payload, com.yaya.sdk.models.Institution[].class, "Failed to get institutions");
    }
}