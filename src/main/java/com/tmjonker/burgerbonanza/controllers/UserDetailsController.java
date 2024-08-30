package com.tmjonker.burgerbonanza.controllers;

import com.tmjonker.burgerbonanza.entities.address.Address;
import com.tmjonker.burgerbonanza.services.CustomUserDetailsService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@RestController
public class UserDetailsController {

    CustomUserDetailsService userDetailsService;

    public UserDetailsController(CustomUserDetailsService userDetailsService) {
        this.userDetailsService = userDetailsService;
    }

    @GetMapping("/addresses/{username}")
    public ResponseEntity<?> getUserAddresses(@PathVariable String username) {

        try {
            Set<Address> addresses = userDetailsService.getUserAddresses(username);
            return new ResponseEntity<>(addresses, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
