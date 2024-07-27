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

public class Kyc {
    private final ApiClient apiClient;
    private final ObjectMapper objectMapper;

    public Kyc(ApiClient apiClient) {
        this.objectMapper = new ObjectMapper();
        this.apiClient = apiClient;
    }

    public com.yaya.sdk.Models.Kyc requestOtp(String fin) throws IOException, InterruptedException, ExecutionException, NoSuchAlgorithmException, InvalidKeyException {
        HttpResponse<String> response = apiClient.apiRequest("GET", "/kyc/fayda/request-otp/" + fin, "", null);
        com.yaya.sdk.Models.Kyc otp = objectMapper.readValue(response.body(), com.yaya.sdk.Models.Kyc.class);
        return otp;
    }

    public com.yaya.sdk.Models.Kyc getKycDetails(String fin, String transactionId, String otp) throws IOException, InterruptedException, ExecutionException, NoSuchAlgorithmException, InvalidKeyException {
        HttpResponse<String> response = apiClient.apiRequest("GET", "/kyc/fayda/get-kyc-details/" + fin + "/" + transactionId + "/" + otp, "", null);
        com.yaya.sdk.Models.Kyc kyc = objectMapper.readValue(response.body(), com.yaya.sdk.Models.Kyc.class);
        return kyc;
    }

    public com.yaya.sdk.Models.Kyc findByTin(String tin) throws IOException, InterruptedException, ExecutionException, NoSuchAlgorithmException, InvalidKeyException {
        HttpResponse<String> response = apiClient.apiRequest("GET", "/kyc/etrade/find-by-tin/" + tin, "", null);
        com.yaya.sdk.Models.Kyc kyc = objectMapper.readValue(response.body(), com.yaya.sdk.Models.Kyc.class);
        return kyc;
    }

    public com.yaya.sdk.Models.Kyc findByLicenseNumber(String tin, String licenseNumber) throws IOException, InterruptedException, ExecutionException, NoSuchAlgorithmException, InvalidKeyException {
        Map<String, Object> payload = new HashMap<>();
        payload.put("licenseNumber", licenseNumber);
        HttpResponse<String> response = apiClient.apiRequest("POST", "/kyc/etrade/find-by-tin/" + tin, "", payload);
        com.yaya.sdk.Models.Kyc kyc = objectMapper.readValue(response.body(), com.yaya.sdk.Models.Kyc.class);
        return kyc;
    }
}
