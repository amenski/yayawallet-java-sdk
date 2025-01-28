package com.yaya.sdk.models;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Invitation {
    private String id;

    private String user;

    @JsonProperty("invite_by")
    private User inviteBy;

    @JsonProperty("invite_hash")
    private String inviteHash;

    private String phone;

    private Country country;

    private String otp;

    @JsonProperty("dynamic_link")
    private String dynamicLink;

    @JsonProperty("transfer_amount")
    private int transferAmount;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public User getInviteBy() {
        return inviteBy;
    }

    public void setInviteBy(User inviteBy) {
        this.inviteBy = inviteBy;
    }

    public String getInviteHash() {
        return inviteHash;
    }

    public void setInviteHash(String inviteHash) {
        this.inviteHash = inviteHash;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }

    public String getOtp() {
        return otp;
    }

    public void setOtp(String otp) {
        this.otp = otp;
    }

    public String getDynamicLink() {
        return dynamicLink;
    }

    public void setDynamicLink(String dynamicLink) {
        this.dynamicLink = dynamicLink;
    }

    public int getTransferAmount() {
        return transferAmount;
    }

    public void setTransferAmount(int transferAmount) {
        this.transferAmount = transferAmount;
    }
}
