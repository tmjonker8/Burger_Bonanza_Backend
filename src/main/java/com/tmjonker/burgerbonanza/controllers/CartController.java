package com.tmjonker.burgerbonanza.controllers;

import com.tmjonker.burgerbonanza.dtos.CartDTO;
import com.tmjonker.burgerbonanza.entities.shoppingcart.ShoppingCart;
import com.tmjonker.burgerbonanza.services.ShoppingCartService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class CartController {

    ShoppingCartService shoppingCartService;

    public CartController(ShoppingCartService shoppingCartService) {

        this.shoppingCartService = shoppingCartService;
    }

    @PostMapping("/cart/{username}")
    public ResponseEntity<?> postCart(@RequestBody CartDTO cartDTO, @PathVariable String username) {

        return shoppingCartService.processShoppingCart(cartDTO, username);
    }

    @GetMapping("/cart/{username}")
    public ResponseEntity<?> getCart(@PathVariable String username) {

        ShoppingCart shoppingCart = shoppingCartService.getShoppingCart(username);

        if (shoppingCart != null) {
            return new ResponseEntity<>(shoppingCart, HttpStatus.OK);
        }

        return new ResponseEntity<>(HttpStatus.NOT_FOUND);

    }
}
