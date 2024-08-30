package com.tmjonker.burgerbonanza.dtos;

import com.tmjonker.burgerbonanza.entities.menu.MenuItem;

import java.util.List;

public class CartDTO {

    private int numItems;

    private List<MenuItem> menuItems;

    public CartDTO(int numItems, List<MenuItem> menuItems) {
        this.numItems = numItems;
        this.menuItems = menuItems;
    }

    public int getNumItems() {
        return numItems;
    }

    public void setNumItems(int numItems) {
        this.numItems = numItems;
    }

    public List<MenuItem> getMenuItems() {
        return menuItems;
    }

    public void setMenuItems(List<MenuItem> menuItems) {
        this.menuItems = menuItems;
    }
}
