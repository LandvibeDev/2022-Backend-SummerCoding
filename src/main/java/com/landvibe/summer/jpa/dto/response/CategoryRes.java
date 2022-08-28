package com.landvibe.summer.jpa.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class CategoryRes {
    private Long id;
    private String name;
    private Integer count;
}
