package com.yaya.sdk.services;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.yaya.sdk.models.BillAltered;
import com.yaya.sdk.models.BillWrapper;
import com.yaya.sdk.models.BulkBillStatusWrapper;

import java.io.IOException;
import java.net.http.HttpResponse;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutionException;

public class Bill {
    private final ApiClient apiClient;
    private final ObjectMapper objectMapper;

    public Bill(ApiClient apiClient) {
        this.objectMapper = new ObjectMapper();
        this.apiClient = apiClient;
    }

    public com.yaya.sdk.models.BillAltered createBill(
            String clientYayaAccount,
            String customerYayaAccount,
            String amount,
            String startAt,
            String dueAt,
            String customerId,
            String billId,
            String billCode,
            String billSeason,
            String cluster,
            String description,
            String phone,
            String email,
            String details
    ) throws IOException, InterruptedException, ExecutionException, NoSuchAlgorithmException, InvalidKeyException {
        Map<String, Object> payload = new HashMap<>();
        payload.put("client_yaya_account", clientYayaAccount);
        payload.put("customer_yaya_account", customerYayaAccount);
        payload.put("amount", amount);
        payload.put("start_at", startAt);
        payload.put("due_at", dueAt);
        payload.put("customer_id", customerId);
        payload.put("bill_id", billId);
        payload.put("bill_code", billCode);
        payload.put("bill_season", billSeason);
        payload.put("cluster", cluster);
        payload.put("description", description);
        payload.put("phone", phone);
        payload.put("email", email);
        payload.put("details", details);
        HttpResponse<String> response = apiClient.apiRequest("POST", "/bill/create", "", payload);
        com.yaya.sdk.models.BillAltered bill = objectMapper.readValue(response.body(), com.yaya.sdk.models.BillAltered.class);
        return bill;
    }

    public BulkBillStatusWrapper bulkBillStatus() throws IOException, InterruptedException, ExecutionException, NoSuchAlgorithmException, InvalidKeyException {
        HttpResponse<String> response = apiClient.apiRequest("GET", "/bulkimport/list", "", null);
        BulkBillStatusWrapper bulkBillStatus = objectMapper.readValue(response.body(), BulkBillStatusWrapper.class);
        return bulkBillStatus;
    }

    public BillAltered UpdateBill(
            String clientYayaAccount,
            String customerYayaAccount,
            String amount,
            String startAt,
            String dueAt,
            String customerId,
            String billId,
            String billCode,
            String billSeason,
            String cluster,
            String description,
            String phone,
            String email,
            String details
    ) throws IOException, InterruptedException, ExecutionException, NoSuchAlgorithmException, InvalidKeyException {
        Map<String, Object> payload = new HashMap<>();
        payload.put("client_yaya_account", clientYayaAccount);
        payload.put("customer_yaya_account", customerYayaAccount);
        payload.put("amount", amount);
        payload.put("start_at", startAt);
        payload.put("due_at", dueAt);
        payload.put("customer_id", customerId);
        payload.put("bill_id", billId);
        payload.put("bill_code", billCode);
        payload.put("bill_season", billSeason);
        payload.put("cluster", cluster);
        payload.put("description", description);
        payload.put("phone", phone);
        payload.put("email", email);
        payload.put("details", details);
        HttpResponse<String> response = apiClient.apiRequest("POST", "/bill/update/", "", payload);
        BillAltered bill = objectMapper.readValue(response.body(), BillAltered.class);
        return bill;
    }

    public BillWrapper billList(String clientYayaAccount) throws IOException, InterruptedException, ExecutionException, NoSuchAlgorithmException, InvalidKeyException {
        Map<String, Object> payload = new HashMap<>();
        payload.put("client_yaya_account", clientYayaAccount);
        HttpResponse<String> response = apiClient.apiRequest("POST", "/bill/list", "", payload);
        BillWrapper bills = objectMapper.readValue(response.body(), BillWrapper.class);
        return bills;
    }

    public com.yaya.sdk.models.Bill billFind(
            String clientYayaAccount,
            String billId
    ) throws IOException, InterruptedException, ExecutionException, NoSuchAlgorithmException, InvalidKeyException {
        Map<String, Object> payload = new HashMap<>();
        payload.put("client_yaya_account", clientYayaAccount);
        payload.put("bill_id", billId);
        HttpResponse<String> response = apiClient.apiRequest("POST", "/bill/find", "", payload);
        com.yaya.sdk.models.Bill bill = objectMapper.readValue(response.body(), com.yaya.sdk.models.Bill.class);
        return bill;
    }
}
