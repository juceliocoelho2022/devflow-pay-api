package com.devflow.pay.user.service;

import com.devflow.pay.common.enums.Status;
import com.devflow.pay.user.dto.request.UserRequest;
import com.devflow.pay.user.dto.response.UserResponse;
import com.devflow.pay.user.entity.User;
import com.devflow.pay.user.exception.UserNotFoundException;
import com.devflow.pay.user.mapper.UserMapper;
import com.devflow.pay.user.repository.UserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    private final UserRepository repository;
    private final PasswordEncoder passwordEncoder;
    private final UserMapper mapper;

    public UserService(UserRepository repository,
                       PasswordEncoder passwordEncoder,
                       UserMapper mapper) {

        this.repository = repository;
        this.passwordEncoder = passwordEncoder;
        this.mapper = mapper;
    }

    public UserResponse create(UserRequest request) {

        if (repository.existsByEmail(request.getEmail())) {
            throw new RuntimeException("E-mail já cadastrado.");
        }

        User user = mapper.toEntity(request);

        user.setPassword(passwordEncoder.encode(request.getPassword()));
        user.setStatus(Status.ACTIVE);

        return mapper.toResponse(repository.save(user));
    }

    public List<UserResponse> findAll() {

        return repository.findAll()
                .stream()
                .map(mapper::toResponse)
                .toList();
    }

    public UserResponse findById(java.util.UUID id) {

        User user = repository.findById(id)
                .orElseThrow(UserNotFoundException::new);

        return mapper.toResponse(user);
    }

    public UserResponse update(java.util.UUID id,
                               UserRequest request) {

        User user = repository.findById(id)
                .orElseThrow(UserNotFoundException::new);

        mapper.updateEntity(user, request);

        if (request.getPassword() != null &&
                !request.getPassword().isBlank()) {

            user.setPassword(
                    passwordEncoder.encode(request.getPassword())
            );
        }

        return mapper.toResponse(repository.save(user));
    }

    public void delete(java.util.UUID id) {

        User user = repository.findById(id)
                .orElseThrow(UserNotFoundException::new);

        repository.delete(user);

    }

}