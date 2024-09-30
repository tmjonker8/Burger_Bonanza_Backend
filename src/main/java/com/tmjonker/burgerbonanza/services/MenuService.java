package com.tmjonker.burgerbonanza.services;

import com.tmjonker.burgerbonanza.entities.menu.MenuItem;
import com.tmjonker.burgerbonanza.exceptions.MenuItemNotFoundException;

import java.util.List;

public interface MenuService {

    public List<MenuItem> getAllMenuItems();

    public MenuItem getMenuItemByName(String name) throws MenuItemNotFoundException;

    public MenuItem getMenuItemById(Integer id) throws MenuItemNotFoundException;

    public List<MenuItem> getMenuItemsByCategory(String category)  throws MenuItemNotFoundException;

    public MenuItem addMenuItem(MenuItem menuItem);

    public void deleteMenuItem(Integer id);

    public boolean existsById(Integer id);

    public void updateMenuItem(Integer id, MenuItem menuItem) throws MenuItemNotFoundException;
}
