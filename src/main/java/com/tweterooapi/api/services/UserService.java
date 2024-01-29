package com.tweterooapi.api.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.tweterooapi.api.dtos.UserDTO;
import com.tweterooapi.api.models.UserModel;
import com.tweterooapi.api.repositories.UserRepository;

@Service
public class UserService {
    
    final UserRepository userRepository;

    UserService(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    public UserModel save(UserDTO dto){
        UserModel user = new UserModel(dto);
        return userRepository.save(user);
        
    }

}
