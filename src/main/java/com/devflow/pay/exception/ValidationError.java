package com.devflow.pay.exception;

import java.time.LocalDateTime;
import java.util.Map;

public record ValidationError(

        LocalDateTime timestamp,

        Integer status,

        String error,

        Map<String, String> fields,

        String path

) {
}