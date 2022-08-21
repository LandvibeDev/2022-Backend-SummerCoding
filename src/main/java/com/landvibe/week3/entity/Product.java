package com.landvibe.week3.entity;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;

@Getter
@Setter
public class Product {

    private Long id;

    private Category category;

    private String name;

    private String description;

    @CreationTimestamp
    private LocalDateTime createTime;

}
