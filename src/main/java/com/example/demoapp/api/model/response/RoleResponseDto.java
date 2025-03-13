package com.example.demoapp.api.model.response;


import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class RoleResponseDto {
    private String name;
    private String label;
}
