package com.landvive.summer.mvc.dto.response;

import com.landvive.summer.mvc.dto.request.CategoryRequest;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Map;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CategoryResponse {
    private Integer code;
    private CategoryRequest result;
    //private String result;
}
