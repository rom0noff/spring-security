package com.example.jwt.controller;

import com.example.jwt.model.JwtRequest;
import com.example.jwt.model.JwtResponse;
import com.example.jwt.service.JwtProvider;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Jahongir
 * @project jwt
 * @Email 'jakhongirsherjonov@gmail.com'
 * @Date 2/8/2023
 */
@RestController
public class Controller {
    //
    private final JwtProvider jwtProvider;
    private final AuthenticationManager authenticationManager;

    public Controller(JwtProvider jwtProvider, AuthenticationManager authenticationManager) {
        this.jwtProvider = jwtProvider;
        this.authenticationManager = authenticationManager;
    }

    @GetMapping("/getinfo")
    public String getinfo(){
        return "hello world";
    }

    @PostMapping("/token")
    public ResponseEntity<?> generateToken(@RequestBody JwtRequest jwtRequest){
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(jwtRequest.getUsername(), jwtRequest.getPassword()));
        String token = jwtProvider.generateToken(jwtRequest.getUsername(), jwtRequest.getPassword());
        return ResponseEntity.ok(new JwtResponse(token));
    }
}
