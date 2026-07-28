package com.devflow.pay.auth.controller;

import com.devflow.pay.auth.dto.LoginRequest;
import com.devflow.pay.auth.dto.LoginResponse;
import com.devflow.pay.auth.dto.RegisterRequest;
import com.devflow.pay.auth.dto.RegisterResponse;
import com.devflow.pay.auth.service.AuthService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthController {

    private final AuthService service;

    public AuthController(AuthService service) {
        this.service = service;
    }

    @PostMapping("/register")
    @ResponseStatus(HttpStatus.CREATED)
    public RegisterResponse register(
            @Valid @RequestBody RegisterRequest request) {

        return service.register(request);
    }

    @PostMapping("/login")
    public LoginResponse login(
            @Valid @RequestBody LoginRequest request) {

        return service.login(request);
    }
}