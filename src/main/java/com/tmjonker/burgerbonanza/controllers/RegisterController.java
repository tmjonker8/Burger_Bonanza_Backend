package com.tmjonker.burgerbonanza.controllers;

import com.tmjonker.burgerbonanza.dtos.UserDTO;
import com.tmjonker.burgerbonanza.entities.user.User;
import com.tmjonker.burgerbonanza.exceptions.UsernameAlreadyExistsException;
import com.tmjonker.burgerbonanza.services.CustomUserDetailsService;
import com.tmjonker.burgerbonanza.services.ShoppingCartService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class RegisterController {

    CustomUserDetailsService userDetailsService;
    ShoppingCartService scs;

    public RegisterController(CustomUserDetailsService userDetailsService, ShoppingCartService scs) {

        this.userDetailsService = userDetailsService;
        this.scs = scs;
    }

    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody UserDTO userDTO) throws UsernameAlreadyExistsException {

        try {
            User user = userDetailsService.saveNewUser(userDTO);
            scs.createShoppingCart(user);
            return new ResponseEntity<>(user, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
}
