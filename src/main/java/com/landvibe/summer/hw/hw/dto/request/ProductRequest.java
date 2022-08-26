package com.landvibe.summer.hw.hw.dto.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class ProductRequest {
    private Long categoryId;
    private String name;
    private String description;
}
