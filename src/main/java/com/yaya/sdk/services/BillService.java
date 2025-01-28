package com.yaya.sdk.services;

import com.yaya.sdk.client.ApiClient;
import com.yaya.sdk.config.ApiEndpoints;
import com.yaya.sdk.exceptions.ApiException;
import com.yaya.sdk.models.BillAltered;
import com.yaya.sdk.models.BillRequest;
import com.yaya.sdk.models.BillWrapper;
import com.yaya.sdk.models.BulkBillStatusWrapper;

import java.util.HashMap;
import java.util.Map;

import static com.yaya.sdk.client.ApiClient.HttpMethod.GET;
import static com.yaya.sdk.client.ApiClient.HttpMethod.POST;

public class BillService {
    private final ApiClient apiClient;

    public BillService(ApiClient apiClient) {
        this.apiClient = apiClient;
    }

    public BillAltered createBill(BillRequest request) throws ApiException {
        return apiClient.sendRequest(POST, ApiEndpoints.BILL_CREATE, new HashMap<>(), request.toPayload(), BillAltered.class, "Failed to create bill");
    }

    public BulkBillStatusWrapper bulkBillStatus() throws ApiException {
        return apiClient.sendRequest(GET, ApiEndpoints.BULK_BILL_STATUS, new HashMap<>(), null, BulkBillStatusWrapper.class, "Failed to get bulk bill status");
    }

    public BillAltered updateBill(BillRequest request) throws ApiException {
        return apiClient.sendRequest(POST, ApiEndpoints.BILL_UPDATE, new HashMap<>(), request.toPayload(), BillAltered.class, "Failed to update bill");
    }

    public BillWrapper billList(String clientYayaAccount) throws ApiException {
        Map<String, Object> payload = new HashMap<>();
        payload.put("client_yaya_account", clientYayaAccount);
        return apiClient.sendRequest(POST, ApiEndpoints.BILL_LIST, new HashMap<>(), payload, BillWrapper.class, "Failed to list bills");
    }

    public com.yaya.sdk.models.Bill billFind(String clientYayaAccount, String billId) throws ApiException {
        Map<String, Object> payload = new HashMap<>();
        payload.put("client_yaya_account", clientYayaAccount);
        payload.put("bill_id", billId);
        return apiClient.sendRequest(POST, ApiEndpoints.BILL_FIND, new HashMap<>(), payload, com.yaya.sdk.models.Bill.class, "Failed to find bill");
    }
}
