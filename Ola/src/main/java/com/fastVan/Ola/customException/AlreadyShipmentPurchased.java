package com.fastVan.Ola.customException;

public class AlreadyShipmentPurchased extends Throwable {
    public AlreadyShipmentPurchased(String s) {
        super(s);
    }
}
