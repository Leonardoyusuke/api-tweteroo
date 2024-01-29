package com.tweterooapi.api.controllers;

import org.springframework.web.bind.annotation.RestController;

import com.tweterooapi.api.dtos.TweetsDTO;
import com.tweterooapi.api.models.TweetsModel;
import com.tweterooapi.api.services.TweetsService;

import jakarta.validation.Valid;

import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;




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

    @GetMapping()
    public ResponseEntity<List<TweetsModel>> getTweets() {
        List<TweetsModel> tweets = tweetsService.findAll();
        return ResponseEntity.status(HttpStatus.OK).body(tweets);
    }
    @GetMapping("/user/{userId}")
    public ResponseEntity<Object> getUserTweets(@PathVariable Long userId) {
        List<TweetsModel> tweets = tweetsService.findTweetsByUserid(userId);
        return ResponseEntity.status(HttpStatus.OK).body(tweets);
    }
    
    
}
