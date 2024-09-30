package com.tmjonker.burgerbonanza.controllers;

import com.tmjonker.burgerbonanza.dtos.UserTokenDTO;
import com.tmjonker.burgerbonanza.entities.user.User;
import com.tmjonker.burgerbonanza.security.jwt.JwtRequest;
import com.tmjonker.burgerbonanza.security.jwt.JwtResponse;
import com.tmjonker.burgerbonanza.security.jwt.JwtTokenUtil;
import com.tmjonker.burgerbonanza.services.AuthenticationService;
import com.tmjonker.burgerbonanza.services.CustomUserDetailsService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;


@RestController
@CrossOrigin
public class AuthenticateController {

    private AuthenticationService authenticationService;
    private JwtTokenUtil jwtTokenUtil;
    private CustomUserDetailsService userDetailsService;

    public AuthenticateController(AuthenticationService authenticationService, JwtTokenUtil jwtTokenUtil,
                                  CustomUserDetailsService userDetailsService) {

        this.authenticationService = authenticationService;
        this.jwtTokenUtil = jwtTokenUtil;
        this.userDetailsService = userDetailsService;
    }

    @PostMapping(value = "/authenticate")
    public ResponseEntity<?> createAuthenticationToken(@RequestBody JwtRequest authenticationRequest) throws Exception {

        try {
            authenticationService.authenticate(authenticationRequest.getUsername(), authenticationRequest.getPassword());
            final User userDetails = (User) userDetailsService
                    .loadUserByUsername(authenticationRequest.getUsername());

            final UserTokenDTO userTokenDTO = new UserTokenDTO(userDetails.getId(), userDetails.getUsername(), userDetails.getRoles());

            final String token = jwtTokenUtil.generateToken(userDetails);

            return ResponseEntity.ok(Map.of("token", new JwtResponse(token), "user", userTokenDTO));
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
}
