package com.devflow.pay.customer.dto;

import java.util.UUID;

public record CustomerResponse(

        UUID id,

        String fullName,

        String email,

        String document,

        String phone,

        Boolean active

) {
}