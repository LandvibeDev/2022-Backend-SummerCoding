package com.landvibe.summer.jpa.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class GetProductDetailRes {
    private Long id;
    private String name;
    private Long categoryId;
    private String categoryName;
    private String description;
    private LocalDateTime createdAt;
}