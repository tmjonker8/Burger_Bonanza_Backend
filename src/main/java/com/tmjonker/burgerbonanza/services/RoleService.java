package com.tmjonker.burgerbonanza.services;

import com.tmjonker.burgerbonanza.entities.role.Role;
import com.tmjonker.burgerbonanza.repositories.RoleRepository;
import org.springframework.stereotype.Service;

@Service
public class RoleService {

    private RoleRepository roleRepository;

    public RoleService (RoleRepository roleRepository) {

        this.roleRepository = roleRepository;
    }

    public void saveRole(Role role) {

        roleRepository.save(role);
    }
}
