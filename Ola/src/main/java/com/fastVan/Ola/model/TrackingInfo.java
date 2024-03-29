package com.fastVan.Ola.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class TrackingInfo {
    @Id
    private Integer trackingId;
    private String currentLocation;
    private String estimatedDeliveryTime;
    private String status;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="shipment_id")
    private Shipment shipment;
}