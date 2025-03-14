package com.example.demoapp.api.controller;

import com.example.demoapp.api.model.request.UserCreateDto;
import com.example.demoapp.api.model.response.UserResponseDto;
import com.example.demoapp.api.service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/api/v1/user")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping("/user/{userId}")
    public UserResponseDto getUserInfo(@PathVariable UUID userId) {
        return userService.getUserInfo(userId);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public String createNewUser(@Valid @RequestBody UserCreateDto requestDto) {
        return userService.createNewUser(requestDto);
    }


}
