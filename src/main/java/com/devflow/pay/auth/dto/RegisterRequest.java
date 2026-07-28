package com.devflow.pay.auth.dto;

import com.devflow.pay.common.enums.UserRole;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record RegisterRequest(

        @NotBlank
        String fullName,

        @Email
        @NotBlank
        String email,

        @NotBlank
        String password,

        @NotNull
        UserRole role

) {
}