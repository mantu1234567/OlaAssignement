package com.fastVan.Ola.service;
import com.fastVan.Ola.DTO.QuoteRequest;
import com.fastVan.Ola.utility.NominatimClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
public class DistanceCalculator {
    @Autowired
    NominatimClient nominatimClient;

    private static final double RADIUS_OF_EARTH_KM = 6371; // Earth's radius in kilometers

    public double calculateDistance(QuoteRequest quoteRequest) {
        String city1 = quoteRequest.getOrigin();
        String city2 = quoteRequest.getDestination();
        double[] city1LatLong = nominatimClient.getCoordinates(city1);
        double[] city2LatLong = nominatimClient.getCoordinates(city2);
        double latDistance = Math.toRadians(city1LatLong[1]-city1LatLong[0]);

        double lonDistance = Math.toRadians(city2LatLong[1]-city1LatLong[0]);

        double a = Math.sin(latDistance / 2) * Math.sin(latDistance / 2) +
                Math.cos(Math.toRadians(city1LatLong[0])) * Math.cos(Math.toRadians(city2LatLong[0])) *
                        Math.sin(lonDistance / 2) * Math.sin(lonDistance / 2);

        double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));

        return RADIUS_OF_EARTH_KM * c;
    }

    public double calculatePrice(double distance) {
        double pricePerKm = 1.5; // price per kilometer
        return distance * pricePerKm;
    }
}

