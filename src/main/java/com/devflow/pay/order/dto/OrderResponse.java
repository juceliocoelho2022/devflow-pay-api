package com.devflow.pay.order.dto;

import com.devflow.pay.order.entity.OrderStatus;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class OrderResponse {

    private UUID id;

    private UUID customerId;

    private String customerName;

    private OrderStatus status;

    private BigDecimal total;

    private List<OrderItemResponse> items;

    private LocalDateTime createdAt;

}