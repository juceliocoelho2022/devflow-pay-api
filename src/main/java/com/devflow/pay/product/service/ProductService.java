package com.devflow.pay.product.service;

import com.devflow.pay.product.dto.ProductRequest;
import com.devflow.pay.product.dto.ProductResponse;
import com.devflow.pay.product.entity.Product;
import com.devflow.pay.product.mapper.ProductMapper;
import com.devflow.pay.product.repository.ProductRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
@Transactional
public class ProductService {

    private final ProductRepository repository;
    private final ProductMapper mapper;

    public ProductResponse create(ProductRequest request){

        Product product = mapper.toEntity(request);

        repository.save(product);

        return mapper.toResponse(product);
    }

    public List<ProductResponse> findAll(){

        return repository.findAll()
                .stream()
                .map(mapper::toResponse)
                .toList();

    }

    public ProductResponse findById(UUID id){

        Product product = repository.findById(id)
                .orElseThrow();

        return mapper.toResponse(product);

    }

}
