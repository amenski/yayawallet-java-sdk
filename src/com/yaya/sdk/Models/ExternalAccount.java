package com.yaya.sdk.Models;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ExternalAccount {

    private Institution institution;
    @JsonProperty("full_name")
    private String fullName;
    @JsonProperty("account_number")
    private String accountNumber;
    private String phone;
    @JsonProperty("photo_url")
    private String photoUrl;

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

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPhotoUrl() {
        return photoUrl;
    }

    public void setPhotoUrl(String photoUrl) {
        this.photoUrl = photoUrl;
    }
}