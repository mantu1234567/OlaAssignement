package com.fastVan.Ola.customException;

public class ShipmentNotFoundException extends RuntimeException{
    public ShipmentNotFoundException(String Message){
        super(Message);
    }
}
