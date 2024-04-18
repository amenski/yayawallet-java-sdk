package com.yaya.sdk.Models;

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
