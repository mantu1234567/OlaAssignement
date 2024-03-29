package com.fastVan.Ola.controller;
import com.fastVan.Ola.DTO.ShipmentUpdate;
import com.fastVan.Ola.customException.AlreadyShipmentPurchased;
import com.fastVan.Ola.customException.ShipmentNotFoundException;
import com.fastVan.Ola.model.Shipment;
import com.fastVan.Ola.service.serviceInterface.IShipmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("Ola")
public class ShipmentController {
    @Autowired
    private IShipmentService shipmentService;

    @PostMapping(value = "/shipment")
    public Shipment createShipment(@RequestBody Shipment shipment){
        return shipmentService.createShipment(shipment);
    }

    @PatchMapping("/{shipmentId}")
    public ResponseEntity<?> updateShipment(@PathVariable Integer shipmentId,
                                            @RequestBody ShipmentUpdate shipmentUpdate) {
        shipmentService.updateShipment(shipmentId, shipmentUpdate);
        return ResponseEntity.ok().build();
    }

    @PostMapping("/{shipmentId}/buy")
    public ResponseEntity<?> buyShipment(@PathVariable Integer shipmentId) {
        try {
            String purchasedShipment = shipmentService.buyShipment(shipmentId).toString();
            return new ResponseEntity<>(purchasedShipment, HttpStatus.OK);
        } catch (ShipmentNotFoundException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        } catch (AlreadyShipmentPurchased e) {
            throw new RuntimeException(e);
        }
    }
}
