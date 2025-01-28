package com.yaya.sdk.models;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Organization {
    @JsonProperty("org_name")
    private String orgName;

    private String owner;

    private int reputation;

    private String saved;

    public String getOrgName() {
        return orgName;
    }

    public void setOrgName(String orgName) {
        this.orgName = orgName;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public int getReputation() {
        return reputation;
    }

    public void setReputation(int reputation) {
        this.reputation = reputation;
    }

    public String getSaved() {
        return saved;
    }

    public void setSaved(String saved) {
        this.saved = saved;
    }
}
