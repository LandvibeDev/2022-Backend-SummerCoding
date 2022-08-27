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
public class ProductsRes {
    private Long id;
    private Long categoryId;
    private String name;
    private LocalDateTime createdAt;
}
