package com.project.barfinder.service;

import com.project.barfinder.domain.models.service.ReviewServiceModel;
import com.project.barfinder.repository.ReviewRepository;
import org.modelmapper.ModelMapper;

import java.util.List;

public class ReviewServiceImpl implements ReviewService {
    private final ReviewRepository reviewRepository;
    private final ModelMapper modelMapper;

    public ReviewServiceImpl(ReviewRepository reviewRepository, ModelMapper modelMapper) {
        this.reviewRepository = reviewRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public ReviewServiceModel addReview(ReviewServiceModel reviewServiceModel) {
        return null;
    }

    @Override
    public List<ReviewServiceModel> findAllReviews() {
        return null;
    }
}
