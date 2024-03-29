package com.fastVan.Ola.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Shipment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer shipmentID;
    private String senderName;
    private String senderAddress;
    private String recipientName;
    private String recipientAddress;
    private String currentLocation;
    private String status;
    @Embedded
    private Package packageDetails;

    @OneToOne(mappedBy = "shipment", cascade = CascadeType.ALL)
    private TrackingInfo trackingInfo;

    @OneToOne(mappedBy = "shipment", cascade = CascadeType.ALL)
    private PickupRequest pickupRequest;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne
    @JoinColumn(name = "driver_id")
    private Driver driver;
}
