package com.yaya.sdk.models;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Scheduled {
    private String id;
    private Customer customer;
    @JsonProperty("receiver_institution")
    private ReceiverInstitution receiverInstitution;
    private Customer receiver;
    @JsonProperty("account_number")
    private String accountNumber;
    private Float amount;
    @JsonProperty("next_run_time")
    private long nextRunTime;
    private String status;
    @JsonProperty("recurring_type")
    private String recurringType;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public ReceiverInstitution getReceiverInstitution() {
        return receiverInstitution;
    }

    public void setReceiverInstitution(ReceiverInstitution receiverInstitution) {
        this.receiverInstitution = receiverInstitution;
    }

    public Customer getReceiver() {
        return receiver;
    }

    public void setReceiver(Customer receiver) {
        this.receiver = receiver;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public Float getAmount() {
        return amount;
    }

    public void setAmount(Float amount) {
        this.amount = amount;
    }

    public long getNextRunTime() {
        return nextRunTime;
    }

    public void setNextRunTime(long nextRunTime) {
        this.nextRunTime = nextRunTime;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getRecurringType() {
        return recurringType;
    }

    public void setRecurringType(String recurringType) {
        this.recurringType = recurringType;
    }
}
