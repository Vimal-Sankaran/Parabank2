package org.parabank.helpers;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Credentials {

    @JsonProperty("username")
    private String username;

    @JsonProperty("password")
    private String password;

    // getters and setters

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}