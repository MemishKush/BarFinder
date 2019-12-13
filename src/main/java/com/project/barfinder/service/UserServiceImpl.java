package com.project.barfinder.service;

import com.project.barfinder.domain.entities.User;
import com.project.barfinder.domain.entities.UserRole;
import com.project.barfinder.domain.models.service.UserServiceModel;
import com.project.barfinder.repository.UserRepository;
import com.project.barfinder.repository.UserRoleRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final ModelMapper modelMapper;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;
    private final UserRoleRepository userRoleRepository;

    private static final String ROOT_USER = "Root";
    private static final String ADMIN_USER = "Admin";
    private static final String USER_USER = "User";


    @Autowired
    public UserServiceImpl(UserRepository userRepository, ModelMapper modelMapper, BCryptPasswordEncoder bCryptPasswordEncoder, UserRoleRepository userRoleRepository) {
        this.userRepository = userRepository;
        this.modelMapper = modelMapper;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
        this.userRoleRepository = userRoleRepository;
    }

    private List<UserRole> getRole(String role) {
        List<UserRole> userAuthorities = new ArrayList<>();

        userAuthorities.add(this.userRoleRepository.findByAndAuthority(role));

        return userAuthorities;
    }


    @Override
    public UserServiceModel addUser(UserServiceModel userServiceModel) {
       User entity = this.modelMapper.map(userServiceModel,User.class);
       if (this.userRepository.findAll().size() == 0){
           entity.setAuthorities(this.getRole(ROOT_USER));
       }else{
           entity.setAuthorities(this.getRole(USER_USER));
       }
       entity.setPassword(this.bCryptPasswordEncoder.encode(entity.getPassword()));
        return this.modelMapper.map(this.userRepository.saveAndFlush(entity), UserServiceModel.class);
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
