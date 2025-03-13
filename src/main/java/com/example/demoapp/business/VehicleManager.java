package com.example.demoapp.business;


import com.example.demoapp.api.model.request.VehicleCreateDto;
import com.example.demoapp.api.model.request.VehicleUpdateDto;
import com.example.demoapp.api.model.response.VehicleResponseDto;
import com.example.demoapp.domain.Vehicle;
import com.example.demoapp.exception.NotFoundException;
import com.example.demoapp.repository.VehicleRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.UUID;

import static com.example.demoapp.api.model.constrants.ValidationMessages.VEHICLE_NOT_FOUND;

@Slf4j
@Component
@RequiredArgsConstructor
public class VehicleManager {

    private final VehicleRepository vehicleRepository;
    private final ModelMapper modelMapper ;

    public List<VehicleResponseDto> getAllVehicles() {
        List<Vehicle> allVehicles = vehicleRepository.findAllByActiveTrue();

        if (allVehicles.isEmpty()) {
            throw new NotFoundException("Hal hazırda aktiv nəqliyyat vasitəsi tapılmadı");
        }

        return allVehicles.stream()
                .map(vehicle -> modelMapper.map(vehicle, VehicleResponseDto.class))
                .toList();
    }

    public void createVehicle(VehicleCreateDto requestDto) {
        Vehicle vehicle = modelMapper.map(requestDto, Vehicle.class);
        vehicleRepository.save(vehicle);
    }

    public VehicleResponseDto updateVehicle(VehicleUpdateDto requestDto, UUID vehicleId) {

        Vehicle vehicle = vehicleRepository.findById(vehicleId).orElseThrow(()-> new NotFoundException(VEHICLE_NOT_FOUND));

        modelMapper.map(requestDto,vehicle);
        vehicleRepository.save(vehicle);
        return modelMapper.map(vehicle, VehicleResponseDto.class);
    }

    public void deleteVehicle(UUID vehicleId) {
        Vehicle vehicle = vehicleRepository.findById(vehicleId).orElseThrow(()-> new NotFoundException(VEHICLE_NOT_FOUND));
        vehicle.setActive(false);
        vehicleRepository.save(vehicle);
    }

    public boolean existsVehicle(UUID vehicleId) {
        return vehicleRepository.existsById(vehicleId);
    }

    public Vehicle getVehicleById(UUID vehicleId) {
        return vehicleRepository.findById(vehicleId).orElseThrow(() -> new NotFoundException(VEHICLE_NOT_FOUND));
    }
}
