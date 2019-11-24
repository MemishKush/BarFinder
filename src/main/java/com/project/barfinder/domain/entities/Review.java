package com.project.barfinder.domain.entities;

import javax.persistence.*;

@Entity
@Table(name = "reviews")
public class Review extends BaseEntity {
    private User user;
    private Bar bar;
    private Integer rating;
    private String comment;

    public Review() {
    }

    @ManyToOne(cascade = CascadeType.ALL, targetEntity = User.class)
    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @ManyToOne(cascade = CascadeType.ALL, targetEntity = Bar.class)
    public Bar getBar() {
        return bar;
    }

    public void setBar(Bar bar) {
        this.bar = bar;
    }

    @Column(nullable = false)
    public Integer getRating() {
        return rating;
    }

    public void setRating(Integer rating) {
        this.rating = rating;
    }
    @Column
    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }
}
