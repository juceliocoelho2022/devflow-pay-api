package com.devflow.pay.customer.repository;

import com.devflow.pay.customer.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface CustomerRepository extends JpaRepository<Customer, UUID> {

    Optional<Customer> findByEmail(String email);

    Optional<Customer> findByDocument(String document);

    boolean existsByEmail(String email);

    boolean existsByDocument(String document);

}