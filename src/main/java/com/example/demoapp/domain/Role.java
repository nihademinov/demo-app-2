package com.example.demoapp.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.util.UUID;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "Role", schema = "VehicleRent")
public class Role {

    @Id
    @Column(name = "RoleId")
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(name = "RoleName", unique = true)
    private String name;
}