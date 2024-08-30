package com.tmjonker.burgerbonanza.repositories;

import com.tmjonker.burgerbonanza.entities.shoppingcart.ShoppingCart;
import org.springframework.data.repository.CrudRepository;

public interface ShoppingCartRepository extends CrudRepository<ShoppingCart, Integer> {


}
