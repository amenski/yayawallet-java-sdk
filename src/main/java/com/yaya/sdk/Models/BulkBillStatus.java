package com.yaya.sdk.Models;

import com.fasterxml.jackson.annotation.JsonProperty;

public class BulkBillStatus {
    @JsonProperty("id")
    private String ID;

    @JsonProperty("submitted_records")
    private String submittedRecords;

    @JsonProperty("imported_records")
    private String importedRecords;

    @JsonProperty("failed_records")
    private String failedRecords;

    private String status;

    @JsonProperty("created_at")
    private String createdAt;

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getSubmittedRecords() {
        return submittedRecords;
    }

    public void setSubmittedRecords(String submittedRecords) {
        this.submittedRecords = submittedRecords;
    }

    public String getImportedRecords() {
        return importedRecords;
    }

    public void setImportedRecords(String importedRecords) {
        this.importedRecords = importedRecords;
    }

    public String getFailedRecords() {
        return failedRecords;
    }

    public void setFailedRecords(String failedRecords) {
        this.failedRecords = failedRecords;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }
}
