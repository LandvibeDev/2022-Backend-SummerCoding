package com.landvibe.summer.jpa.dto.response;

import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;

@Builder
@Getter
public class GetProductDetailRes {
    private Long id;
    private String name;
    private Long categoryId;
    private String categoryName;
    private String description;
    private LocalDateTime createdAt;
}