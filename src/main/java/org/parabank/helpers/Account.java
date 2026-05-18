package org.parabank.helpers;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Account {

    @JsonProperty("accountNumber")
    private String accountNumber;

    @JsonProperty("accountType")
    private String accountType;

    @JsonProperty("balance")
    private String balance;

    @JsonProperty("availableBalance")
    private String availableBalance;

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public String getAccountType() {
        return accountType;
    }

    public void setAccountType(String accountType) {
        this.accountType = accountType;
    }

    public String getBalance() {
        return balance;
    }

    public void setBalance(String balance) {
        this.balance = balance;
    }

    public String getAvailableBalance() {
        return availableBalance;
    }

    public void setAvailableBalance(String availableBalance) {
        this.availableBalance = availableBalance;
    }
}