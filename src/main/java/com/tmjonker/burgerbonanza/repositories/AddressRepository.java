package com.tmjonker.burgerbonanza.repositories;

import com.tmjonker.burgerbonanza.entities.address.Address;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface AddressRepository extends CrudRepository<Address, Long> {

    boolean existsByAddress(String address);
    boolean existsByAddressAndAddress2AndZipCodeAndUserId(String address, String address2, String zipCode, Long userId);
    Optional<Address> findAddressByAddressAndAddress2AndZipCodeAndUserId(String address, String address2, String zipCode, Long userId);
}
