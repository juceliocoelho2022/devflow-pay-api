package com.devflow.pay.auth.dto;

import com.devflow.pay.common.enums.Status;
import com.devflow.pay.common.enums.UserRole;

import java.time.LocalDateTime;
import java.util.UUID;

public record RegisterResponse(

        UUID id,

        String fullName,

        String email,

        UserRole role,

        Status status,

        LocalDateTime createdAt

) {
}