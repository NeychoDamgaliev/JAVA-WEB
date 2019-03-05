package org.softuni.exam.domain.models.service;

import javax.validation.constraints.NotNull;

public class UserServiceModel {
    private String id;

    private String username;

    private String password;

    private String email;

    public UserServiceModel() {
    }

    @NotNull
    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @NotNull
    public String getUsername() {
        return this.username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @NotNull
    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @NotNull
    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}