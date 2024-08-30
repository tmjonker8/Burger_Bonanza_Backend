package com.tmjonker.burgerbonanza.dtos;

import com.tmjonker.burgerbonanza.entities.address.Address;
import com.tmjonker.burgerbonanza.entities.menu.MenuItem;

import java.util.List;

public class PurchaseDTO {

    private List<MenuItem> menuItems;
    private double totalPrice;
    private String username;

    private AddressDTO address;

    public PurchaseDTO(List<MenuItem> menuItems, double totalPrice, String username, AddressDTO address) {
        this.menuItems = menuItems;
        this.totalPrice = totalPrice;
        this.username = username;
        this.address = address;
    }

    public List<MenuItem> getMenuItems() {
        return menuItems;
    }

    public AddressDTO getAddress() {
        return address;
    }

    public void setAddress(AddressDTO address) {
        this.address = address;
    }

    public void setMenuItems(List<MenuItem> menuItems) {
        this.menuItems = menuItems;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
