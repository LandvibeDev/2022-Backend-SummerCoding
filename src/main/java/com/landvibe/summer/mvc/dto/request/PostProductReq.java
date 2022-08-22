package com.landvibe.summer.mvc.dto.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PostProductReq {
    private Long categoryId;
    private String name;
    private String description;
}