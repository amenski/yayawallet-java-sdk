package com.yaya.sdk.models;

import com.fasterxml.jackson.annotation.JsonProperty;

public class EqubRound {
    private String id;

    private Account receiver;

    private EqubLite equb;

    private int round;

    @JsonProperty("sub_round")
    private int subRound;

    private int amount;

    @JsonProperty("due_date_time")
    private int dueDateTime;

    private EqubPayment[] payments;

    @JsonProperty("created_at_time")
    private int createdAtTime;

    @JsonProperty("is_completed")
    private boolean isCompleted;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Account getReceiver() {
        return receiver;
    }

    public void setReceiver(Account receiver) {
        this.receiver = receiver;
    }

    public EqubLite getEqub() {
        return equb;
    }

    public void setEqub(EqubLite equb) {
        this.equb = equb;
    }

    public int getRound() {
        return round;
    }

    public void setRound(int round) {
        this.round = round;
    }

    public int getSubRound() {
        return subRound;
    }

    public void setSubRound(int subRound) {
        this.subRound = subRound;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public int getDueDateTime() {
        return dueDateTime;
    }

    public void setDueDateTime(int dueDateTime) {
        this.dueDateTime = dueDateTime;
    }

    public EqubPayment[] getPayments() {
        return payments;
    }

    public void setPayments(EqubPayment[] payments) {
        this.payments = payments;
    }

    public int getCreatedAtTime() {
        return createdAtTime;
    }

    public void setCreatedAtTime(int createdAtTime) {
        this.createdAtTime = createdAtTime;
    }

    public boolean isCompleted() {
        return isCompleted;
    }

    public void setCompleted(boolean completed) {
        isCompleted = completed;
    }
}
