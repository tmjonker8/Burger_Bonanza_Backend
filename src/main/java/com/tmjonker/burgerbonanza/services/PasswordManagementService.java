package com.tmjonker.burgerbonanza.services;

import org.springframework.http.ResponseEntity;

public interface PasswordManagementService {

    ResponseEntity<?> changePassword(String username, String newPassword);

    boolean validatePassword(String username, String oldPassword);

    String encodePassword(String password);
}
