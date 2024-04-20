package com.yaya.sdk.Models;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Withdrawal {
    private String id;

    private int amount;

    private String currency;

    @JsonProperty("created_at_time")
    private int createdAtTime;

    @JsonProperty("weeks_delay")
    private String weeksDelay;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public int getCreatedAtTime() {
        return createdAtTime;
    }

    public void setCreatedAtTime(int createdAtTime) {
        this.createdAtTime = createdAtTime;
    }

    public String getWeeksDelay() {
        return weeksDelay;
    }

    public void setWeeksDelay(String weeksDelay) {
        this.weeksDelay = weeksDelay;
    }
}
