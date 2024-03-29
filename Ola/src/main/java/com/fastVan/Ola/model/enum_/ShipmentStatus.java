package com.fastVan.Ola.model.enum_;

public enum ShipmentStatus {
    PICKUP_SCHEDULED("Pickup scheduled"),
    PURCHASED("Purchased"),
    CREATED("Created"),
    PICKED_UP("Picked Up"),
    IN_TRANSIT("In Transit"),
    OUT_FOR_DELIVERY("Out for Delivery"),
    DELIVERED("Delivered"),
    FAILED("Failed"),
    RETURNED("Returned");

    private final String status;

    ShipmentStatus(String status) {
        this.status = status;
    }
}
