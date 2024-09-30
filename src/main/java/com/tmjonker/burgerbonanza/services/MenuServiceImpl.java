package com.tmjonker.burgerbonanza.services;

import com.tmjonker.burgerbonanza.dtos.MenuItemDTO;
import com.tmjonker.burgerbonanza.entities.menu.MenuItem;
import com.tmjonker.burgerbonanza.exceptions.MenuItemNotFoundException;
import com.tmjonker.burgerbonanza.repositories.MenuItemRepository;
import org.springframework.data.util.Streamable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MenuServiceImpl implements MenuService {

    MenuItemRepository menuItemRepository;

    public MenuServiceImpl(MenuItemRepository menuRepository) {

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

    public MenuItem addMenuItem(MenuItemDTO menuItem) {

        MenuItem mi = new MenuItem(menuItem.getCategory(), menuItem.getName(),
                menuItem.getDescription(), menuItem.getPrice(), menuItem.getImgPath());

        return menuItemRepository.save(mi);
    }

    public void deleteMenuItem(Integer id) {

        menuItemRepository.deleteById(id);
    }

    public boolean existsById(Integer id) {

        return menuItemRepository.existsById(id);
    }

    public boolean existsByName(String name) {

        return menuItemRepository.existsByName(name);
    }

    public void updateMenuItem(Integer id, MenuItem menuItem) throws MenuItemNotFoundException {

        MenuItem mi = menuItemRepository.findById(id)
                .orElseThrow(() -> new MenuItemNotFoundException(id));

        mi.setCategory(menuItem.getCategory());
        mi.setDescription(menuItem.getDescription());
        mi.setName(menuItem.getName());
        mi.setImgPath(menuItem.getImgPath());
        mi.setPrice(menuItem.getPrice());

        menuItemRepository.save(mi);
    }
}
