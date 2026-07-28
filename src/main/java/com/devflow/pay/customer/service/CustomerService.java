package com.devflow.pay.customer.service;

import com.devflow.pay.customer.dto.CustomerRequest;
import com.devflow.pay.customer.dto.CustomerResponse;
import com.devflow.pay.customer.entity.Customer;
import com.devflow.pay.customer.mapper.CustomerMapper;
import com.devflow.pay.customer.repository.CustomerRepository;
import com.devflow.pay.exception.DuplicateResourceException;
import com.devflow.pay.exception.ResourceNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class CustomerService {

    private final CustomerRepository repository;
    private final CustomerMapper mapper;

    public CustomerResponse create(CustomerRequest request) {

        if (repository.existsByEmail(request.email())) {
            throw new DuplicateResourceException("Email already registered.");
        }

        if (repository.existsByDocument(request.document())) {
            throw new DuplicateResourceException("Document already registered.");
        }

        Customer customer = mapper.toEntity(request);

        return mapper.toResponse(repository.save(customer));
    }

    public List<CustomerResponse> findAll() {

        return repository.findAll()
                .stream()
                .map(mapper::toResponse)
                .toList();
    }

    public CustomerResponse findById(UUID id) {

        Customer customer = repository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Customer not found."));

        return mapper.toResponse(customer);
    }

    public CustomerResponse update(UUID id, CustomerRequest request) {

        Customer customer = repository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Customer not found."));

        mapper.update(customer, request);

        return mapper.toResponse(repository.save(customer));
    }

    public void delete(UUID id) {

        Customer customer = repository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Customer not found."));

        customer.setActive(false);

        repository.save(customer);

    }

}