package com.landvibe.summer.reservation.dto.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
@AllArgsConstructor
public class ProductRequest {
    private Long categoryId;
    private String name;
    private String description;
}
