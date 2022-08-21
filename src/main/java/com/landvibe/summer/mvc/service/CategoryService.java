package com.landvibe.summer.mvc.service;

import com.landvibe.summer.mvc.dto.request.CategoryRequest;
import com.landvibe.summer.mvc.entity.Category;
import com.landvibe.summer.mvc.repository.CategoryRepository;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
public class CategoryService {
    private final CategoryRepository categoryRepository;

    public Long register(CategoryRequest request) {
        if (getCategory(request)) {
            return -1L;
        }
        Category category = createCategory(request);
        categoryRepository.save(category);
        return category.getId();
    }

    private Category createCategory(CategoryRequest request) {
        return new Category(null, request.getName(), null);
    }

    private Boolean getCategory(CategoryRequest request) {
        return categoryRepository.findByName(request.getName())
                .isPresent();
    }

    public List<Category> getCategories() {
        return categoryRepository.findAll();
    }
}