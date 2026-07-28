package com.devflow.pay.product.service;

import com.devflow.pay.exception.DuplicateResourceException;
import com.devflow.pay.exception.ResourceNotFoundException;
import com.devflow.pay.product.dto.ProductRequest;
import com.devflow.pay.product.dto.ProductResponse;
import com.devflow.pay.product.entity.Product;
import com.devflow.pay.product.mapper.ProductMapper;
import com.devflow.pay.product.repository.ProductRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Slf4j
@Service
@RequiredArgsConstructor
@Transactional
public class ProductService {

    private final ProductRepository repository;
    private final ProductMapper mapper;

    public ProductResponse create(ProductRequest request) {

        log.info("Creating product {}", request.name());

        Product product = mapper.toEntity(request);

        /*
         * Gera um SKU automaticamente caso o usuário
         * não informe um.
         */
        if (product.getSku() == null || product.getSku().isBlank()) {

            product.setSku(
                    UUID.randomUUID()
                            .toString()
                            .substring(0, 8)
                            .toUpperCase()
            );

        }

        /*
         * Verifica se já existe um SKU igual.
         */
        if (repository.existsBySku(product.getSku())) {

            throw new DuplicateResourceException(
                    "SKU already exists: " + product.getSku()
            );

        }

        /*
         * Todo produto nasce ativo.
         */
        product.setActive(true);

        Product saved = repository.save(product);

        log.info("Product created successfully: {}", saved.getId());

        return mapper.toResponse(saved);

    }

    public List<ProductResponse> findAll() {

        log.info("Listing all products");

        return repository.findAll()
                .stream()
                .map(mapper::toResponse)
                .toList();

    }

    public ProductResponse findById(UUID id) {

        log.info("Searching product {}", id);

        Product product = repository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException(
                                "Product not found."
                        ));

        return mapper.toResponse(product);

    }

}