package com.hsmnzaydn.user_services.model;


import com.hsmnzaydn.core_entity_lib.user.User;

public class UserDTO {
    private int userId;
    private String authorizationKey;
    private String username;
    private String password;


    public UserDTO(int userId, String authorizationKey) {
        this.userId = userId;
        this.authorizationKey = authorizationKey;
    }

    public UserDTO(int userId, String authorizationKey, String username) {
        this.userId = userId;
        this.authorizationKey = authorizationKey;
        this.username = username;
    }


    public UserDTO(int userId, String authorizationKey, String username, String password) {
        this.userId = userId;
        this.authorizationKey = authorizationKey;
        this.username = username;
        this.password = password;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getAuthorizationKey() {
        return authorizationKey;
    }

    public void setAuthorizationKey(String authorizationKey) {
        this.authorizationKey = authorizationKey;
    }

    public User getUser(){
        User user=new User();
        user.setUsername(this.username);
        user.setId(this.userId);
        user.setAuthorizationKey(this.authorizationKey);
        user.setPassword(this.password);
        return user;
    }
}
