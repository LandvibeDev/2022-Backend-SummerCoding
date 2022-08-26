package com.landvive.summer.mvc.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@Builder
@AllArgsConstructor
public class Product {

    private Long id;
    private Long categoryId;
    private String name;
    private String description;
    private LocalDateTime createdAt;

}
