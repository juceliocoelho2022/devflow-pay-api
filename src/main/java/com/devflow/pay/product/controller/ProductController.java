package com.devflow.pay.product.controller;

import com.devflow.pay.product.dto.ProductRequest;
import com.devflow.pay.product.dto.ProductResponse;
import com.devflow.pay.product.service.ProductService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/products")
@RequiredArgsConstructor
public class ProductController {

    private final ProductService service;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ProductResponse create(@RequestBody @Valid ProductRequest request){

        return service.create(request);

    }

    @GetMapping
    public List<ProductResponse> findAll(){

        return service.findAll();

    }

    @GetMapping("/{id}")
    public ProductResponse findById(@PathVariable UUID id){

        return service.findById(id);

    }

}
