package com.landvibe.week3.dto;

import com.landvibe.week3.entity.Category;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.util.List;

@Getter
@Builder
@AllArgsConstructor
public class GetCategoryResDto {

    private Integer size;
    private List<Category> categories;

    @Getter
    @Builder
    @AllArgsConstructor
    public static class Category {
        private Long id;
        private String name;
        private Integer count;
    }

    public void convert(com.landvibe.week3.entity.Category categoryEntity) {
        Category category = Category.builder()
                .id(categoryEntity.getId())
                .name(categoryEntity.getName())
                .count(categoryEntity.getProductList().size())
                .build();

        categories.add(category);
    }
}
