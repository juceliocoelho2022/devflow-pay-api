package com.devflow.pay.order.mapper;

import com.devflow.pay.order.dto.OrderItemResponse;
import com.devflow.pay.order.dto.OrderResponse;
import com.devflow.pay.order.entity.Order;
import com.devflow.pay.order.entity.OrderItem;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class OrderMapper {

    public OrderResponse toResponse(Order order) {

        return OrderResponse.builder()
                .id(order.getId())
                .customerId(order.getCustomer().getId())
                .customerName(order.getCustomer().getFullName())
                .status(order.getStatus())
                .total(order.getTotal())
                .createdAt(order.getCreatedAt())
                .items(toItemResponseList(order.getItems()))
                .build();

    }

    public List<OrderResponse> toResponseList(List<Order> orders) {

        return orders.stream()
                .map(this::toResponse)
                .collect(Collectors.toList());

    }

    private List<OrderItemResponse> toItemResponseList(List<OrderItem> items) {

        return items.stream()
                .map(this::toItemResponse)
                .collect(Collectors.toList());

    }

    private OrderItemResponse toItemResponse(OrderItem item) {

        return OrderItemResponse.builder()
                .productId(item.getProduct().getId())
                .productName(item.getProduct().getName())
                .quantity(item.getQuantity())
                .unitPrice(item.getUnitPrice())
                .subtotal(item.getSubtotal())
                .build();

    }

}