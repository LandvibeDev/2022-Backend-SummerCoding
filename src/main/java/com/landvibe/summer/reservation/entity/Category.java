package com.landvibe.summer.reservation.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class Category {
    private String cateName;
    private Long cateId;
    private Integer count;
}
