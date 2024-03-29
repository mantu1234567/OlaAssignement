package com.fastVan.Ola.model;

import jakarta.persistence.Embeddable;
import jakarta.persistence.Embedded;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Embeddable
@NoArgsConstructor
public class Package {
    @Embedded
    private Dimension dimensions;
    private double actualWeight;
    private static final double DIMENSIONAL_FACTOR = 5000; // Example dimensional factor

    public Package(Dimension dimensions, double actualWeight) {
        this.dimensions = dimensions;
        this.actualWeight = actualWeight;
    }

    // Calculate dimensional weight
    public double calculateDimensionalWeight() {
        return (this.dimensions.getLength() * this.dimensions.getWidth() * this.dimensions.getHeight()) / DIMENSIONAL_FACTOR;
    }

    // Determine billing weight (higher of actual vs. dimensional)
    public double getBillingWeight() {
        double dimensionalWeight = calculateDimensionalWeight();
        return Math.max(actualWeight, dimensionalWeight);
    }

}

