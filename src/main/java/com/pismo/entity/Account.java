package com.pismo.entity;

import com.pismo.DTO.AccountDTO;

import javax.persistence.*;

@Entity(name = "Accounts")
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "Account_ID")
    private Long id;

    @Column(name = "AvailableCreditLimit")
    private Double availableCreditLimit;

    @Column(name = "AvailableWithdrawalLimit")
    private Double availableWithdrawalLimit;

    public Account() {
    }

    public Account(AccountDTO accountDTO) {
        this.availableCreditLimit = accountDTO.getAvailableCreditLimit();
        this.availableWithdrawalLimit = accountDTO.getAvailableWithdrawalLimit();
    }

    public Account(Double availableCreditLimit, Double availableWithdrawalLimit) {
        this.availableCreditLimit = availableCreditLimit;
        this.availableWithdrawalLimit = availableWithdrawalLimit;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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
