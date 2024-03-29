package com.fastVan.Ola.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@AllArgsConstructor
@Entity
@NoArgsConstructor
public class Quote {
    @Id
    private String quoteId = UUID.randomUUID().toString();
    private String origin;
    private String destination;
    private Package packageDetails;
    private double price;
    private String currency;
}
