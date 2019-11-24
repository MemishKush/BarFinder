package com.project.barfinder.service;

import com.project.barfinder.domain.entities.User;
import com.project.barfinder.domain.models.service.UserServiceModel;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;
import java.util.Optional;

public interface UserService extends UserDetailsService {
    UserServiceModel addUser(UserServiceModel userServiceModel);

    List<UserServiceModel> findAllUsers();

    UserServiceModel findByUsername(String username);

    UserServiceModel findById(String id);

    UserServiceModel findByEmail(String email);

    UserServiceModel editUser(UserServiceModel userServiceModel);

    void deleteUser(String id);
}
