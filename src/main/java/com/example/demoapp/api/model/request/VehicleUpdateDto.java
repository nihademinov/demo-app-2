package com.example.demoapp.api.model.request;

import com.example.demoapp.api.model.constrants.ValidationMessages;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.*;


@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class VehicleUpdateDto {

    @NotBlank(message = ValidationMessages.BRAND_NOT_NULL_VALIDATION)
    @Size(min = 2, max = 64, message = ValidationMessages.BRAND_SIZE_VALIDATION)
    private String brand;

    @NotBlank(message = ValidationMessages.MODEL_NOT_NULL_VALIDATION)
    @Size(min = 2, max = 64, message = ValidationMessages.MODEL_SIZE_VALIDATION)
    private String model;

    @NotBlank(message = ValidationMessages.COLOR_NOT_NULL_VALIDATION)
    @Size(min = 1, max = 15, message = ValidationMessages.COLOR_SIZE_VALIDATION)
    private String color;

    @NotBlank(message = ValidationMessages.ENGINE_NOT_NULL_VALIDATION)
    @Min(value = 0, message = ValidationMessages.ENGINE_MIN_SIZE_VALIDATION)
    @Max(value = 16, message = ValidationMessages.ENGINE_MAX_SIZE_VALIDATION)
    private Double engine;

    @NotBlank(message = ValidationMessages.MILEAGE_NOT_NULL_VALIDATION)
    @Min(value = 0, message = ValidationMessages.MILEAGE_SIZE_VALIDATION)
    private Long mileage;

    @NotBlank(message = ValidationMessages.PRICE_NOT_NULL_VALIDATION)
    @Min(value = 0, message = ValidationMessages.PRICE_VALUE_VALIDATION)
    private Double price;
}
