package com.landvibe.week3.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PostProductReqDto {

    private Long categoryId;
    private String name;
    private String description;
}
