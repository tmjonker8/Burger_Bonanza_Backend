package com.tmjonker.burgerbonanza.services;

public interface EmailManagementService {

    void sendEmail(String from, String subject, String body);
}
