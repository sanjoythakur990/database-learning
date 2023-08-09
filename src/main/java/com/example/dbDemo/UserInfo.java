package com.example.dbDemo;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="user_information")
public class UserInfo {
    @Id
    private int userId;
    @Column(name="userName")
    private String nane;
    private int age;
    @Column(name="emailValue",unique=true)
    private String email;

    public UserInfo() {
    }

    public UserInfo(int userId, String nane, int age, String email) {
        this.userId = userId;
        this.nane = nane;
        this.age = age;
        this.email = email;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getNane() {
        return nane;
    }

    public void setNane(String nane) {
        this.nane = nane;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
