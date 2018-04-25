package com.pismo.DTO;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.pismo.entity.Account;

public class AccountDTO {

    @JsonProperty("available_credit_limit")
    private Double availableCreditLimit;

    @JsonProperty("available_withdrawal_limit")
    private Double availableWithdrawalLimit;

    public AccountDTO() {
    }

    public AccountDTO(Account account) {
        this.availableCreditLimit = account.getAvailableCreditLimit();
        this.availableWithdrawalLimit = account.getAvailableWithdrawalLimit();
    }

    public AccountDTO(Double availableCreditLimit, Double availableWithdrawalLimit) {
        this.availableCreditLimit = availableCreditLimit;
        this.availableWithdrawalLimit = availableWithdrawalLimit;
    }

    public Double getAvailableCreditLimit() {
        return availableCreditLimit;
    }

    public void setAvailableCreditLimit(Double availableCreditLimit) {
        this.availableCreditLimit = availableCreditLimit;
    }

    public Double getAvailableWithdrawalLimit() {
        return availableWithdrawalLimit;
    }

    public void setAvailableWithdrawalLimit(Double availableWithdrawalLimit) {
        this.availableWithdrawalLimit = availableWithdrawalLimit;
    }
}
