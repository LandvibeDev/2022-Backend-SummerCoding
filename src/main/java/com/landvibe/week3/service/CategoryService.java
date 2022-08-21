package com.landvibe.week3.service;

import com.landvibe.week3.dto.GetCategoryResDto;
import com.landvibe.week3.dto.PostCommonResDto;
import com.landvibe.week3.entity.Category;
import com.landvibe.week3.repository.CategoryRepository;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CategoryService {

    private final CategoryRepository categoryRepository;

    public PostCommonResDto create(String name) {
        validate(name);

        Category category = new Category();
        category.setName(name);
        categoryRepository.save(category);

        return PostCommonResDto.builder()
                .code(0)
                .result(PostCommonResDto.Result.builder()
                        .id(category.getId())
                        .build())
                .build();
    }

    private void validate(String name) {
        if (name == null)
            throw new IllegalArgumentException("Name Cannot Be Null");

        if (categoryRepository.existName(name))
            throw new IllegalArgumentException("Already Exist Name");
    }

    public GetCategoryResDto getAllCategories() {
        List<Category> categories = categoryRepository.getAll();

        GetCategoryResDto resDto = GetCategoryResDto.builder()
                .size(categories.size())
                .categories(new ArrayList<>())
                .build();

        categories.forEach(resDto::convert);

        return resDto;
    }
}
