package com.example.demoapp.api.model.response;


import lombok.*;

import java.time.Instant;
import java.util.List;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserResponseDto {

    private String email;
    private String firstName;
    private String lastName;
    private List<RoleResponseDto> roles;
    private boolean active;
    private Instant createdDate;

}
