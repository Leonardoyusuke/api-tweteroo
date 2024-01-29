package com.tweterooapi.api.controllers;

import org.springframework.web.bind.annotation.RestController;

import com.tweterooapi.api.dtos.TweetsDTO;
import com.tweterooapi.api.models.TweetsModel;
import com.tweterooapi.api.services.TweetsService;
import com.tweterooapi.api.services.UserService;

import jakarta.validation.Valid;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;



@RestController
@RequestMapping("/tweets")
public class TweetsController {

    final TweetsService tweetsService;

    TweetsController(TweetsService tweetsService){
        this.tweetsService = tweetsService;
    }

    @PostMapping()
    public ResponseEntity<Optional<TweetsModel>> createTweet(@RequestBody @Valid TweetsDTO body) {
        Optional<TweetsModel> tweet = tweetsService.save(body);
        return ResponseEntity.status(HttpStatus.CREATED).body(tweet);
    }
    
}
