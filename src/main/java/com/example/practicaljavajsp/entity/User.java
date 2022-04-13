package com.example.practicaljavajsp.entity;

import com.example.practicaljavajsp.annotation.Column;
import com.example.practicaljavajsp.annotation.Id;
import com.example.practicaljavajsp.annotation.Table;

@Table
public class User {
    @Id
    @Column(name = "userName", type = "VARCHAR(50)")
    private String userName;
    @Column(name = "password", type = "TEXT")
    private String password;

    public User() {
    }

    public User(String userName, String password) {
        this.userName = userName;
        this.password = password;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
