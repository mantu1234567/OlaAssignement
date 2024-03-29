package com.fastVan.Ola.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class PickupRequest {
    @Id
    private Integer shipmentId;
    private LocalDateTime pickupDate;
    private String location;
    private String specialInstructions;

    @OneToOne
    @JoinColumn(name="shipment_id")
    private Shipment shipment;
}
