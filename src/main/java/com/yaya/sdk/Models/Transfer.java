package com.yaya.sdk.Models;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Transfer {

    private String id;
    private User user;
    private String currency;
    private Integer amount;
    @JsonProperty("payment_method")
    private PaymentMethod paymentMethod;
    private String phone;
    private String name;
    private String email;
    @JsonProperty("ref_code")
    private String refCode;
    @JsonProperty("amount_in_base_currency")
    private Integer amountInBaseCurrency;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public PaymentMethod getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(PaymentMethod paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getRefCode() {
        return refCode;
    }

    public void setRefCode(String refCode) {
        this.refCode = refCode;
    }

    public Integer getAmountInBaseCurrency() {
        return amountInBaseCurrency;
    }

    public void setAmountInBaseCurrency(Integer amountInBaseCurrency) {
        this.amountInBaseCurrency = amountInBaseCurrency;
    }
}