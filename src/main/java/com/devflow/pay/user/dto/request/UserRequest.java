package com.devflow.pay.user.dto.request;

import com.devflow.pay.common.enums.UserRole;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class UserRequest {

    @NotBlank
    @Size(min = 3, max = 120)
    private String fullName;

    @Email
    @NotBlank
    private String email;

    @NotBlank
    @Size(min = 6)
    private String password;

    private UserRole role;

    public UserRequest() {
    }

}