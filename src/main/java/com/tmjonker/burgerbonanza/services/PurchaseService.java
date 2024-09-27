package com.tmjonker.burgerbonanza.services;

import com.tmjonker.burgerbonanza.dtos.PurchaseDTO;
import com.tmjonker.burgerbonanza.entities.address.Address;
import com.tmjonker.burgerbonanza.entities.purchase.Purchase;
import com.tmjonker.burgerbonanza.entities.user.User;
import com.tmjonker.burgerbonanza.repositories.AddressRepository;
import com.tmjonker.burgerbonanza.repositories.PurchaseRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class PurchaseService {

    PurchaseRepository purchaseRepository;
    CustomUserDetailsService userDetailsService;
    AddressService addressService;

    public PurchaseService(PurchaseRepository purchaseRepository, CustomUserDetailsService userDetailsService,
                           AddressService addressService) {

        this.purchaseRepository = purchaseRepository;
        this.userDetailsService = userDetailsService;
        this.addressService = addressService;
    }

    public void processPurchase(PurchaseDTO purchaseDTO) throws Exception {

        Purchase purchase = new Purchase(purchaseDTO.getMenuItems(), purchaseDTO.getTotalPrice());
        Address address = new Address(purchaseDTO.getAddress().getName(),purchaseDTO.getAddress().getAddress1(),
                purchaseDTO.getAddress().getAddress2(),purchaseDTO.getAddress().getCity(),
                purchaseDTO.getAddress().getState(), purchaseDTO.getAddress().getZipCode(), purchaseDTO.getUserId());

        address = addressService.saveAddress(address);
        purchase = purchaseRepository.save(purchase);
        User user = (User) userDetailsService.loadUserByUsername(purchaseDTO.getUsername());
        user.addPurchase(purchase);
        user.addAddress(address);

        userDetailsService.saveUser(user);
    }

//    public Map<Integer, List<Purchase>> getUserPurchases(Long userId) {
//
//    }
}
