package org.parabank.helpers;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;


public class ParabankData {

    @JsonProperty("id")
    private String id;

    @JsonProperty("customer")
    private Customer customer;

    @JsonProperty("credentials")
    private Credentials credentials;

    @JsonProperty("accounts")
    private List<Account> accounts;


    // getters and setters

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Credentials getCredentials() {
        return credentials;
    }

    public void setCredentials(Credentials credentials) {
        this.credentials = credentials;
    }

    public List<Account> getAccounts() {
        return accounts;
    }

    public void setAccounts(List<Account> accounts) {
        this.accounts = accounts;
    }
}