package com.devflow.pay.product.repository;

import com.devflow.pay.product.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface ProductRepository extends JpaRepository<Product, UUID> {
    boolean existsBySku(String sku);

    Optional<Product> findBySku(String sku);

    List<Product> findByActiveTrue();

    List<Product> findByCategory(String category);
}