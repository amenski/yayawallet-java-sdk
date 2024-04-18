package com.yaya.sdk.Models;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Profile {
    private String id;

    private String name;

    private String account;

    private String email;

    private String[] guardians;

    private UserOrganization organization;

    private String location;

    private Country country;

    private String phone;

    private String gender;

    private String region;

    private String currency;

    private String type;

    private String status;

    private String photoUrl;

    @JsonProperty("id_doc_front_url")
    private String idDocFrontUrl;

    @JsonProperty("id_doc_back_url")
    private String idDocBackUrl;

    @JsonProperty("id_doc_approved")
    private boolean idDocApproved;

    @JsonProperty("photo_approved")
    private boolean photoApproved;

    private int reputation;

    @JsonProperty("date_of_birth")
    private int dateOfBirth;

    @JsonProperty("created_at_time")
    private int createdAtTime;

    @JsonProperty("cause_label")
    private String causeLabel;

    @JsonProperty("balance_limit")
    private int balanceLimit;

    @JsonProperty("daily_transaction_limit")
    private int dailyTransactionLimit;

    private String fin;

    @JsonProperty("cause_required")
    private boolean causeRequired;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String[] getGuardians() {
        return guardians;
    }

    public void setGuardians(String[] guardians) {
        this.guardians = guardians;
    }

    public UserOrganization getOrganization() {
        return organization;
    }

    public void setOrganization(UserOrganization organization) {
        this.organization = organization;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getPhotoUrl() {
        return photoUrl;
    }

    public void setPhotoUrl(String photoUrl) {
        this.photoUrl = photoUrl;
    }

    public String getIdDocFrontUrl() {
        return idDocFrontUrl;
    }

    public void setIdDocFrontUrl(String idDocFrontUrl) {
        this.idDocFrontUrl = idDocFrontUrl;
    }

    public String getIdDocBackUrl() {
        return idDocBackUrl;
    }

    public void setIdDocBackUrl(String idDocBackUrl) {
        this.idDocBackUrl = idDocBackUrl;
    }

    public boolean isIdDocApproved() {
        return idDocApproved;
    }

    public void setIdDocApproved(boolean idDocApproved) {
        this.idDocApproved = idDocApproved;
    }

    public boolean isPhotoApproved() {
        return photoApproved;
    }

    public void setPhotoApproved(boolean photoApproved) {
        this.photoApproved = photoApproved;
    }

    public int getReputation() {
        return reputation;
    }

    public void setReputation(int reputation) {
        this.reputation = reputation;
    }

    public int getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(int dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public int getCreatedAtTime() {
        return createdAtTime;
    }

    public void setCreatedAtTime(int createdAtTime) {
        this.createdAtTime = createdAtTime;
    }

    public String getCauseLabel() {
        return causeLabel;
    }

    public void setCauseLabel(String causeLabel) {
        this.causeLabel = causeLabel;
    }

    public int getBalanceLimit() {
        return balanceLimit;
    }

    public void setBalanceLimit(int balanceLimit) {
        this.balanceLimit = balanceLimit;
    }

    public int getDailyTransactionLimit() {
        return dailyTransactionLimit;
    }

    public void setDailyTransactionLimit(int dailyTransactionLimit) {
        this.dailyTransactionLimit = dailyTransactionLimit;
    }

    public String getFin() {
        return fin;
    }

    public void setFin(String fin) {
        this.fin = fin;
    }

    public boolean isCauseRequired() {
        return causeRequired;
    }

    public void setCauseRequired(boolean causeRequired) {
        this.causeRequired = causeRequired;
    }
}
