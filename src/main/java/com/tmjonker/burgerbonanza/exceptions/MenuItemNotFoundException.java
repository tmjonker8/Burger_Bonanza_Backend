package com.tmjonker.burgerbonanza.exceptions;

public class MenuItemNotFoundException extends Exception {

    public MenuItemNotFoundException(String name) {

        super("Menu Item Not Found: " + name);
    }

    public MenuItemNotFoundException(Integer id) {

        super("Menu Item Not Found: " + id);
    }
}
