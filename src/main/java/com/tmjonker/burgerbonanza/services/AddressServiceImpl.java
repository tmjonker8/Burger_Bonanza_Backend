package com.tmjonker.burgerbonanza.services;

import com.tmjonker.burgerbonanza.entities.address.Address;
import com.tmjonker.burgerbonanza.exceptions.AddressNotFoundException;
import com.tmjonker.burgerbonanza.repositories.AddressRepository;
import org.springframework.stereotype.Service;

@Service
public class AddressServiceImpl implements AddressService{

    private AddressRepository addressRepository;

    public AddressServiceImpl(AddressRepository addressRepository) {
        this.addressRepository = addressRepository;
    }

    public Address saveAddress(Address address) throws AddressNotFoundException {

        if (!addressRepository.existsByAddressAndAddress2AndZipCodeAndUserId(address.getAddress(),
                address.getAddress2(), address.getZipCode(), address.getUserId()))
            return addressRepository.save(address);
        else {
            return addressRepository.findAddressByAddressAndAddress2AndZipCodeAndUserId(address.getAddress(),
                            address.getAddress2(), address.getZipCode(), address.getUserId())
                    .orElseThrow(() -> new AddressNotFoundException(address.getAddress()));
        }
    }
}
