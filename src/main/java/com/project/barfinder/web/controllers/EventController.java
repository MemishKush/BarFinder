package com.project.barfinder.web.controllers;

import com.project.barfinder.domain.models.binding.EventCreateBindingModel;
import com.project.barfinder.domain.models.service.EventServiceModel;
import com.project.barfinder.domain.models.view.EventViewModel;
import com.project.barfinder.domain.models.view.UserViewModel;
import com.project.barfinder.service.EventService;
import com.project.barfinder.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.security.Principal;
import java.util.List;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/events")
public class EventController extends BaseController {
    private final EventService eventService;
    private final ModelMapper modelMapper;
    private final UserService userService;

    @Autowired
    public EventController(EventService eventService, ModelMapper modelMapper, UserService userService) {
        this.eventService = eventService;
        this.modelMapper = modelMapper;
        this.userService = userService;
    }

    @GetMapping("/create")
    @PreAuthorize("isAuthenticated()")
    public ModelAndView create(Principal principal, ModelAndView modelAndView) {
        modelAndView.addObject("model", this.modelMapper.map(this.userService.findByUsername(principal.getName()),
                UserViewModel.class));

        return super.view("event/create-event");
    }

    @PostMapping
    @PreAuthorize("isAuthenticated()")
    public ModelAndView createConfirm(@ModelAttribute EventCreateBindingModel model) {
        this.eventService.addEvent(this.modelMapper.map(model, EventServiceModel.class));
        return super.redirect("/home");
    }

    @GetMapping("/all")
    @PreAuthorize("isAuthenticated()")
    public ModelAndView showAll(ModelAndView modelAndView) {
        List<EventServiceModel> events = this.eventService.findAllEvents().stream().map(e -> this.modelMapper.map(e, EventServiceModel.class))
                .collect(Collectors.toList());
        modelAndView.addObject("events", events);
        return super.view("event/all-events", modelAndView);
    }

    @GetMapping("/information/{id}")
    @PreAuthorize("isAuthenticated()")
    public ModelAndView eventInformation(@PathVariable String id, ModelAndView modelAndView){
        modelAndView.addObject("event",this.modelMapper.map(this.eventService.findById(id), EventViewModel.class));
        return super.view("event/event-information",modelAndView);
    }
    @GetMapping("/delete/{id}")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public ModelAndView deleteEvent(@PathVariable String id, ModelAndView modelAndView){
        EventServiceModel eventServiceModel = this.eventService.findById(id);
        modelAndView.addObject("event",eventServiceModel);
        modelAndView.addObject("eventId",id);
        return super.view("event/delete-event", modelAndView);

    }

}
