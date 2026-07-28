package com.devflow.pay.order.repository;

import com.devflow.pay.order.entity.Order;
import com.devflow.pay.order.entity.OrderStatus;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface OrderRepository extends JpaRepository<Order, UUID> {

    List<Order> findByCustomerId(UUID customerId);

    List<Order> findByStatus(OrderStatus status);

}