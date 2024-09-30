package com.tmjonker.burgerbonanza.services;

import com.tmjonker.burgerbonanza.entities.role.Role;

public interface RoleService {

    void saveRole(Role role);

    Role getRole(String roleName);
}
