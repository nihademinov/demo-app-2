package com.example.demoapp.api.service;

import com.example.demoapp.api.model.request.VehicleCreateDto;
import com.example.demoapp.api.model.request.VehicleUpdateDto;
import com.example.demoapp.api.model.response.VehicleResponseDto;
import com.example.demoapp.business.VehicleManager;
import com.example.demoapp.business.validator.VehicleValidator;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class VehicleService {

    private final VehicleManager vehicleManager;
    private final VehicleValidator vehicleValidator;

    public List<VehicleResponseDto> getAllVehicles(){return vehicleManager.getAllVehicles();}

    public void createVehicle(VehicleCreateDto requestDto){
        vehicleManager.createVehicle(requestDto);
    }

    public VehicleResponseDto updateVehicle(VehicleUpdateDto requestDto, UUID vehicleId){
        return vehicleManager.updateVehicle(requestDto,vehicleId);
    }

    public void deleteVehicle(UUID vehicleId){
        vehicleValidator.validator(vehicleId);
        vehicleManager.deleteVehicle(vehicleId);
    }
}
