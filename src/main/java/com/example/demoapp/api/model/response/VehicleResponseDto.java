package com.example.demoapp.api.model.response;


import lombok.*;

import java.util.UUID;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class VehicleResponseDto {

    private UUID id;

    private String brand;

    private String model;

    private String color;

    private Double engine;

    private Long mileage;

    private Double price;

    private Boolean active;
}
