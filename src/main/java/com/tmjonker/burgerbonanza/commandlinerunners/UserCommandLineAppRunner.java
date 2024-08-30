package com.tmjonker.burgerbonanza.commandlinerunners;

import com.tmjonker.burgerbonanza.dtos.UserDTO;
import com.tmjonker.burgerbonanza.entities.role.Role;
import com.tmjonker.burgerbonanza.repositories.RoleRepository;
import com.tmjonker.burgerbonanza.entities.user.User;
import com.tmjonker.burgerbonanza.repositories.UserRepository;
import com.tmjonker.burgerbonanza.services.CustomUserDetailsService;
import com.tmjonker.burgerbonanza.services.RoleService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Lazy;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class UserCommandLineAppRunner implements CommandLineRunner {

    private CustomUserDetailsService customUserDetailsService;
    private PasswordEncoder passwordEncoder;
    private RoleService roleService;

    @Lazy
    public UserCommandLineAppRunner(CustomUserDetailsService customUserDetailsService, PasswordEncoder passwordEncoder, RoleService roleService) {

        this.customUserDetailsService = customUserDetailsService;
        this.roleService = roleService;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public void run(String... args) throws Exception {
        // create default admin account with a default password that can be changed later.
        UserDTO userDTO = new UserDTO("admin", "password", "password");

        try {
            User user = customUserDetailsService.saveNewUser(userDTO);

            Role role = new Role("Admin");
            user.addRole(role);
            customUserDetailsService.saveUser(user);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
