package com.landvibe.week3.BookServiceSystem.entity;

import lombok.*;

import java.time.LocalDateTime;

@Setter
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Product {

    private Long id;
    private Long categoryId;
    private String name;
    private LocalDateTime createdAt;

}
