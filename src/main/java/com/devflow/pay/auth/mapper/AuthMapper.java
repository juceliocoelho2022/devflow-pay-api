package com.devflow.pay.auth.mapper;

import com.devflow.pay.auth.dto.RegisterRequest;
import com.devflow.pay.auth.dto.RegisterResponse;
import com.devflow.pay.common.enums.Status;
import com.devflow.pay.user.entity.User;
import org.springframework.stereotype.Component;

@Component
public class AuthMapper {

    public User toEntity(RegisterRequest request) {

        User user = new User();

        user.setFullName(request.fullName());
        user.setEmail(request.email());
        user.setPassword(request.password());

        user.setRole(
                request.role() == null
                        ? com.devflow.pay.common.enums.UserRole.CUSTOMER
                        : request.role());

        user.setStatus(Status.ACTIVE);

        return user;
    }

    public RegisterResponse toResponse(User user) {

        return new RegisterResponse(

                user.getId(),

                user.getFullName(),

                user.getEmail(),

                user.getRole(),

                user.getStatus(),

                user.getCreatedAt()
        );
    }

}