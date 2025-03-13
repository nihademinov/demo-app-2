package com.example.demoapp.business.validator;


import com.example.demoapp.business.UserManager;
import com.example.demoapp.exception.AlreadyExistsException;
import com.example.demoapp.exception.NotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.UUID;

import static com.example.demoapp.api.model.constrants.ValidationMessages.EMAIL_ALREADY_EXISTS;
import static com.example.demoapp.api.model.constrants.ValidationMessages.USER_NOT_FOUND;

@Component
@RequiredArgsConstructor
public class UserValidator {

    private final UserManager userManager;

    public void validate(String email) {
        boolean exist = userManager.existsByEmail(email);
        if (exist) {
            throw new AlreadyExistsException(EMAIL_ALREADY_EXISTS);
        }
    }

    public void validateById(UUID userId) {
        boolean exist = userManager.existsById(userId);
        if (!exist) {
            throw new NotFoundException(USER_NOT_FOUND);
        }
    }
}
