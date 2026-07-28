package com.devflow.pay.product.entity;

import com.devflow.pay.common.entity.BaseEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@Entity
@Table(name = "products")
public class Product extends BaseEntity {

    @Column(nullable = false, length = 120)
    private String name;

    @Column(length = 600)
    private String description;

    @Column(nullable = false, unique = true, length = 60)
    private String sku;

    @Column(nullable = false, precision = 10, scale = 2)
    private BigDecimal price;

    @Column(nullable = false)
    private Integer stock = 0;

    @Column(nullable = false)
    private Boolean active = true;

    @Column(name = "image_url")
    private String imageUrl;

    @Column(length = 50)
    private String category;

}