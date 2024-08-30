package com.tmjonker.burgerbonanza.repositories;

import com.tmjonker.burgerbonanza.entities.purchase.Purchase;
import org.springframework.data.repository.CrudRepository;

public interface PurchaseRepository extends CrudRepository<Purchase, Long> {
}
