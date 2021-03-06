package com.project.barfinder.domain.models.binding;

import com.project.barfinder.domain.entities.Bar;
import com.project.barfinder.domain.entities.User;

public class ReviewCreateBindingModel {
    private Integer rating;
    private String comment;

    public ReviewCreateBindingModel() {
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
