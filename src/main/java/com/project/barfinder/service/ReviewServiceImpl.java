package com.project.barfinder.service;

import com.project.barfinder.domain.entities.Bar;
import com.project.barfinder.domain.entities.Review;
import com.project.barfinder.domain.entities.User;
import com.project.barfinder.domain.models.service.ReviewServiceModel;
import com.project.barfinder.repository.ReviewRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReviewServiceImpl implements ReviewService {
    private final ReviewRepository reviewRepository;
    private final BarService barService;
    private final UserService userService;
    private final ModelMapper modelMapper;

    @Autowired
    public ReviewServiceImpl(ReviewRepository reviewRepository, BarService barService, UserService userService, ModelMapper modelMapper) {
        this.reviewRepository = reviewRepository;
        this.barService = barService;
        this.userService = userService;
        this.modelMapper = modelMapper;
    }

    @Override
    public ReviewServiceModel addReview(ReviewServiceModel reviewServiceModel, String barId, String username) {
        Bar bar = ((BarServiceImpl) this.barService).getBarByIdInternal(barId);
        User user = ((UserServiceImpl) this.userService).getUserByUsernameInternal(username);
        Review reviewEntity = this.modelMapper.map(reviewServiceModel, Review.class);
        reviewEntity.setBar(bar);
        reviewEntity.setUser(user);
        return this.modelMapper.map(this.reviewRepository.save(reviewEntity), ReviewServiceModel.class);
    }

    @Override
    public List<ReviewServiceModel> findAllReviews() {
        return null;
    }
}
