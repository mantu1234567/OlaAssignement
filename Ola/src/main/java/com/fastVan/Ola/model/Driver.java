package com.fastVan.Ola.model;

import com.fastVan.Ola.model.enum_.VehicleType;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "drivers")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Driver {

    @Id
    private Long id; // This ID should match the User ID for simplicity in a one-to-one mapping.

    @OneToOne
    @MapsId
    private User user;
    @Enumerated(EnumType.STRING)
    private VehicleType vehicleType;

}

