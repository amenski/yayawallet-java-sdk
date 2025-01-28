package com.yaya.sdk.services;

import com.yaya.sdk.ApiRequest.ApiClient;
import com.yaya.sdk.models.ExternalAccount;
import com.yaya.sdk.models.Fee;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.net.http.HttpResponse;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutionException;

public class Transfer {

    private final ApiClient apiClient;
    private final ObjectMapper objectMapper;

    public Transfer(ApiClient apiClient) {
        this.objectMapper = new ObjectMapper();
        this.apiClient = apiClient;
    }

    public com.yaya.sdk.models.Transfer[] getTransferList() throws IOException, InterruptedException, ExecutionException, NoSuchAlgorithmException, InvalidKeyException {
        HttpResponse<String> response = apiClient.apiRequest("GET", "/transfer/", "", null);
        com.yaya.sdk.models.Transfer[] transfers = objectMapper.readValue(response.body(), com.yaya.sdk.models.Transfer[].class);
        return transfers;
    }

    public ExternalAccount externalAccountLookup(String institutionCode, String accountNumber) throws IOException, InterruptedException, ExecutionException, NoSuchAlgorithmException, InvalidKeyException {
        Map<String, Object> payload = new HashMap<>();
        payload.put("institution_code", institutionCode);
        payload.put("account_number", accountNumber);
        HttpResponse<String> response = apiClient.apiRequest("POST", "/transfer/lookup-external", "", payload);
        ExternalAccount externalAccount = objectMapper.readValue(response.body(), ExternalAccount.class);
        return externalAccount;
    }

    public Fee getTransferFee(String institutionCode, String amount) throws IOException, InterruptedException, ExecutionException, NoSuchAlgorithmException, InvalidKeyException {
        Map<String, Object> payload = new HashMap<>();
        payload.put("institution_code", institutionCode);
        payload.put("amount", amount);
        HttpResponse<String> response = apiClient.apiRequest("POST", "/transfer/fee", "", payload);
        Fee fee = objectMapper.readValue(response.body(), Fee.class);
        return fee;
    }
}