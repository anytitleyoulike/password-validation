package com.password.validation.model;


import org.springframework.beans.factory.annotation.Required;

public class User {

    public String password;

    public User(String password) {
        this.password = password;
    }

    public User() {
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
