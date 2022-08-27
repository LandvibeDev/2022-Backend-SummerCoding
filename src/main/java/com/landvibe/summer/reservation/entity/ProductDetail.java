package com.landvibe.summer.reservation.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@Builder
public class ProductDetail {
    private Long categoryId;
    private String categoryName;
    private String name;
    private String description;
    private Long id;
    private LocalDateTime createdAt;
}
