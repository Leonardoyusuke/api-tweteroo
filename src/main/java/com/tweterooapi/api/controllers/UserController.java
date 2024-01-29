package com.tweterooapi.api.controllers;

import org.springframework.web.bind.annotation.RestController;

import com.tweterooapi.api.dtos.UserDTO;
import com.tweterooapi.api.models.UserModel;
import com.tweterooapi.api.repositories.UserRepository;
import com.tweterooapi.api.services.UserService;

import jakarta.validation.Valid;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
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
    public ResponseEntity<UserModel> createUser(@RequestBody @Valid UserDTO body){
        // retornar status 201 (created) com id,username e avatar
        return ResponseEntity.status(HttpStatus.CREATED).body(userService.save(body));
    }

}
