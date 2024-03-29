package com.fastVan.Ola.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Data
@Component
@AllArgsConstructor
@NoArgsConstructor
public class QuoteResponse {
    private double price;
    private String totalDistance;
    private String currency;
}
