package com.tmjonker.burgerbonanza.commandlinerunners;
import com.tmjonker.burgerbonanza.entities.role.Role;
import com.tmjonker.burgerbonanza.services.RoleService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Order(1)
public class RoleCommandLineRunner implements CommandLineRunner {

    private RoleService roleService;

    public RoleCommandLineRunner(RoleService roleService) {
        this.roleService = roleService;
    }

    @Override
    public void run(String... args) throws Exception {
        Role role = new Role("Admin");
        roleService.saveRole(role);
    }
}
