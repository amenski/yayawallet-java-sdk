package com.yaya.sdk.Models;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Transaction {

    private String id;
    private User sender;
    private User receiver;
    @JsonProperty("amount_with_currency")
    private String amountWithCurrency;
    private Double amount;
    @JsonProperty("amount_in_base_currency")
    private Integer amountInBaseCurrency;
    private String currency;
    private String cause;
    @JsonProperty("sender_caption")
    private String senderCaption;
    @JsonProperty("receiver_caption")
    private String receiverCaption;
    @JsonProperty("created_at_time")
    private Long createdAtTime;
    @JsonProperty("is_topup")
    private boolean isTopup;
    @JsonProperty("is_outgoing_transfer")
    private boolean isOutgoingTransfer;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public User getSender() {
        return sender;
    }

    public void setSender(User sender) {
        this.sender = sender;
    }

    public User getReceiver() {
        return receiver;
    }

    public void setReceiver(User receiver) {
        this.receiver = receiver;
    }

    public String getAmountWithCurrency() {
        return amountWithCurrency;
    }

    public void setAmountWithCurrency(String amountWithCurrency) {
        this.amountWithCurrency = amountWithCurrency;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public Integer getAmountInBaseCurrency() {
        return amountInBaseCurrency;
    }

    public void setAmountInBaseCurrency(Integer amountInBaseCurrency) {
        this.amountInBaseCurrency = amountInBaseCurrency;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public String getCause() {
        return cause;
    }

    public void setCause(String cause) {
        this.cause = cause;
    }

    public String getSenderCaption() {
        return senderCaption;
    }

    public void setSenderCaption(String senderCaption) {
        this.senderCaption = senderCaption;
    }

    public String getReceiverCaption() {
        return receiverCaption;
    }

    public void setReceiverCaption(String receiverCaption) {
        this.receiverCaption = receiverCaption;
    }

    public Long getCreatedAtTime() {
        return createdAtTime;
    }

    public void setCreatedAtTime(Long createdAtTime) {
        this.createdAtTime = createdAtTime;
    }

    public boolean isTopup() {
        return isTopup;
    }

    public void setTopup(boolean topup) {
        isTopup = topup;
    }

    public boolean isOutgoingTransfer() {
        return isOutgoingTransfer;
    }

    public void setOutgoingTransfer(boolean outgoingTransfer) {
        isOutgoingTransfer = outgoingTransfer;
    }
}
