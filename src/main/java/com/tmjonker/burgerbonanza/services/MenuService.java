package com.tmjonker.burgerbonanza.services;

import com.tmjonker.burgerbonanza.entities.menu.MenuItem;
import com.tmjonker.burgerbonanza.exceptions.MenuItemNotFoundException;
import com.tmjonker.burgerbonanza.repositories.MenuItemRepository;
import org.springframework.data.util.Streamable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MenuService {

    MenuItemRepository menuItemRepository;

    public MenuService(MenuItemRepository menuRepository) {

        this.menuItemRepository = menuRepository;
    }

    public List<MenuItem> getAllMenuItems() {

        return Streamable.of(menuItemRepository.findAll()).toList();
    }

    public MenuItem getMenuItemByName(String name) throws MenuItemNotFoundException {

        return menuItemRepository.findByName(name).orElseThrow(() -> new MenuItemNotFoundException(name));
    }

    public MenuItem getMenuItemById(Integer id) throws MenuItemNotFoundException {

        return menuItemRepository.findById(id).orElseThrow(() -> new MenuItemNotFoundException(id));
    }

    public List<MenuItem> getMenuItemsByCategory(String category) throws MenuItemNotFoundException {

        return menuItemRepository.findAllByCategory(category).orElseThrow(() -> new MenuItemNotFoundException(category));
    }

    public MenuItem addMenuItem(MenuItem menuItem) {

        return menuItemRepository.save(menuItem);
    }

    public void deleteMenuItem(Integer id) {

        menuItemRepository.deleteById(id);
    }

    public boolean existsById(int id) {

        return menuItemRepository.existsById(id);
    }
}
