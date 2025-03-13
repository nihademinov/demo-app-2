package com.example.demoapp.api.controller;

import com.example.demoapp.api.model.request.UserCreateDto;
import com.example.demoapp.api.model.request.UserRequestDto;
import com.example.demoapp.api.model.response.UserResponseDto;
import com.example.demoapp.api.service.UserService;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/user")
@RequiredArgsConstructor
@SecurityRequirement(name = "Bearer Authentication")
public class UserController {

    private final UserService userService;

    @GetMapping
    public UserResponseDto getUserInfo(@RequestBody UserRequestDto request) {
        return userService.getUserInfo(request);
    }

   @PostMapping
   @ResponseStatus(HttpStatus.CREATED)
   public String createNewUser(@Valid @RequestBody UserCreateDto requestDto) {
       return userService.createNewUser(requestDto);
   }


}
