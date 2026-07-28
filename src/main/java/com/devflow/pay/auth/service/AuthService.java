package com.devflow.pay.auth.service;

import com.devflow.pay.auth.dto.LoginRequest;
import com.devflow.pay.auth.dto.LoginResponse;
import com.devflow.pay.auth.dto.RegisterRequest;
import com.devflow.pay.auth.dto.RegisterResponse;
import com.devflow.pay.auth.mapper.AuthMapper;
import com.devflow.pay.exception.DuplicateResourceException;
import com.devflow.pay.security.jwt.JwtService;
import com.devflow.pay.user.entity.User;
import com.devflow.pay.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final AuthenticationManager authenticationManager;
    private final JwtService jwtService;
    private final AuthMapper authMapper;

    /**
     * Cadastro de usuário
     */
    public RegisterResponse register(RegisterRequest request) {

        if (userRepository.existsByEmail(request.email())) {
            throw new DuplicateResourceException("E-mail já cadastrado.");
        }

        User user = authMapper.toEntity(request);

        user.setPassword(
                passwordEncoder.encode(user.getPassword())
        );

        User saved = userRepository.save(user);

        return authMapper.toResponse(saved);
    }

    /**
     * Login
     */
    public LoginResponse login(LoginRequest request) {

        authenticationManager.authenticate(

                new UsernamePasswordAuthenticationToken(

                        request.getEmail(),

                        request.getPassword()

                )
        );

        String token = jwtService.generateToken(request.getEmail());

        return new LoginResponse(token);
    }

}