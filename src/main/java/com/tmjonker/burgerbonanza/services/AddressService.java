package com.tmjonker.burgerbonanza.services;

import com.tmjonker.burgerbonanza.dtos.AddressDTO;
import com.tmjonker.burgerbonanza.entities.address.Address;
import com.tmjonker.burgerbonanza.exceptions.AddressNotFoundException;
import com.tmjonker.burgerbonanza.repositories.AddressRepository;
import org.springframework.stereotype.Service;

@Service
public class AddressService {

    private AddressRepository addressRepository;

    public AddressService(AddressRepository addressRepository) {
        this.addressRepository = addressRepository;
    }

    public Address saveAddress(Address address) throws AddressNotFoundException {

        if (!addressRepository.existsByAddress(address.getAddress()))
            return addressRepository.save(address);
        else {
            return addressRepository.findAddressByAddressAndAddress2AndZipCode(address.getAddress(),
                            address.getAddress2(), address.getZipCode())
                    .orElseThrow(() -> new AddressNotFoundException(address.getAddress()));
        }
    }
}
