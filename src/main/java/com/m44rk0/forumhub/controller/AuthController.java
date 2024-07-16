package com.m44rk0.forumhub.controller;

import com.m44rk0.forumhub.dto.authDTO.AuthData;
import com.m44rk0.forumhub.dto.authDTO.TokenJWT;
import com.m44rk0.forumhub.model.User;
import com.m44rk0.forumhub.service.TokenService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("login")
public class AuthController {

    @Autowired
    private AuthenticationManager manager;

    @Autowired
    private TokenService tokenService;

    @PostMapping
    public ResponseEntity<TokenJWT> login(@RequestBody @Valid AuthData data){

        var authToken = new UsernamePasswordAuthenticationToken(data.email(), data.password());

        var auth = manager.authenticate(authToken);

        var token = tokenService.generateToken((User) auth.getPrincipal());

        return ResponseEntity.ok(new TokenJWT(token));
    }

}