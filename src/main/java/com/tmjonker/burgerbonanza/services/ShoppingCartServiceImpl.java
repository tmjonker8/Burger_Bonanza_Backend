package com.tmjonker.burgerbonanza.services;

import com.tmjonker.burgerbonanza.dtos.CartDTO;
import com.tmjonker.burgerbonanza.entities.menu.MenuItem;
import com.tmjonker.burgerbonanza.entities.shoppingcart.ShoppingCart;
import com.tmjonker.burgerbonanza.entities.user.User;
import com.tmjonker.burgerbonanza.repositories.ShoppingCartRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class ShoppingCartServiceImpl implements ShoppingCartService{

    ShoppingCartRepository shoppingCartRepository;
    CustomUserDetailsService userDetailsService;

    public ShoppingCartServiceImpl(ShoppingCartRepository shoppingCartRepository, CustomUserDetailsService userDetailsService) {

        this.shoppingCartRepository = shoppingCartRepository;
        this.userDetailsService = userDetailsService;
    }

    public ShoppingCart getShoppingCart(String username) {

        User user = (User) userDetailsService.loadUserByUsername(username);

        return user.getShoppingCart();
    }

    public ResponseEntity<?> processShoppingCart(CartDTO cartDTO, String username) {

        try {
            User user = (User) userDetailsService.loadUserByUsername(username);

            ShoppingCart cart;

            if (user.getShoppingCart() == null) {
                cart = new ShoppingCart(cartDTO.getNumItems(), cartDTO.getMenuItems());

                cart = shoppingCartRepository.save(cart);
            } else {
                cart = user.getShoppingCart();
                cart.setNumItems(cartDTO.getNumItems());
                cart.setMenuItems(cartDTO.getMenuItems());
            }
            user.setShoppingCart(cart);
            userDetailsService.saveUser(user);

            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    public void createShoppingCart(User user) {

        ShoppingCart cart;
        cart = new ShoppingCart(0, new ArrayList<MenuItem>());
        shoppingCartRepository.save(cart);
        user.setShoppingCart(cart);

        userDetailsService.saveUser(user);

    }
}
