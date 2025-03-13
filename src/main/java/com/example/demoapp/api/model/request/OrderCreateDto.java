package com.example.demoapp.api.model.request;


import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.time.Instant;
import java.util.UUID;

import static com.example.demoapp.api.model.constrants.ValidationMessages.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class OrderCreateDto {


    @NotNull(message = ID_NOT_NULL)
    private UUID vehicleId;

    @NotNull(message = ID_NOT_NULL)
    private UUID userId;

    @NotNull(message = DATRE_NOT_NULL)
    @FutureOrPresent(message = DATRE_NOT_BE_LAST)
    private Instant receiveDate;

    @NotNull(message = DATRE_NOT_NULL)
    @FutureOrPresent(message = DATRE_NOT_BE_LAST)
    private Instant deliveryDate;
}
