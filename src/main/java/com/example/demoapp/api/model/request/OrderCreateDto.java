package com.example.demoapp.api.model.request;


import lombok.*;

import java.time.Instant;
import java.util.UUID;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class OrderCreateDto {


    private UUID vehicleId;

    private UUID userId;

    private Instant receiveDate;
}
