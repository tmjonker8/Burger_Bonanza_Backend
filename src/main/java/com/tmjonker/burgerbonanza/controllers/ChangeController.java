package com.tmjonker.burgerbonanza.controllers;

import com.tmjonker.burgerbonanza.dtos.ChangePasswordDTO;
import com.tmjonker.burgerbonanza.services.AuthenticationService;
import com.tmjonker.burgerbonanza.services.PasswordManagementService;
import com.tmjonker.burgerbonanza.repositories.UserRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ChangeController {
    private PasswordManagementService passwordManagementService;
    private AuthenticationService authenticationService;

    public ChangeController(PasswordManagementService passwordManagementService,
                            AuthenticationService authenticationService) {
        this.passwordManagementService = passwordManagementService;
        this.authenticationService = authenticationService;
    }

    @PostMapping("/change")
    public ResponseEntity<?> postChange(@RequestBody ChangePasswordDTO changePasswordDTO) throws Exception {

        String username = changePasswordDTO.getUsername();
        String newPassword = changePasswordDTO.getNewPassword();
        String oldPassword = changePasswordDTO.getOldPassword();

        try {
            authenticationService.authenticate(username, oldPassword);

            return passwordManagementService.changePassword(username, newPassword);
        } catch (Exception e) {

            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

    }
}
