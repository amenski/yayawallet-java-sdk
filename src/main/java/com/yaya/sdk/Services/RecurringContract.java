package com.yaya.sdk.Services;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.yaya.sdk.ApiRequest.ApiClient;
import com.yaya.sdk.Models.*;

import java.io.IOException;
import java.net.http.HttpResponse;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutionException;

public class RecurringContract {
    private final ApiClient apiClient;
    private final ObjectMapper objectMapper;

    public RecurringContract(ApiClient apiClient) {
        this.objectMapper = new ObjectMapper();
        this.apiClient = apiClient;
    }

    public ContractAltered createContract(String contractNumber, String serviceType, String customerAccountName, String metaData) throws IOException, InterruptedException, ExecutionException, NoSuchAlgorithmException, InvalidKeyException {
        Map<String, Object> payload = new HashMap<>();
        payload.put("contract_number", contractNumber);
        payload.put("service_type", serviceType);
        payload.put("customer_account_name", customerAccountName);
        payload.put("meta_data", metaData);
        HttpResponse<String> response = apiClient.apiRequest("POST", "/recurring-contract/create", "", payload);
        ContractAltered contract = objectMapper.readValue(response.body(), ContractAltered.class);
        return contract;
    }

    public PaymentRequestAltered requestPayment(String contractNumber, String amount, String currency, String cause, String notificationUrl, String metaData) throws IOException, InterruptedException, ExecutionException, NoSuchAlgorithmException, InvalidKeyException {
        Map<String, Object> payload = new HashMap<>();
        payload.put("contract_number", contractNumber);
        payload.put("amount", amount);
        payload.put("currency", currency);
        payload.put("cause", cause);
        payload.put("notification_url", notificationUrl);
        payload.put("meta_data", metaData);
        HttpResponse<String> response = apiClient.apiRequest("POST", "/recurring-contract/request-payment", "", payload);
        PaymentRequestAltered paymentRequest = objectMapper.readValue(response.body(), PaymentRequestAltered.class);
        return paymentRequest;
    }

    public Contract getSubscriptions() throws IOException, InterruptedException, ExecutionException, NoSuchAlgorithmException, InvalidKeyException {
        HttpResponse<String> response = apiClient.apiRequest("GET", "/recurring-contract/subscriptions", "", null);
        Contract contract = objectMapper.readValue(response.body(), Contract.class);
        return contract;
    }

    public PaymentRequest[] getListOfpaymentRequests() throws IOException, InterruptedException, ExecutionException, NoSuchAlgorithmException, InvalidKeyException {
        HttpResponse<String> response = apiClient.apiRequest("GET", "/recurring-contract/payment-requests", "", null);
        PaymentRequest[] paymentRequests = objectMapper.readValue(response.body(), PaymentRequest[].class);
        return paymentRequests;
    }

    public TransactionAltered approvePaymentRequest(String ID) throws IOException, InterruptedException, ExecutionException, NoSuchAlgorithmException, InvalidKeyException {
        HttpResponse<String> response = apiClient.apiRequest("GET", "/recurring-contract/approve-payment/" + ID, "", null);
        TransactionAltered payment = objectMapper.readValue(response.body(), TransactionAltered.class);
        return payment;
    }

    public PaymentRequestAltered rejectPaymentRequest(String ID) throws IOException, InterruptedException, ExecutionException, NoSuchAlgorithmException, InvalidKeyException {
        HttpResponse<String> response = apiClient.apiRequest("GET", "/recurring-contract/reject-payment/" + ID, "", null);
        PaymentRequestAltered payment = objectMapper.readValue(response.body(), PaymentRequestAltered.class);
        return payment;
    }

    public Contract activateSubscription(String ID) throws IOException, InterruptedException, ExecutionException, NoSuchAlgorithmException, InvalidKeyException {
        HttpResponse<String> response = apiClient.apiRequest("GET", "/recurring-contract/activate/" + ID, "", null);
        Contract contract = objectMapper.readValue(response.body(), Contract.class);
        return contract;
    }

    public Contract deactivateSubscription(String ID) throws IOException, InterruptedException, ExecutionException, NoSuchAlgorithmException, InvalidKeyException {
        HttpResponse<String> response = apiClient.apiRequest("GET", "/recurring-contract/deactivate" + ID, "", null);
        Contract contract = objectMapper.readValue(response.body(), Contract.class);
        return contract;
    }
}
