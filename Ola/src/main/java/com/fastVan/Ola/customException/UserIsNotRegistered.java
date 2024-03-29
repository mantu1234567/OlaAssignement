package com.fastVan.Ola.customException;

public class UserIsNotRegistered extends RuntimeException {
    public UserIsNotRegistered(String s) {
        super(s);
    }
}
