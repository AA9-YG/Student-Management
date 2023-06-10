package com.binaryAA.StudentManagement.web;

import com.binaryAA.StudentManagement.pojo.AccountCredentials;
import org.springframework.beans.factory.annotation.Autowired;
import com.binaryAA.StudentManagement.jwtService.JWTService;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

public class LoginController {

    @Autowired
    private JWTService jwtService;

    @Autowired
    private AuthenticationManager authenticationManager;

    @PostMapping("/login")
    public ResponseEntity<?> getToken(@RequestBody AccountCredentials credentials) {
        UsernamePasswordAuthenticationToken creds = new UsernamePasswordAuthenticationToken(credentials.getUsername(), credentials.getPassword());
        Authentication auth = authenticationManager.authenticate(creds);
        String token = jwtService.getToken(auth.getName());

        return ResponseEntity.ok().header("Authorization", "Bearer" + token)
                .header(HttpHeaders.ACCESS_CONTROL_ALLOW_HEADERS, "AUTHORIZATION")
                .build();
    }
}
