package com.tmjonker.burgerbonanza.services;

import com.tmjonker.burgerbonanza.entities.address.Address;
import com.tmjonker.burgerbonanza.exceptions.AddressNotFoundException;

public interface AddressService {

    Address saveAddress(Address address) throws AddressNotFoundException;
}
