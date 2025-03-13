package com.example.demoapp.api.controller;


import com.example.demoapp.api.model.request.VehicleCreateDto;
import com.example.demoapp.api.model.request.VehicleUpdateDto;
import com.example.demoapp.api.model.response.VehicleResponseDto;
import com.example.demoapp.api.service.VehicleService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/vehicle")
@RequiredArgsConstructor
public class VehicleController {
    private final VehicleService vehicleService;

    @GetMapping
    public List<VehicleResponseDto> getAllVehicles() {
        return vehicleService.getAllVehicles();
    }

    @PostMapping
    public void createVehicle(@RequestBody VehicleCreateDto requestDto) {
        vehicleService.createVehicle(requestDto);
    }

    @PutMapping("/{vehicleId}")
    public VehicleResponseDto updateVehicle(@RequestBody VehicleUpdateDto requestDto, @PathVariable UUID vehicleId) {
        return vehicleService.updateVehicle(requestDto, vehicleId);
    }

    @DeleteMapping("/{vehicleId}")
    public void deleteVehicle(@PathVariable UUID vehicleId) {
        vehicleService.deleteVehicle(vehicleId);
    }
}
