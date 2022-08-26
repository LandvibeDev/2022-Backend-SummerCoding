package com.landvibe.summer.hw.hw.dto.response;

import com.landvibe.summer.hw.hw.entity.Category;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
import java.util.Optional;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CategoryListResponse {
    private Integer sz;
    private Optional<List<Category>> categoryList;
}
