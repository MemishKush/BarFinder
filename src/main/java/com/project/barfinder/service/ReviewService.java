package com.project.barfinder.service;

import com.project.barfinder.domain.models.service.ReviewServiceModel;

import java.util.List;

public interface ReviewService {
    ReviewServiceModel addReview(ReviewServiceModel reviewServiceModel, String barId, String username);
    List<ReviewServiceModel> findAllReviews();
}
