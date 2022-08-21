package com.landvibe.week3.dto;

import com.landvibe.week3.entity.Product;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
@AllArgsConstructor
@Builder
public class GetProductDetailResDto {

    private Product product;

    @Getter
    public static class Product {
        private Long id;
        private Long categoryId;
        private String categoryName;
        private String name;
        private String description;
        private LocalDateTime createdAt;

        public Product(com.landvibe.week3.entity.Product product) {
            this.id = product.getId();
            this.categoryId = product.getCategory().getId();
            this.categoryName = product.getCategory().getName();
            this.name = product.getName();
            this.description = product.getDescription();
            this.createdAt = product.getCreateTime();
        }
    }
}
