package com.devflow.pay.user.service;

import com.devflow.pay.auth.dto.RegisterRequest;
import com.devflow.pay.common.enums.Status;
import com.devflow.pay.exception.DuplicateResourceException;
import com.devflow.pay.exception.ResourceNotFoundException;
import com.devflow.pay.user.dto.request.UserRequest;
import com.devflow.pay.user.dto.response.UserResponse;
import com.devflow.pay.user.entity.User;
import com.devflow.pay.user.mapper.UserMapper;
import com.devflow.pay.user.repository.UserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class UserService {

    private final UserRepository repository;
    private final UserMapper mapper;
    private final PasswordEncoder passwordEncoder;

    public UserService(
            UserRepository repository,
            UserMapper mapper,
            PasswordEncoder passwordEncoder) {

        this.repository = repository;
        this.mapper = mapper;
        this.passwordEncoder = passwordEncoder;
    }

    public UserResponse create(UserRequest request) {

        throw new UnsupportedOperationException("Implementaremos na próxima etapa.");

    }

    public List<UserResponse> findAll() {

        throw new UnsupportedOperationException("Implementaremos na próxima etapa.");

    }

    public UserResponse findById(UUID id) {

        throw new UnsupportedOperationException("Implementaremos na próxima etapa.");

    }

    public UserResponse update(UUID id, UserRequest request) {

        throw new UnsupportedOperationException("Implementaremos na próxima etapa.");

    }

    public void delete(UUID id) {

        throw new UnsupportedOperationException("Implementaremos na próxima etapa.");

    }

    public com.devflow.pay.auth.dto.UserResponse register(RegisterRequest request) {

        if (repository.existsByEmail(request.email())) {
            throw new DuplicateResourceException("E-mail já cadastrado.");
        }

        User user = new User();

        user.setFullName(request.fullName());
        user.setEmail(request.email());
        user.setPassword(passwordEncoder.encode(request.password()));
        user.setRole(request.role());
        user.setStatus(Status.ACTIVE);

        User saved = repository.save(user);

        return new com.devflow.pay.auth.dto.UserResponse(
                saved.getId(),
                saved.getFullName(),
                saved.getEmail(),
                saved.getRole(),
                saved.getStatus()
        );
    }
}