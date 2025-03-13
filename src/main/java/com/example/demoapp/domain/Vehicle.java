package com.example.demoapp.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.time.Instant;
import java.util.UUID;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

@Getter
@Setter
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "Vehicle")
public class Vehicle {

    @Id
    @Column(name = "VehicleId")
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(name = "Marka")
    private String brand;

    @Column(name = "Model")
    private String model;

    @Column(name = "Color")
    private String color;

    @Column(name = "Engine")
    private Double engine;

    @Column(name = "Mileage")
    private Long mileage;

    @Column(name = "Price")
    private Double price;

    @Column(name = "Active")
    private Boolean active = true;

    @Column(name = "CreatedAt", updatable = false)
    @CreationTimestamp
    private Instant createdAt;

    @Column(name = "UpdatedAt")
    @UpdateTimestamp
    private Instant updatedAt;


}