package com.fastVan.Ola.customException;

public class UserAlreadyRegistered extends RuntimeException {
    public UserAlreadyRegistered(String s) {
        super(s);
    }
}
