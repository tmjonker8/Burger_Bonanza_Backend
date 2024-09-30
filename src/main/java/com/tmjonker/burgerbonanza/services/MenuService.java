package com.tmjonker.burgerbonanza.services;

import com.tmjonker.burgerbonanza.dtos.MenuItemDTO;
import com.tmjonker.burgerbonanza.entities.menu.MenuItem;
import com.tmjonker.burgerbonanza.exceptions.MenuItemNotFoundException;

import java.util.List;

public interface MenuService {

    List<MenuItem> getAllMenuItems();

    MenuItem getMenuItemByName(String name) throws MenuItemNotFoundException;

    MenuItem getMenuItemById(Integer id) throws MenuItemNotFoundException;

    List<MenuItem> getMenuItemsByCategory(String category)  throws MenuItemNotFoundException;

    MenuItem addMenuItem(MenuItemDTO menuItem);

    void deleteMenuItem(Integer id);

    boolean existsById(Integer id);

    boolean existsByName(String name);

    void updateMenuItem(Integer id, MenuItem menuItem) throws MenuItemNotFoundException;
}
