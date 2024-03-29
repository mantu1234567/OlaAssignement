package com.fastVan.Ola.service.serviceInterface;
import com.fastVan.Ola.DTO.ShipmentTracking;
import com.fastVan.Ola.DTO.ShipmentUpdate;
import com.fastVan.Ola.customException.AlreadyShipmentPurchased;
import com.fastVan.Ola.model.Shipment;
import org.springframework.stereotype.Service;

@Service
public interface IShipmentService {
    Shipment createShipment(Shipment shipment);

    void updateShipment(Integer shipmentId, ShipmentUpdate shipmentUpdate);
    ShipmentTracking getTrackingInfo(Integer trackingId);

    String buyShipment(Integer shipmentId) throws AlreadyShipmentPurchased;
}
