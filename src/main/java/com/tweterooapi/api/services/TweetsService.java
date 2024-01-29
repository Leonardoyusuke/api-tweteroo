package com.tweterooapi.api.services;

import java.util.Optional;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.tweterooapi.api.dtos.TweetsDTO;
import com.tweterooapi.api.models.TweetsModel;
import com.tweterooapi.api.models.UserModel;
import com.tweterooapi.api.repositories.TweetsRepository;
import com.tweterooapi.api.repositories.UserRepository;

import jakarta.validation.Valid;

@Service
public class TweetsService {
     final TweetsRepository tweetsRepository;
     final UserRepository userRepository;

     TweetsService(TweetsRepository tweetsRepository,UserRepository userRepository){
        this.tweetsRepository = tweetsRepository;
        this.userRepository = userRepository;
    }

    public Optional <TweetsModel> save(TweetsDTO dto){
        Optional <UserModel> user = userRepository.findById(dto.getUserId());
        if(user.isEmpty()){
            return Optional.empty();
        }

        TweetsModel tweet = new TweetsModel(dto, user.get());
        return Optional.of(tweetsRepository.save(tweet));
    }
  

}
