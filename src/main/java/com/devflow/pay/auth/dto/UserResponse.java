package com.devflow.pay.auth.dto;

import com.devflow.pay.common.enums.Status;
import com.devflow.pay.common.enums.UserRole;

import java.util.UUID;

public record UserResponse(

        UUID id,

        String fullName,

        String email,

        UserRole role,

        Status status

) {
}