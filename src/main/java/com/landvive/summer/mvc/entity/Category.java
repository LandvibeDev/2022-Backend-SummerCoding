package com.landvive.summer.mvc.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
@AllArgsConstructor
public class Category {

    private Long id;
    private String name;
    private Long count; //해당 카테고리의 Product 개수
}
