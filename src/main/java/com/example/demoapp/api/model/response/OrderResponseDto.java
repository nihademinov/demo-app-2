package com.example.demoapp.api.model.response;

import com.example.demoapp.domain.User;
import com.example.demoapp.domain.Vehicle;
import lombok.*;

import java.time.Instant;
import java.util.UUID;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class OrderResponseDto {

    private UUID id;

    private VehicleResponseDto vehicle;

    private UserResponseDto user;

    private Boolean active;

    private Instant receiveDate;

    private Instant deliveryDate;
}
