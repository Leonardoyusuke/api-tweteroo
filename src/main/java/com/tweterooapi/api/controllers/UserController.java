package com.tweterooapi.api.controllers;

import org.springframework.web.bind.annotation.RestController;

import com.tweterooapi.api.dtos.UserDTO;
import com.tweterooapi.api.models.UserModel;
import com.tweterooapi.api.services.UserService;

import jakarta.validation.Valid;

import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/users")
public class UserController {
    final UserService userService;

    UserController(UserService userService){
        this.userService = userService;
    }

    @PostMapping
    public ResponseEntity<Object> createUser(@RequestBody @Valid UserDTO body){
        Optional<UserModel> user = userService.save(body);
        if(user.isEmpty()){
           return ResponseEntity.status(HttpStatus.CONFLICT).body("User already exists");
        }
        return ResponseEntity.status(HttpStatus.CREATED).body(user);
    }

}

