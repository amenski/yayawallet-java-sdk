package Services;

import ApiRequest.ApiClient;
import Models.Fee;
import Models.QR;
import Models.TransactionList;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.net.http.HttpResponse;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutionException;

public class Transaction {

    private final ApiClient apiClient;
    private final ObjectMapper objectMapper;

    public Transaction(ApiClient apiClient) {
        this.objectMapper = new ObjectMapper();
        this.apiClient = apiClient;
    }

    public TransactionList getTransactionListByUser() throws IOException, InterruptedException, ExecutionException, NoSuchAlgorithmException, InvalidKeyException {
        HttpResponse<String> response = apiClient.apiRequest("GET", "/transaction/find-by-user", "?p=1", null);
        TransactionList transactions = objectMapper.readValue(response.body(), TransactionList.class);
        return transactions;
    }

    public Fee transactionFee(String receiver, String amount) throws IOException, InterruptedException, ExecutionException, NoSuchAlgorithmException, InvalidKeyException {
        Map<String, Object> payload = new HashMap<>();
        payload.put("receiver", receiver);
        payload.put("amount", amount);
        HttpResponse<String> response = apiClient.apiRequest("POST", "/transaction/fee", "", payload);
        Fee transactionFee = objectMapper.readValue(response.body(), Fee.class);
        return transactionFee;
    }

    public QR generateQrUrl(String amount, String cause) throws IOException, InterruptedException, ExecutionException, NoSuchAlgorithmException, InvalidKeyException {
        Map<String, Object> payload = new HashMap<>();
        payload.put("amount", amount);
        payload.put("cause", cause);
        HttpResponse<String> response = apiClient.apiRequest("POST", "/transaction/qr-generate", "", payload);
        QR qrUrl = objectMapper.readValue(response.body(), QR.class);
        return qrUrl;
    }

    public TransactionList searchTransaction(String query, String cause) throws IOException, InterruptedException, ExecutionException, NoSuchAlgorithmException, InvalidKeyException {
        Map<String, Object> payload = new HashMap<>();
        payload.put("query", query);
        HttpResponse<String> response = apiClient.apiRequest("POST", "/transaction/search", "", payload);
        TransactionList transactionList = objectMapper.readValue(response.body(), TransactionList.class);
        return transactionList;
    }

}