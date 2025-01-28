package com.yaya.sdk.models;

import com.fasterxml.jackson.annotation.JsonProperty;

public class BillAltered {
    private String id;

    @JsonProperty("client_yaya_account")
    private User clientYayaAccount;

    @JsonProperty("customer_yaya_account")
    private User customerYayaAccount;

    private Double amount;

    private Double paid;

    private Double forwarded;

    private String phone;

    private String currency;

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

    @JsonProperty("start_at")
    private String startAt;

    @JsonProperty("due_at")
    private String dueAt;

    private String email;

    private String status;

    @JsonProperty("amount_due")
    private String amountDue;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public User getClientYayaAccount() {
        return clientYayaAccount;
    }

    public void setClientYayaAccount(User clientYayaAccount) {
        this.clientYayaAccount = clientYayaAccount;
    }

    public User getCustomerYayaAccount() {
        return customerYayaAccount;
    }

    public void setCustomerYayaAccount(User customerYayaAccount) {
        this.customerYayaAccount = customerYayaAccount;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public Double getPaid() {
        return paid;
    }

    public void setPaid(Double paid) {
        this.paid = paid;
    }

    public Double getForwarded() {
        return forwarded;
    }

    public void setForwarded(Double forwarded) {
        this.forwarded = forwarded;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
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

    public String getStartAt() {
        return startAt;
    }

    public void setStartAt(String startAt) {
        this.startAt = startAt;
    }

    public String getDueAt() {
        return dueAt;
    }

    public void setDueAt(String dueAt) {
        this.dueAt = dueAt;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getAmountDue() {
        return amountDue;
    }

    public void setAmountDue(String amountDue) {
        this.amountDue = amountDue;
    }
}
