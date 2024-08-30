package com.tmjonker.burgerbonanza.repositories;

import com.tmjonker.burgerbonanza.entities.user.User;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface UserRepository extends CrudRepository<User, Long> {

    Optional<User> findByUsername(String username);
    boolean existsByUsername(String username);
}
