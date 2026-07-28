package com.devflow.pay.order.dto;

import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.util.List;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class OrderRequest {

    @NotNull
    private UUID customerId;

    @NotNull
    private List<OrderItemRequest> items;

}