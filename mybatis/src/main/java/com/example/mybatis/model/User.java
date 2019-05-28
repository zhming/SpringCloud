package com.example.mybatis.model;

import com.example.mybatis.enums.UserSexEnum;

import java.io.Serializable;


public class User implements Serializable {
    private static final Long serialVersionUID = 1L;
    private Long id;

    private String username;

    private String password;
    private UserSexEnum userSex;

    private String nickName;


    public User() {
        super();
    }

    public User(String username, String password, UserSexEnum userSex) {
        this.username = username;
        this.password = password;
        this.userSex = userSex;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

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

    public UserSexEnum getUserSex() {
        return userSex;
    }

    public void setUserSex(UserSexEnum userSex) {
        this.userSex = userSex;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", userSex=" + userSex +
                ", nickName='" + nickName + '\'' +
                '}';
    }
}
