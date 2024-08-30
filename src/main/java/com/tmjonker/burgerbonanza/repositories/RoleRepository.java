package com.tmjonker.burgerbonanza.repositories;

import com.tmjonker.burgerbonanza.entities.role.Role;
import org.springframework.data.repository.CrudRepository;

public interface RoleRepository extends CrudRepository<Role, Integer> {
}
