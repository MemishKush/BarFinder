package com.project.barfinder.web.controllers;

import com.project.barfinder.domain.models.binding.ReservationCreateBindingModel;
import com.project.barfinder.domain.models.service.ReservationServiceModel;
import com.project.barfinder.domain.models.view.UserViewModel;
import com.project.barfinder.service.BarService;
import com.project.barfinder.service.ReservationService;
import com.project.barfinder.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.security.Principal;

@Controller
@RequestMapping("/reservations")
public class ReservationController extends BaseController{
    private final ReservationService reservationService;
    private final ModelMapper modelMapper;
    private final UserService userService;
    private final BarService barService;
    @Autowired
    public ReservationController(ReservationService reservationService, ModelMapper modelMapper, UserService userService, BarService barService) {
        this.reservationService = reservationService;
        this.modelMapper = modelMapper;
        this.userService = userService;
        this.barService = barService;
    }
    @GetMapping("/create")
    @PreAuthorize("isAnonymous()")
    public ModelAndView create(Principal principal,ModelAndView modelAndView){
        modelAndView.addObject("model",this.modelMapper.map(this.userService.findByUsername(principal.getName()), UserViewModel.class));
        return super.view("make-reservation");
    }
    @PostMapping("creata")
    @PreAuthorize("isAnonymous()")
    public ModelAndView createConfirm(@ModelAttribute ReservationCreateBindingModel model){
        this.reservationService.addReservation(this.modelMapper.map(model, ReservationServiceModel.class));
        return super.redirect("/home");
    }
    @GetMapping("deleteId/{id}")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public ModelAndView deleteReservation(@PathVariable String id, ModelAndView modelAndView){
        ReservationServiceModel reservationServiceModel = this.reservationService.findById(id);
        modelAndView.addObject("reservation",reservationServiceModel);
        modelAndView.addObject("reservationId",id);
        return super.view("delete-reservation");
    }
}
