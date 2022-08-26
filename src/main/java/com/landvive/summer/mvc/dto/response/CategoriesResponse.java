package com.landvive.summer.mvc.dto.response;

import com.landvive.summer.mvc.entity.Category;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CategoriesResponse {
    private Integer size;
    private List<Category> categoryList;
}
