package com.yaya.sdk.Models;

import com.fasterxml.jackson.annotation.JsonProperty;

public class QR {
    @JsonProperty("qr_image_url")
    private String qrImageUrl;
    @JsonProperty("payment_link")
    private String paymentLink;

    public String getQrImageUrl() {
        return qrImageUrl;
    }

    public void setQrImageUrl(String qrImageUrl) {
        this.qrImageUrl = qrImageUrl;
    }

    public String getPaymentLink() {
        return paymentLink;
    }

    public void setPaymentLink(String paymentLink) {
        this.paymentLink = paymentLink;
    }
}
