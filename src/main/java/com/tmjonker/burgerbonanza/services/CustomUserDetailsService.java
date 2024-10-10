package com.tmjonker.burgerbonanza.services;

import com.tmjonker.burgerbonanza.dtos.UserDTO;
import com.tmjonker.burgerbonanza.entities.address.Address;
import com.tmjonker.burgerbonanza.entities.user.User;
import com.tmjonker.burgerbonanza.exceptions.UserNotFoundException;
import com.tmjonker.burgerbonanza.exceptions.UsernameAlreadyExistsException;
import com.tmjonker.burgerbonanza.repositories.UserRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.context.annotation.Lazy;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    private UserRepository userRepository;
    private PasswordManagementService passwordManagementService;

    public CustomUserDetailsService(UserRepository userRepository, @Lazy PasswordManagementService passwordManagementService) {

        this.userRepository = userRepository;
        this.passwordManagementService = passwordManagementService;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        return userRepository.findByUsername(username).orElseThrow(() -> new UsernameNotFoundException("username"));
    }

    public User saveNewUser(UserDTO userDTO) throws UsernameAlreadyExistsException {

        boolean exists = userRepository.existsByUsername(userDTO.getUsername());
        if (!exists) {
            User user = new User(userDTO.getUsername(), passwordManagementService.encodePassword(userDTO.getPassword1()));
            return userRepository.save(user);
        } else {
            throw new UsernameAlreadyExistsException(userDTO.getUsername());
        }
    }

    public User saveUser(User user) {

        return userRepository.save(user);
    }

    public Set<Address> getUserAddresses(String username) {

        User user = (User) loadUserByUsername(username);
        return user.getAddresses();
    }

    public User getUserById(Long id) {
        return userRepository.findById(id).orElseThrow(() -> new UserNotFoundException(id));
    }
}
