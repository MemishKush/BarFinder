package com.project.barfinder.web.controllers;

import ch.qos.logback.core.joran.action.IADataForComplexProperty;
import com.project.barfinder.domain.models.binding.BarCreateBindingModel;
import com.project.barfinder.domain.models.binding.ReviewCreateBindingModel;
import com.project.barfinder.domain.models.service.BarServiceModel;
import com.project.barfinder.domain.models.service.ReviewServiceModel;
import com.project.barfinder.domain.models.service.UserServiceModel;
import com.project.barfinder.domain.models.view.ReviewViewModel;
import com.project.barfinder.domain.models.view.UserViewModel;
import com.project.barfinder.service.BarService;
import com.project.barfinder.service.ImageService;
import com.project.barfinder.service.ReviewService;
import com.project.barfinder.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import java.security.Principal;

@Controller
@RequestMapping("/bars")
public class BarController extends BaseController {
    private final ModelMapper modelMapper;
    private final UserService userService;
    private final BarService barService;
    private final ReviewService reviewService;
    private final ImageService imageService;

    @Autowired
    public BarController(ModelMapper modelMapper, UserService userService, BarService barService, ReviewService reviewService, ImageService imageService) {
        this.modelMapper = modelMapper;
        this.userService = userService;
        this.barService = barService;
        this.reviewService = reviewService;
        this.imageService = imageService;
    }

    @GetMapping("/create")
    @PreAuthorize("hasAnyAuthority('ADMIN', 'ROOT')")
    public ModelAndView create(Principal principal, ModelAndView modelAndView) {
        UserServiceModel userFromDb = this.userService.findByUsername(principal.getName());
        modelAndView.addObject("model", this.modelMapper.map(userFromDb, UserViewModel.class));
        return super.view("add-bar");
    }

    @PostMapping("/create")
    @PreAuthorize("hasAnyAuthority('ADMIN', 'ROOT')")
    public ModelAndView addProductConfirm(@ModelAttribute BarCreateBindingModel model) {
        BarServiceModel barServiceModel = this.modelMapper.map(model, BarServiceModel.class);
        barServiceModel = this.barService.addBar(barServiceModel);

        for (MultipartFile image : model.getImages()) {
            if(!image.isEmpty()) {
                this.imageService.addImage(barServiceModel.getId(), image);
            }
        }

        return super.redirect("/home");

    }

    @GetMapping("/delete/{id}")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public ModelAndView deleteBar(@PathVariable String id, ModelAndView modelAndView) {
        BarServiceModel barServiceModel = this.barService.findById(id);
        modelAndView.addObject("bar", barServiceModel);
        modelAndView.addObject("barId", id);
        return super.view("bar/delete-bar", modelAndView);
    }

    @PostMapping("/delete/{id]")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public ModelAndView deleteBarConfirm(@PathVariable String id) {
        this.barService.deleteBar(id);
        return super.redirect("/bars/all");
    }
    @GetMapping("/details/{id}")
    public ModelAndView barDetails(@PathVariable String id, ModelAndView modelAndView){
        BarServiceModel barServiceModel = this.barService.findById(id);
        modelAndView.addObject("bar",barServiceModel);
        return super.view("bar-details", modelAndView);

    }

    @PostMapping(value = "/review/{id}", produces = "application/json")
    public ResponseEntity<ReviewViewModel> reviewBar(@PathVariable String id, @RequestBody ReviewCreateBindingModel reviewCreateBindingModel, Principal principal) {
        ReviewServiceModel reviewServiceModel = this.modelMapper.map(reviewCreateBindingModel, ReviewServiceModel.class);

        if (reviewCreateBindingModel.getRating() < 0 || reviewCreateBindingModel.getRating() > 6 || reviewCreateBindingModel.getComment() == null
                && reviewCreateBindingModel.getComment().isEmpty()) {
            throw new IllegalArgumentException("Invalid Review Comment or Rating!");
        }

        reviewServiceModel = this.reviewService.addReview(
                reviewServiceModel,
                id,
                principal.getName()
        );

        return ResponseEntity.status(200).body(this.modelMapper.map(reviewServiceModel, ReviewViewModel.class));
    }
}
