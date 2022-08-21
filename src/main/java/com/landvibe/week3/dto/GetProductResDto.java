package com.landvibe.week3.dto;

import com.landvibe.week3.entity.Product;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@AllArgsConstructor
@Builder
public class GetProductResDto {
    private Integer size;
    private List<Product> products;

    @Getter
    @AllArgsConstructor
    @Builder
    public static class Product {
        private Long id;
        private Long categoryId;
        private String name;
        private LocalDateTime createdAt;
    }

    public void convert(com.landvibe.week3.entity.Product productEntity) {
        Product product = Product.builder()
                .id(productEntity.getId())
                .categoryId(productEntity.getCategory().getId())
                .name(productEntity.getName())
                .createdAt(productEntity.getCreateTime())
                .build();

        products.add(product);
    }
}
