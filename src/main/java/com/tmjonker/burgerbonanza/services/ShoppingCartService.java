package com.tmjonker.burgerbonanza.services;

import com.tmjonker.burgerbonanza.dtos.CartDTO;
import com.tmjonker.burgerbonanza.entities.shoppingcart.ShoppingCart;
import com.tmjonker.burgerbonanza.entities.user.User;
import org.springframework.http.ResponseEntity;

public interface ShoppingCartService {

    public ShoppingCart getShoppingCart(String username);

    public ResponseEntity<?> processShoppingCart(CartDTO cartDTO, String username);

    public void createShoppingCart(User user);
}
