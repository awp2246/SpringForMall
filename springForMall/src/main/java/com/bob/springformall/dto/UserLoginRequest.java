package com.bob.springformall.dto;

import jakarta.validation.constraints.NotBlank;

public class UserLoginRequest {

    @NotBlank
    String email;
    @NotBlank
    String password;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
