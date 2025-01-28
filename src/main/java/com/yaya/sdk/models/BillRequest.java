package com.yaya.sdk.models;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class BillRequest {
    private final String clientYayaAccount;
    private final String customerYayaAccount;
    private final String amount;
    private final String startAt;
    private final String dueAt;
    private final String customerId;
    private final String billId;
    private final String billCode;
    private final String billSeason;
    private final String cluster;
    private final String description;
    private final String phone;
    private final String email;
    private final String details;

    private BillRequest(Builder builder) {
        this.clientYayaAccount = builder.clientYayaAccount;
        this.customerYayaAccount = builder.customerYayaAccount;
        this.amount = builder.amount;
        this.startAt = builder.startAt;
        this.dueAt = builder.dueAt;
        this.customerId = builder.customerId;
        this.billId = builder.billId;
        this.billCode = builder.billCode;
        this.billSeason = builder.billSeason;
        this.cluster = builder.cluster;
        this.description = builder.description;
        this.phone = builder.phone;
        this.email = builder.email;
        this.details = builder.details;
    }

    public static class Builder {
        private String clientYayaAccount;
        private String customerYayaAccount;
        private String amount;
        private String startAt;
        private String dueAt;
        private String customerId;
        private String billId;
        private String billCode;
        private String billSeason;
        private String cluster;
        private String description;
        private String phone;
        private String email;
        private String details;

        public Builder withClientYayaAccount(String clientYayaAccount) {
            this.clientYayaAccount = Objects.requireNonNull(clientYayaAccount, "clientYayaAccount cannot be null");
            return this;
        }

        public Builder withCustomerYayaAccount(String customerYayaAccount) {
            this.customerYayaAccount = customerYayaAccount;
            return this;
        }

        public Builder withAmount(String amount) {
            this.amount = amount;
            return this;
        }

        public Builder withStartAt(String startAt) {
            this.startAt = startAt;
            return this;
        }

        public Builder withDueAt(String dueAt) {
            this.dueAt = dueAt;
            return this;
        }

        public Builder withCustomerId(String customerId) {
            this.customerId = customerId;
            return this;
        }

        public Builder withBillId(String billId) {
            this.billId = billId;
            return this;
        }

        public Builder withBillCode(String billCode) {
            this.billCode = billCode;
            return this;
        }

        public Builder withBillSeason(String billSeason) {
            this.billSeason = billSeason;
            return this;
        }

        public Builder withCluster(String cluster) {
            this.cluster = cluster;
            return this;
        }

        public Builder withDescription(String description) {
            this.description = description;
            return this;
        }

        public Builder withPhone(String phone) {
            this.phone = phone;
            return this;
        }

        public Builder withEmail(String email) {
            this.email = email;
            return this;
        }

        public Builder withDetails(String details) {
            this.details = details;
            return this;
        }

        public BillRequest build() {
            return new BillRequest(this);
        }
    }

    public Map<String, Object> toPayload() {
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

        return payload;
    }
}