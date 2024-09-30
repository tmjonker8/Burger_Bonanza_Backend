package com.tmjonker.burgerbonanza.services;

public interface AuthenticationService {

    void authenticate(String username, String password) throws Exception;
}
