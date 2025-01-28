package com.yaya.sdk.models;

import com.fasterxml.jackson.annotation.JsonProperty;

public class PaymentMethod {

    private Institution institution;
    @JsonProperty("full_name")
    private String fullName;
    @JsonProperty("account_number")
    private String accountNumber;

    public Institution getInstitution() {
        return institution;
    }

    public void setInstitution(Institution institution) {
        this.institution = institution;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }
}