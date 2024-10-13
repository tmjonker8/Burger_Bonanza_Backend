package com.tmjonker.burgerbonanza.controllers;

import com.tmjonker.burgerbonanza.dtos.MenuItemDTO;
import com.tmjonker.burgerbonanza.entities.menu.MenuItem;
import com.tmjonker.burgerbonanza.services.MenuService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class MenuController {

    MenuService menuService;

    public MenuController(MenuService menuService) {

        this.menuService = menuService;
    }

    @GetMapping("/api/menu")
    public ResponseEntity<?> getAllMenuItems() {

        List<MenuItem> list = menuService.getAllMenuItems();
        if (list != null)
            return new ResponseEntity<>(list, HttpStatus.OK);
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping("/api/menu/name/{name}")
    public ResponseEntity<?> getMenuItemByName(@PathVariable String name) {

        try {
            MenuItem menuItem = menuService.getMenuItemByName(name);
            return new ResponseEntity<>(menuItem, HttpStatus.OK);
        }catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/api/menu/id/{id}")
    public ResponseEntity<?> getMenuItemById(@PathVariable Integer id) {

        try {
            MenuItem menuItem = menuService.getMenuItemById(id);
            return new ResponseEntity<>(menuItem, HttpStatus.OK);
        }catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/api/menu/category/{category}")
    public ResponseEntity<?> getMenuItemsByCategory(@PathVariable String category) {

        try {
            List<MenuItem> list = menuService.getMenuItemsByCategory(category);
            return new ResponseEntity<>(list, HttpStatus.OK);
        }catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping(value = "/api/menu/{id}")
    public ResponseEntity<?> addMenuItem(@RequestBody MenuItemDTO mi) {

        MenuItem menuItem = menuService.addMenuItem(mi);

        if (menuItem != null) {
            return new ResponseEntity<>(menuItem, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    @DeleteMapping("/api/menu/{id}")
    public ResponseEntity<?> deleteMenuItem(@PathVariable Integer id) {

        if (menuService.existsById(id)) {
            menuService.deleteMenuItem(id);
            return new ResponseEntity<>(HttpStatus.OK);
        } else
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PutMapping("/api/menu/{id}")
    public ResponseEntity<?> updateMenuItem(@PathVariable Integer id, @RequestBody MenuItem mi) {

        try {
            menuService.updateMenuItem(id, mi);
            return new ResponseEntity<>(HttpStatus.OK);

        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/api/menu/deactivate/{id}")
    public ResponseEntity<?> deactivateMenuItem(@PathVariable Integer id) {
        try {
            menuService.deactivateMenuItem(id);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/api/menu/activate/{id}")
    public ResponseEntity<?> activateMenuItem(@PathVariable Integer id) {
        try {
            menuService.activateMenuItem(id);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
