package com.project.barfinder.web.controllers;

import com.project.barfinder.domain.models.binding.UserRegisterBindingModel;
import com.project.barfinder.domain.models.service.UserServiceModel;
import com.project.barfinder.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/users")
public class UserController extends BaseController {
    private final UserService userService;
    private final ModelMapper modelMapper;
    private final BCryptPasswordEncoder encoder;

    @Autowired
    public UserController(UserService userService, ModelMapper modelMapper, BCryptPasswordEncoder encoder) {
        this.userService = userService;
        this.modelMapper = modelMapper;
        this.encoder = encoder;
    }
    @GetMapping("/register")
  //  @PreAuthorize("isAnonymous()")
    public ModelAndView register(){
        return super.view("register");
    }
    @PostMapping("/register")
   // @PreAuthorize("isAnonymous()")
    public ModelAndView registerConfirm(@ModelAttribute UserRegisterBindingModel model){
        if (!model.getPassword().equals(model.getConfirmPassword())){
            return super.view("register");
        }
        this.userService.addUser(this.modelMapper.map(model, UserServiceModel.class));
        return super.redirect("/login");
    }
    @GetMapping("/login")
    @PreAuthorize("isAnonymous()")
    public ModelAndView login(){
        return super.view("login");
    }


}
