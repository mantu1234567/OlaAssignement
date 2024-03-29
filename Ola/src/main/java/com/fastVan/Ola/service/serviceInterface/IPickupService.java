package com.fastVan.Ola.service.serviceInterface;
import com.fastVan.Ola.DTO.PickupConfirmationResponse;
import com.fastVan.Ola.customException.PickupAlreadyScheduled;
import com.fastVan.Ola.model.PickupRequest;
import org.springframework.stereotype.Service;

@Service
public interface IPickupService {
    PickupConfirmationResponse schedulePickup(PickupRequest pickupRequest) throws PickupAlreadyScheduled;
}
