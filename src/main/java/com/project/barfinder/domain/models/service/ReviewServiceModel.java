package com.project.barfinder.domain.models.service;

import com.project.barfinder.domain.entities.Bar;
import com.project.barfinder.domain.entities.User;

public class ReviewServiceModel extends BaseServiceModel{
    private UserServiceModel user;
    private BarServiceModel bar;
    private Integer rating;
    private String comment;

    public ReviewServiceModel() {
    }

    public UserServiceModel getUser() {
        return user;
    }

    public void setUser(UserServiceModel user) {
        this.user = user;
    }

    public BarServiceModel getBar() {
        return bar;
    }

    public void setBar(BarServiceModel bar) {
        this.bar = bar;
    }

    public Integer getRating() {
        return rating;
    }

    public void setRating(Integer rating) {
        this.rating = rating;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }
}
