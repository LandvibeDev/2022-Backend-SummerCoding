package com.landvibe.summer.jpa.dto.response;

import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;

@Builder
@Getter
public class ProductsRes {
    private Long id;
    private Long categoryId;
    private String name;
    private LocalDateTime createdAt;
}
