package com.tmjonker.burgerbonanza.services;

import com.tmjonker.burgerbonanza.entities.role.Role;
import com.tmjonker.burgerbonanza.repositories.RoleRepository;
import org.springframework.stereotype.Service;

@Service
public class RoleServiceImpl implements RoleService {

    private RoleRepository roleRepository;

    public RoleServiceImpl(RoleRepository roleRepository) {

        this.roleRepository = roleRepository;
    }

    public void saveRole(Role role) {

        roleRepository.save(role);
    }

    public Role getRole(String roleName) {

        return roleRepository.findRoleByName(roleName);
    }
}
