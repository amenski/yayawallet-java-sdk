package com.yaya.sdk.Models;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Country {

    private String id;

    private String name;
    @JsonProperty("phone_code")
    private String phoneCode;

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

    public String getPhoneCode() {
        return phoneCode;
    }

    public void setPhoneCode(String phoneCode) {
        this.phoneCode = phoneCode;
    }
}