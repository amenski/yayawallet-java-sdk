package com.yaya.sdk.Models;

import com.fasterxml.jackson.annotation.JsonProperty;

public class BillWrapper {
    private Bill[] data;

    @JsonProperty("last_page")
    private Integer lastPage;

    private Integer total;

    @JsonProperty("per_page")
    private Integer perPage;

    public Bill[] getData() {
        return data;
    }

    public void setData(Bill[] data) {
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
