package com.yaya.sdk.Models;

import com.fasterxml.jackson.annotation.JsonProperty;

public class  EqubWrapper {
    private String id;

    private Account account;

    private EqubLite equb;

    @JsonProperty("created_at")
    private String createdAt;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public EqubLite getEqub() {
        return equb;
    }

    public void setEqub(EqubLite equb) {
        this.equb = equb;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }
}
