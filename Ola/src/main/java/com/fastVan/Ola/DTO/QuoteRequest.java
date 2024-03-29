package com.fastVan.Ola.DTO;

import com.fastVan.Ola.model.Package;
import lombok.Data;

@Data
public class QuoteRequest {
    private String origin;
    private String destination;
    private Package packageDetails;
}
