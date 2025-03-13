package com.example.demoapp.api.service;

import com.example.demoapp.api.model.request.UserCreateDto;
import com.example.demoapp.api.model.request.UserRequestDto;
import com.example.demoapp.api.model.response.UserResponseDto;
import com.example.demoapp.business.UserManager;
import com.example.demoapp.business.validator.UserValidator;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserManager userManager;
    private final UserValidator userValidator;

    public UserResponseDto getUserInfo(UUID userId){
        return userManager.getUserInfo(userId);
    }

    public String createNewUser(UserCreateDto request){
        userValidator.validate(request.getEmail());
        return userManager.createNewUser(request);
    }
}
