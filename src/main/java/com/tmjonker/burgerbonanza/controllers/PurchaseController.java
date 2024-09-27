package com.tmjonker.burgerbonanza.controllers;

import com.tmjonker.burgerbonanza.dtos.PurchaseDTO;
import com.tmjonker.burgerbonanza.services.PurchaseService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class PurchaseController {

    PurchaseService purchaseService;

    public PurchaseController(PurchaseService purchaseService) {

        this.purchaseService = purchaseService;
    }

    @PostMapping("/purchase")
    public ResponseEntity<?> postPurchase(@RequestBody PurchaseDTO purchaseDTO) {

        try {
            purchaseService.processPurchase(purchaseDTO);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

//    @GetMapping("/purchase/{id}")
//    public ResponseEntity<?> getPurchases(@PathVariable Long userId) {
//
//    }
}
