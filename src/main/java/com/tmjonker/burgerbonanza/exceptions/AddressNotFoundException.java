package com.tmjonker.burgerbonanza.exceptions;

public class AddressNotFoundException extends Exception {

    public AddressNotFoundException(String address) {

        super("Address not found: " + address);
    }
}