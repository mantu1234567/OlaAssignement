package com.fastVan.Ola.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PickupConfirmationResponse {
    private Integer shipmentId;
    private LocalDateTime scheduledDate;
}
