package com.landvibe.week3.BookServiceSystem.entity;

import lombok.*;

import java.time.LocalDateTime;
import java.util.Optional;

@Setter
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ProductDetail {

    private Long id;
    private Long categoryId;
    private Optional<String> categoryName;
    private String name;
    private String description;
    private LocalDateTime createdAt;

}
