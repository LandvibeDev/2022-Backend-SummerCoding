package com.landvibe.summer.reservation.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
public class Product {
    private Long categoryId;
    private String name;
    private String description;
    private Long id;
    private LocalDateTime createdAt;

}
