package com.tweterooapi.api.controllers;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;



@RestController
@RequestMapping("/tweets")
public class TweetsController {
    @PostMapping()
    public String postTweet(@RequestBody String body) {
        //recebe userId e tweet
        // retornar status 201 (created) com id,text,user(id,username,avatar)
        return body;
    }
    
}
