package com.landvibe.summer.hw.hw.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;


@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Product {
    private Long id;
    private Long categoryId;
    private String name;
    private String description;
    private LocalDateTime createdAt;
}
