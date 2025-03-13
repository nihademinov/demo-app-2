package com.example.demoapp.domain;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.Instant;
import java.util.UUID;

@Getter
@Setter
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "Order")
public class Order {

    @Id
    @Column(name = "OrderId")
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @OneToOne
    @JoinColumn(name = "VehicleId")
    private Vehicle vehicle;

    @OneToOne
    @JoinColumn(name = "UserId")
    private User user;

    @Column(name = "Active")
    private Boolean active = true;

    @Column(name = "ReceiveDate")
    private Instant receiveDate;

    @Column(name = "CreatedAt", updatable = false)
    @CreationTimestamp
    private Instant createdAt;

    @Column(name = "UpdatedAt")
    @UpdateTimestamp
    private Instant updatedAt;


}
