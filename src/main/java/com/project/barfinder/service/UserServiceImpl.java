package com.project.barfinder.service;

import com.project.barfinder.domain.entities.User;
import com.project.barfinder.domain.models.service.UserServiceModel;
import com.project.barfinder.repository.UserRepository;
import org.modelmapper.ModelMapper;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.ArrayList;
import java.util.List;

public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final ModelMapper modelMapper;

    public UserServiceImpl(UserRepository userRepository, ModelMapper modelMapper) {
        this.userRepository = userRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public UserServiceModel addUser(UserServiceModel userServiceModel) {
        return this.modelMapper.map(this.userRepository.save(this.modelMapper.map(userServiceModel, User.class)), UserServiceModel.class);
    }

    @Override
    public List<UserServiceModel> findAllUsers() {
        List<UserServiceModel> serviceModels = new ArrayList<>();
        List<User> usersFromDb = this.userRepository.findAll();
        for (User user : usersFromDb) {
            UserServiceModel mappedServiceModels = this.modelMapper.map(user, UserServiceModel.class);
            serviceModels.add(mappedServiceModels);
        }
        return serviceModels;
    }

    @Override
    public UserServiceModel findByUsername(String username) {
        return this.modelMapper.map(userRepository.findByUsername(username), UserServiceModel.class);
    }

    @Override
    public UserServiceModel findById(String id) {
        return this.modelMapper.map(userRepository.findById(id), UserServiceModel.class);
    }

    @Override
    public UserServiceModel findByEmail(String email) {
        return this.modelMapper.map(userRepository.findByEmail(email), UserServiceModel.class);
    }

    @Override
    public UserServiceModel editUser(UserServiceModel userServiceModel) {
        return this.modelMapper.map(userRepository.saveAndFlush(this.modelMapper.map(userServiceModel, User.class)), UserServiceModel.class);
    }

    @Override
    public void deleteUser(String id) {
        this.userRepository.deleteById(id);
    }

    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        return userRepository.findByUsername(userName).orElse(null);
    }
}
