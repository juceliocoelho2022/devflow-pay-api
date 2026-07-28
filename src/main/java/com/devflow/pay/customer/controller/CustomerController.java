package com.devflow.pay.customer.controller;

import com.devflow.pay.customer.dto.CustomerRequest;
import com.devflow.pay.customer.dto.CustomerResponse;
import com.devflow.pay.customer.service.CustomerService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/customers")
@RequiredArgsConstructor
@Tag(name = "Customers")
public class CustomerController {

    private final CustomerService service;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    @Operation(summary = "Create customer")
    public CustomerResponse create(@Valid @RequestBody CustomerRequest request) {

        return service.create(request);

    }

    @GetMapping
    @Operation(summary = "List customers")
    public List<CustomerResponse> findAll() {

        return service.findAll();

    }

    @GetMapping("/{id}")
    @Operation(summary = "Find customer by id")
    public CustomerResponse findById(@PathVariable UUID id) {

        return service.findById(id);

    }

    @PutMapping("/{id}")
    @Operation(summary = "Update customer")
    public CustomerResponse update(
            @PathVariable UUID id,
            @Valid @RequestBody CustomerRequest request) {

        return service.update(id, request);

    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @Operation(summary = "Deactivate customer")
    public void delete(@PathVariable UUID id) {

        service.delete(id);

    }

}