package com.yaya.sdk.Models;

import com.yaya.sdk.Models.Transaction;

public class TransactionList {

    private Transaction[] data;
    private Integer lastPage;

    public Transaction[] getData() {
        return data;
    }

    public void setData(Transaction[] data) {
        this.data = data;
    }

    public Integer getLastPage() {
        return lastPage;
    }

    public void setLastPage(Integer lastPage) {
        this.lastPage = lastPage;
    }
}