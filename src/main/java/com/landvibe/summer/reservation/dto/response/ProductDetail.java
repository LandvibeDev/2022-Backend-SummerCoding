package com.landvibe.summer.reservation.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
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
