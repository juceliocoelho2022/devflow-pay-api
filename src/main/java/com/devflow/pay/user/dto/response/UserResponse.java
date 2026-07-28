package com.devflow.pay.user.dto.response;

import com.devflow.pay.common.enums.Status;
import com.devflow.pay.common.enums.UserRole;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.UUID;

@Setter
@Getter
public class UserResponse {

    private UUID id;

    private String fullName;

    private String email;

    private UserRole role;

    private Status status;

    private LocalDateTime createdAt;

    public UserResponse() {
    }

}