package com.example.demoapp.api.model.request;

import com.example.demoapp.api.model.constrants.ValidationMessages;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.util.List;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserCreateDto {

    @NotBlank(message = ValidationMessages.EMAIL_NOT_NULL_VALIDATION)
    @Size(min = 5, max = 64, message = ValidationMessages.EMAIL_VALIDATION)
    @Email(message = ValidationMessages.EMAIL_FORMAT_VALIDATION)
    private String email;

    @NotBlank(message = ValidationMessages.NAME_NOT_NULL_VALIDATION)
    @Size(min = 3, max = 64, message = ValidationMessages.NAME_SIZE_VALIDATION)
    private String firstName;

    @NotBlank(message = ValidationMessages.NAME_NOT_NULL_VALIDATION)
    @Size(min = 3, max = 64, message = ValidationMessages.NAME_SIZE_VALIDATION)
    private String lastName;


    @NotBlank(message = ValidationMessages.ROLE_VALIDATION)
    @Size(min = 3, max = 64, message = ValidationMessages.ROLE_SIZE_VALIDATION)
    private List<String> role;

    @Pattern(regexp = "^\\+994\\d{9}$", message = ValidationMessages.PHONE_NUMBER_VALIDATION)
    private String phoneNumber;


}
