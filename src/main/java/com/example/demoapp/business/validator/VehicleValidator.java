package com.example.demoapp.business.validator;

import com.example.demoapp.business.VehicleManager;
import com.example.demoapp.exception.NotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.UUID;

import static com.example.demoapp.api.model.constrants.ValidationMessages.VEHICLE_NOT_FOUND;

@Component
@RequiredArgsConstructor
public class VehicleValidator {
    private final VehicleManager vehicleManager;

    public void validator(UUID vehicleId) {
        boolean exist = vehicleManager.existsVehicle(vehicleId);
        if (!exist) {
            throw new NotFoundException(VEHICLE_NOT_FOUND);
        }
    }
}
