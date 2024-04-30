package com.yaya.sdk.Models;

import com.fasterxml.jackson.annotation.JsonProperty;

public class PaymentRequestAltered {
    @JsonProperty("payment_request_id")
    private String paymentRequestID;

    public String getPaymentRequestID() {
        return paymentRequestID;
    }

    public void setPaymentRequestID(String paymentRequestID) {
        this.paymentRequestID = paymentRequestID;
    }
}
