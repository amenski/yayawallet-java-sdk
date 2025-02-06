package com.yaya.sdk.services;

import com.yaya.sdk.client.ApiClient;
import com.yaya.sdk.config.ApiEndpoints;
import com.yaya.sdk.exceptions.SdkException;
import com.yaya.sdk.exceptions.SdkExceptionSupplier;
import com.yaya.sdk.models.Institution;

import java.util.HashMap;
import java.util.Map;

import static com.yaya.sdk.client.ApiClient.HttpMethod.POST;

public class InstitutionService {

    private final ApiClient apiClient;

    public InstitutionService(ApiClient apiClient) {
        this.apiClient = apiClient;
    }

    public Institution[] listInstitution(String country) throws SdkException {
        try {
            Map<String, Object> payload = new HashMap<>();
            payload.put("country", country);
            return apiClient.sendRequest(POST, ApiEndpoints.INSTITUTION_LIST, new HashMap<>(), payload, Institution[].class);
        } catch (SdkException e) {
            throw e;
        } catch (Exception e) {
            throw SdkExceptionSupplier.UNHANDLED_EXCEPTION.get(e.getMessage());
        }
    }
}