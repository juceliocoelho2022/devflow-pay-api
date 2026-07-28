package com.devflow.pay.order.dto;

import lombok.*;

import java.math.BigDecimal;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class OrderItemResponse {

    private UUID productId;

    private String productName;

    private Integer quantity;

    private BigDecimal unitPrice;

    private BigDecimal subtotal;

}