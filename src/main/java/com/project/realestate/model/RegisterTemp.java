package com.project.realestate.model;

import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.*;

public class RegisterTemp {

    @NotEmpty
    @Email(message = "Email invalid")
    private String username;
    @NotEmpty
    @Length(min = 8, max = 11, message = "Password of minimum length 8 characters and maximum length is 11 characters")
    private String password;
    @NotEmpty
    @Length(min = 8, max = 11, message = "Confirm Password of minimum length 8 characters and maximum length is 11 characters")
    private String confirmPassword;

    private boolean passwordConfirmCorrect;

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


    @AssertTrue(message = "Confirm password is not match")
    public boolean isPasswordConfirmCorrect() {
        return password != null ? password.equals(confirmPassword) : false;
    }

    public void setPasswordConfirmCorrect(boolean passwordConfirmCorrect) {
        this.passwordConfirmCorrect = passwordConfirmCorrect;
    }
}
