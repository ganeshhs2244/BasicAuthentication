package com.m31.springSecurity.Controller;

import com.m31.springSecurity.dto.AuthDTO;
import com.m31.springSecurity.utility.JWTTocken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthenticationController {

    @Autowired
    private AuthenticationManager AuthenticationManager;
    @Autowired
    private JWTTocken jwtTocken;

    @PostMapping("/jwt")
    public ResponseEntity<String> generateJWT(@RequestBody AuthDTO authDTO)
    {
        AuthenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(authDTO.getUserName(), authDTO.getPassword())
        );
        String jwt = jwtTocken.generateJwt(authDTO.getUserName());
        return new ResponseEntity<> ( jwt, HttpStatus.OK);
    }
}
