package com.fastVan.Ola.model.enum_;

import lombok.Getter;


@Getter
public enum Role {
    ADMIN("ADMIN"),
    DRIVER("DRIVER"),
    CUSTOMER("CUSTOMER");

    private final String role;

    Role(String role) {
        this.role = role;
    }

}

