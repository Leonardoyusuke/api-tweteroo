package com.tweterooapi.api.services;

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

    public Optional <UserModel> save(UserDTO dto){
        userRepository.existsByUsername(dto.getUsername());
        if(userRepository.existsByUsername(dto.getUsername())){
            return Optional.empty();
        }
        UserModel user = new UserModel(dto);
        return Optional.of(userRepository.save(user));
        
    }

}
