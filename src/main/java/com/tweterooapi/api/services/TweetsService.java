package com.tweterooapi.api.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.tweterooapi.api.dtos.TweetsDTO;
import com.tweterooapi.api.models.TweetsModel;
import com.tweterooapi.api.models.UserModel;
import com.tweterooapi.api.repositories.TweetsRepository;
import com.tweterooapi.api.repositories.UserRepository;


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

    public List<TweetsModel> findAll(){
        return tweetsRepository.findAll();
    }

    public List<TweetsModel> findTweetsByUserid(Long userId){
        return tweetsRepository.findTweetsByUserid(userId);
    }
  

}
