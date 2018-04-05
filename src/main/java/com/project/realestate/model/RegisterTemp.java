package com.project.realestate.model;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class RegisterTemp {

    @NotEmpty
    @javax.validation.constraints.Email(message = "Email invalid")
    private String username;
    @NotEmpty
    @Min(value = 8, message = "Password of minimum length 8 characters")
    private String password;
    @NotEmpty
    @Min(value = 8, message = "Confirm Password of minimum length 8 characters")
    private String confirmPassword;

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

    public String getConfirmPassword() {
        return confirmPassword;
    }

    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
    }
}
