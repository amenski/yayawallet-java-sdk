package com.yaya.sdk.models;

import com.fasterxml.jackson.annotation.JsonProperty;

public class UserOrganization {
    private String name;

    @JsonProperty("tin_number")
    private String tinNumber;

    @JsonProperty("license_number")
    private String licenseNumber;

    @JsonProperty("documents_approved")
    private boolean documentsApproved;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTinNumber() {
        return tinNumber;
    }

    public void setTinNumber(String tinNumber) {
        this.tinNumber = tinNumber;
    }

    public String getLicenseNumber() {
        return licenseNumber;
    }

    public void setLicenseNumber(String licenseNumber) {
        this.licenseNumber = licenseNumber;
    }

    public boolean isDocumentsApproved() {
        return documentsApproved;
    }

    public void setDocumentsApproved(boolean documentsApproved) {
        this.documentsApproved = documentsApproved;
    }
}
