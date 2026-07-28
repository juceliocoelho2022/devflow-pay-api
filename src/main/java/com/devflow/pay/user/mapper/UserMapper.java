package com.devflow.pay.user.mapper;

import com.devflow.pay.user.dto.request.UserRequest ;
import com.devflow.pay.user.dto.response.UserResponse;
import com.devflow.pay.user.entity.User;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {

    public User toEntity(UserRequest request) {

        if (request == null) {
            return null;
        }

        User user = new User();

        user.setFullName(request.getFullName());
        user.setEmail(request.getEmail());
        user.setPassword(request.getPassword());
        user.setRole(request.getRole());

        return user;
    }

    public UserResponse toResponse(User user) {

        if (user == null) {
            return null;
        }

        UserResponse response = new UserResponse();

        response.setId(user.getId());
        response.setFullName(user.getFullName());
        response.setEmail(user.getEmail());
        response.setRole(user.getRole());
        response.setStatus(user.getStatus());
        response.setCreatedAt(user.getCreatedAt());

        return response;
    }

    public void updateEntity(User entity, UserRequest request) {

        entity.setFullName(request.getFullName());
        entity.setEmail(request.getEmail());

        if (request.getPassword() != null &&
                !request.getPassword().isBlank()) {

            entity.setPassword(request.getPassword());
        }

        entity.setRole(request.getRole());

    }

}