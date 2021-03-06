package com.project.barfinder.web.controllers;

import com.project.barfinder.domain.models.binding.SearchBarBindingModel;
import com.project.barfinder.domain.models.service.BarServiceModel;
import com.project.barfinder.domain.models.service.SearchBarServiceModel;
import com.project.barfinder.domain.models.view.BarHomeViewModel;
import com.project.barfinder.service.BarService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import java.security.Principal;
import java.util.List;
import java.util.stream.Collectors;

@Controller
public class HomeController extends BaseController {
    private final BarService barService;
    private final ModelMapper modelMapper;

    @Autowired
    public HomeController(BarService barService, ModelMapper modelMapper) {
        this.barService = barService;
        this.modelMapper = modelMapper;
    }

    @GetMapping("/")
    public ModelAndView index() {
        return super.view("index");
    }

    @GetMapping("/home")
    @PreAuthorize("isAuthenticated()")
    public ModelAndView home(ModelAndView modelAndView, SearchBarBindingModel searchBarBindingModel) {
        List<BarServiceModel> bars = this.barService.findAllBars(this.modelMapper.map(searchBarBindingModel, SearchBarServiceModel.class));
        List<BarHomeViewModel> barViewModels = bars
                .stream()
                .map(bar -> {
                    BarHomeViewModel result = this.modelMapper.map(bar, BarHomeViewModel.class);
                    result.setThumbnail(bar.getPhotos().isEmpty() ? null : bar.getPhotos().get(0));
                    return result;
                })
                .collect(Collectors.toList());
        modelAndView.addObject("bars", barViewModels);
        return super.view("/home", modelAndView);
    }
}

