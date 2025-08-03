package com.bob.springformall.dto;

import jakarta.validation.constraints.NotBlank;
import org.springframework.stereotype.Component;

@Component
public class UserRegisterRequest {

    @NotBlank
    private String email;
    @NotBlank
    private String password;

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
