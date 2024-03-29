package com.fastVan.Ola.customException;

public class UnAuthenticatedActivityDetuct extends Throwable {
    public UnAuthenticatedActivityDetuct(String plzEnterValidCredential) {
        super(plzEnterValidCredential);
    }
}
