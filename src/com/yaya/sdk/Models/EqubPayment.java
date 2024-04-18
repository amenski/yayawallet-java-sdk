package com.yaya.sdk.Models;

import com.fasterxml.jackson.annotation.JsonProperty;

public class  EqubPayment {
    private String id;

    private Account member;

    private int amount;

    @JsonProperty("created_at")
    private String createdAt;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Account getMember() {
        return member;
    }

    public void setMember(Account member) {
        this.member = member;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }
}
