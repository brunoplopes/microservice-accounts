package com.pismo.DTO;

import com.fasterxml.jackson.annotation.JsonProperty;

public class AccountLimitDTO {

    @JsonProperty("available_credit_limit")
    private AvailableCreditLimit availableCreditLimit;

    @JsonProperty("available_withdrawal_limit")
    private AvailableWithdrawalLimit availableWithdrawalLimit;

    public AccountLimitDTO() {
    }

    public AvailableCreditLimit getAvailableCreditLimit() {
        return availableCreditLimit;
    }

    public void setAvailableCreditLimit(AvailableCreditLimit availableCreditLimit) {
        this.availableCreditLimit = availableCreditLimit;
    }

    public AvailableWithdrawalLimit getAvailableWithdrawalLimit() {
        return availableWithdrawalLimit;
    }

    public void setAvailableWithdrawalLimit(AvailableWithdrawalLimit availableWithdrawalLimit) {
        this.availableWithdrawalLimit = availableWithdrawalLimit;
    }
}
