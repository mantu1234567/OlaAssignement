package com.fastVan.Ola.customException;

public class PickupAlreadyScheduled extends Throwable {
    public PickupAlreadyScheduled(String s) {
        super(s);
    }
}
