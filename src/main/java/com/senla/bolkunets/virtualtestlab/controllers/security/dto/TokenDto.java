package com.senla.bolkunets.virtualtestlab.controllers.security.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class TokenDto {

    private boolean success;

    @JsonProperty(value = "access-token")
    private String token;

    @JsonProperty(value = "role")
    private String userRole;

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getUserRole() {
        return userRole;
    }

    public void setUserRole(String userRole) {
        this.userRole = userRole;
    }
}
