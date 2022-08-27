package com.landvibe.week3.BookServiceSystem.entity;

import lombok.*;

@Setter
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Category {

    private Long id;
    private String name;
    private Integer count;

}
