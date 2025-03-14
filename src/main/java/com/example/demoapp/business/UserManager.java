package com.example.demoapp.business;

import com.example.demoapp.api.model.constrants.ValidationMessages;
import com.example.demoapp.api.model.request.UserCreateDto;
import com.example.demoapp.api.model.request.UserRequestDto;
import com.example.demoapp.api.model.response.UserResponseDto;
import com.example.demoapp.domain.Role;
import com.example.demoapp.domain.User;
import com.example.demoapp.domain.UserContact;
import com.example.demoapp.exception.CustomValidationException;
import com.example.demoapp.exception.NotFoundException;
import com.example.demoapp.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.UUID;

import static com.example.demoapp.api.model.constrants.ValidationMessages.USER_NOT_FOUND;

@Slf4j
@Component
@RequiredArgsConstructor
public class UserManager {
    private final UserRepository userRepository;
    private final RoleManager roleManager;
    private final ModelMapper modelMapper;

    public UserResponseDto getUserInfo(UUID userId) {
        User user = userRepository.findById(userId).orElseThrow(() -> new NotFoundException(USER_NOT_FOUND));
        return modelMapper.map(user, UserResponseDto.class);
    }
    public String createNewUser(UserCreateDto request) {
        User user = modelMapper.map(request, User.class);

        user.setContact(createContact(request.getPhoneNumber()));
        user.setActive(true);
        user.setRoles(getRoles(request.getRole()));
        userRepository.save(user);
        return user.getEmail();
    }

    public boolean existsByEmail(String email) {
        return userRepository.existsByEmail(email);
    }

    public boolean existsById(UUID userId) {
        return userRepository.existsById(userId);
    }

    private static UserContact createContact(String phoneNumber) {
        if (phoneNumber != null && !phoneNumber.isEmpty()) {
            return UserContact.builder().mobileNumber(phoneNumber).build();
        }
        return null;
    }

    private  List<Role>  getRoles(List<String> rolesName) {
        List<Role> allRoles = roleManager.getRoles(rolesName);
        if (allRoles.isEmpty()) {
            throw new CustomValidationException(ValidationMessages.ROLES_NOT_EMPTY_VALIDATION);
        }
        return allRoles;
    }

    public User getUserById(UUID userId) {
        return userRepository.findById(userId).orElseThrow(() -> new NotFoundException(USER_NOT_FOUND));
    }



}
