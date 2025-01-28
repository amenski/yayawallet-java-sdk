package com.yaya.sdk.models;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ReceiverInstitution {
    private String code;
    private String name;
    @JsonProperty("logo_url")
    private String logoUrl;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLogoUrl() {
        return logoUrl;
    }

    public void setLogoUrl(String logoUrl) {
        this.logoUrl = logoUrl;
    }
}
