package com.yaya.sdk.models;

import com.fasterxml.jackson.annotation.JsonProperty;

public class TransactionAltered {
    @JsonProperty("transaction_id")
    private String transactionID;

    public String getTransactionID() {
        return transactionID;
    }

    public void setTransactionID(String transactionID) {
        this.transactionID = transactionID;
    }
}
