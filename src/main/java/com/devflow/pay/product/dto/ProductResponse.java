package com.devflow.pay.product.dto;

import java.math.BigDecimal;
import java.util.UUID;

public record ProductResponse(

        UUID id,

        String name,

        String description,

        String sku,

        BigDecimal price,

        Integer stock,

        Boolean active,

        String category,

        String imageUrl

) {
}