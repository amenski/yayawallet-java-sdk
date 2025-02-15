package com.yaya.sdk.models;

import com.fasterxml.jackson.annotation.JsonProperty;

public class BulkBillStatusWrapper {
    private BulkBillStatus[] data;

    @JsonProperty("last_page")
    private Integer lastPage;

    private Integer total;

    @JsonProperty("per_page")
    private Integer perPage;

    public BulkBillStatus[] getData() {
        return data;
    }

    public void setData(BulkBillStatus[] data) {
        this.data = data;
    }

    public Integer getLastPage() {
        return lastPage;
    }

    public void setLastPage(Integer lastPage) {
        this.lastPage = lastPage;
    }

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }

    public Integer getPerPage() {
        return perPage;
    }

    public void setPerPage(Integer perPage) {
        this.perPage = perPage;
    }
}
