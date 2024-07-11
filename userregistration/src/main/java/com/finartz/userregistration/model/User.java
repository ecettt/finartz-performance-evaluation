package com.finartz.userregistration.model;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class User {

    @NotBlank
    private String username;

    @NotBlank
    private String firstname;

    @NotBlank
    private String lastname;

    @NotBlank
    @Size(min = 8, message = "Password must be at least 8 characters long")
    private String password;

    @NotBlank
    @Email
    private String email;

    // Getters and Setters
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public @NotBlank String getFirstname() {
        return firstname;
    }

    public void setFirstname(@NotBlank String firstname) {
        this.firstname = firstname;
    }

    public @NotBlank String getLastname() {
        return lastname;
    }

    public void setLastname(@NotBlank String lastname) {
        this.lastname = lastname;
    }
}
