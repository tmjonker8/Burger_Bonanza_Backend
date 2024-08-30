package com.tmjonker.burgerbonanza.controllers;

import com.tmjonker.burgerbonanza.services.EmailManagementService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class ContactController {

    private EmailManagementService emailManagementService;

    public ContactController(EmailManagementService emailManagementService) {

        this.emailManagementService = emailManagementService;
    }

    @PostMapping("/contact")
    public ResponseEntity<?> sendEmail(@RequestBody Map<String, Object> payload) {

        String from = (String) payload.get("from");
        String subject = "From: " + from + " " + (String) payload.get("subject");
        String body = (String) payload.get("body");

        try {
            emailManagementService.sendEmail(from, subject, body);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch(Exception e) {
            System.out.println(e.getMessage());
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
}
