package com.devflow.pay.order.service;

import com.devflow.pay.customer.entity.Customer;
import com.devflow.pay.customer.repository.CustomerRepository;
import com.devflow.pay.exception.BusinessException;
import com.devflow.pay.exception.ResourceNotFoundException;
import com.devflow.pay.order.dto.OrderItemRequest;
import com.devflow.pay.order.dto.OrderRequest;
import com.devflow.pay.order.dto.OrderResponse;
import com.devflow.pay.order.entity.Order;
import com.devflow.pay.order.entity.OrderItem;
import com.devflow.pay.order.entity.OrderStatus;
import com.devflow.pay.order.mapper.OrderMapper;
import com.devflow.pay.order.repository.OrderRepository;
import com.devflow.pay.product.entity.Product;
import com.devflow.pay.product.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class OrderService {

    private final OrderRepository orderRepository;

    private final CustomerRepository customerRepository;

    private final ProductRepository productRepository;

    private final OrderMapper orderMapper;
    @Transactional
    public OrderResponse create(OrderRequest request) {

        log.info("Creating order...");

        Customer customer = customerRepository.findById(request.getCustomerId())
                .orElseThrow(() ->
                        new ResourceNotFoundException("Customer not found"));

        Order order = Order.builder()
                .customer(customer)
                .status(OrderStatus.CREATED)
                .total(BigDecimal.ZERO)
                .items(new ArrayList<>())
                .build();

        BigDecimal total = BigDecimal.ZERO;

        for (OrderItemRequest itemRequest : request.getItems()) {

            Product product = productRepository.findById(itemRequest.getProductId())
                    .orElseThrow(() ->
                            new ResourceNotFoundException("Product not found"));

            if (product.getStock() < itemRequest.getQuantity()) {
                throw new BusinessException(
                        "Insufficient stock for product: "
                                + product.getName());
            }

            BigDecimal subtotal =
                    product.getPrice()
                            .multiply(
                                    BigDecimal.valueOf(
                                            itemRequest.getQuantity()));

            OrderItem item = OrderItem.builder()
                    .order(order)
                    .product(product)
                    .quantity(itemRequest.getQuantity())
                    .unitPrice(product.getPrice())
                    .subtotal(subtotal)
                    .build();

            order.getItems().add(item);

            total = total.add(subtotal);

            product.setStock(
                    product.getStock()
                            - itemRequest.getQuantity());

        }

        order.setTotal(total);

        Order saved = orderRepository.save(order);

        log.info("Order created successfully {}", saved.getId());

        return orderMapper.toResponse(saved);

    }

}