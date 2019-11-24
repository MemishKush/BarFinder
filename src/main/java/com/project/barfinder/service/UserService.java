package com.project.barfinder.service;

import com.project.barfinder.domain.entities.User;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;
import java.util.Optional;

public interface UserService extends UserDetailsService {
    Optional<List<User>> findAllUsers();
}
