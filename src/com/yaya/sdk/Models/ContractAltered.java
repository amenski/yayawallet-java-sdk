package com.yaya.sdk.Models;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ContractAltered {
    @JsonProperty("contract_id")
    private String contractID;

    public String getContractID() {
        return contractID;
    }

    public void setContractID(String contractID) {
        this.contractID = contractID;
    }
}
