package com.project.barfinder.domain.models.view;

public class UserViewModel {
    private String userName;
    private String email;

    public UserViewModel() {
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
