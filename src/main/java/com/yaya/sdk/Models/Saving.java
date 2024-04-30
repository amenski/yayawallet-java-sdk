package com.yaya.sdk.Models;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Saving {
    @JsonProperty("saving_id")
    private String savingId;

    private int amount;

    private String currency;

    public String getSavingId() {
        return savingId;
    }

    public void setSavingId(String savingId) {
        this.savingId = savingId;
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
}
