package com.yaya.sdk.models;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Bill {

    @JsonProperty("client_yaya_account")
    private String clientYayaAccount;

    @JsonProperty("customer_yaya_account")
    private String customerYayaAccount;

    private Double amount;

    private String phone;

    @JsonProperty("customer_id")
    private String customerId;

    @JsonProperty("bill_id")
    private String billId;

    @JsonProperty("bill_code")
    private String billCode;

    @JsonProperty("bill_season")
    private String billSeason;

    private String cluster;

    private String description;

    private String email;

    public String getClientYayaAccount() {
        return clientYayaAccount;
    }

    public void setClientYayaAccount(String clientYayaAccount) {
        this.clientYayaAccount = clientYayaAccount;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public String getBillId() {
        return billId;
    }

    public void setBillId(String billId) {
        this.billId = billId;
    }

    public String getBillCode() {
        return billCode;
    }

    public void setBillCode(String billCode) {
        this.billCode = billCode;
    }

    public String getBillSeason() {
        return billSeason;
    }

    public void setBillSeason(String billSeason) {
        this.billSeason = billSeason;
    }

    public String getCluster() {
        return cluster;
    }

    public void setCluster(String cluster) {
        this.cluster = cluster;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
