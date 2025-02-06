package com.yaya.sdk.services;

import com.yaya.sdk.client.ApiClient;
import com.yaya.sdk.config.ApiEndpoints;
import com.yaya.sdk.exceptions.SdkException;
import com.yaya.sdk.exceptions.SdkExceptionSupplier;
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

    public BillAltered createBill(BillRequest request) throws SdkException {
        try {
            return apiClient.sendRequest(POST, ApiEndpoints.BILL_CREATE, new HashMap<>(), request.toPayload(), BillAltered.class);
        } catch (SdkException e) {
            throw e;
        } catch (Exception e) {
            throw SdkExceptionSupplier.UNHANDLED_EXCEPTION.get(e.getMessage());
        }
    }

    public BulkBillStatusWrapper bulkBillStatus() throws SdkException {
        try {
            return apiClient.sendRequest(GET, ApiEndpoints.BULK_BILL_STATUS, new HashMap<>(), null, BulkBillStatusWrapper.class);
        } catch (SdkException e) {
            throw e;
        } catch (Exception e) {
            throw SdkExceptionSupplier.UNHANDLED_EXCEPTION.get(e.getMessage());
        }
    }

    public BillAltered updateBill(BillRequest request) throws SdkException {
        try {
            return apiClient.sendRequest(POST, ApiEndpoints.BILL_UPDATE, new HashMap<>(), request.toPayload(), BillAltered.class);
        } catch (SdkException e) {
            throw e;
        } catch (Exception e) {
            throw SdkExceptionSupplier.UNHANDLED_EXCEPTION.get(e.getMessage());
        }
    }

    public BillWrapper billList(String clientYayaAccount) throws SdkException {
        try {
            Map<String, Object> payload = new HashMap<>();
            payload.put("client_yaya_account", clientYayaAccount);
            return apiClient.sendRequest(POST, ApiEndpoints.BILL_LIST, new HashMap<>(), payload, BillWrapper.class);
        } catch (SdkException e) {
            throw e;
        } catch (Exception e) {
            throw SdkExceptionSupplier.UNHANDLED_EXCEPTION.get(e.getMessage());
        }
    }

    public com.yaya.sdk.models.Bill billFind(String clientYayaAccount, String billId) throws SdkException {
        try {
            Map<String, Object> payload = new HashMap<>();
            payload.put("client_yaya_account", clientYayaAccount);
            payload.put("bill_id", billId);
            return apiClient.sendRequest(POST, ApiEndpoints.BILL_FIND, new HashMap<>(), payload, com.yaya.sdk.models.Bill.class);
        } catch (SdkException e) {
            throw e;
        } catch (Exception e) {
            throw SdkExceptionSupplier.UNHANDLED_EXCEPTION.get(e.getMessage());
        }
    }
}
