package com.devflow.pay.product.mapper;

import com.devflow.pay.product.dto.ProductRequest;
import com.devflow.pay.product.dto.ProductResponse;
import com.devflow.pay.product.entity.Product;
import org.springframework.stereotype.Component;

@Component
public class ProductMapper {

    public Product toEntity(ProductRequest request) {

        Product product = new Product();

        product.setName(request.name());
        product.setDescription(request.description());
        product.setPrice(request.price());
        product.setStock(request.stock());

        return product;
    }

    public ProductResponse toResponse(Product product) {

        return new ProductResponse(
                product.getId(),
                product.getName(),
                product.getDescription(),
                product.getPrice(),
                product.getStock()
        );
    }

    public void update(Product product, ProductRequest request){

        product.setName(request.name());
        product.setDescription(request.description());
        product.setPrice(request.price());
        product.setStock(request.stock());

    }

}