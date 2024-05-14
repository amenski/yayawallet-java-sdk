package com.yaya.sdk.Models;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Institution {
    private String id;
    @JsonProperty("institution_id")
    private String institutionID;
    private String code;
    private String name;
    @JsonProperty("logo_url")
    private String logoUrl;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getInstitutionID() {
        return institutionID;
    }

    public void setInstitutionID(String institutionID) {
        this.institutionID = institutionID;
    }

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
