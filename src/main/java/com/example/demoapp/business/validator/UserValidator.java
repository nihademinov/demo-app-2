package com.example.demoapp.business.validator;


import com.example.demoapp.business.UserManager;
import com.example.demoapp.exception.AlreadyExistsException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import static com.example.demoapp.api.model.constrants.ValidationMessages.EMAIL_ALREADY_EXISTS;

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
}
