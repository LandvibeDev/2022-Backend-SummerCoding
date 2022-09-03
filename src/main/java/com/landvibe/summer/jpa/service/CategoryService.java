package com.landvibe.summer.jpa.service;

import com.landvibe.summer.jpa.dto.request.PostCategoryReq;
import com.landvibe.summer.jpa.dto.response.CategoryRes;
import com.landvibe.summer.jpa.dto.response.GetCategoriesRes;
import com.landvibe.summer.jpa.dto.response.PostCommonRes;
import com.landvibe.summer.jpa.entity.Category;
import com.landvibe.summer.jpa.repository.CategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CategoryService {
    private final CategoryRepository categoryRepository;

    @Transactional
    public void save(Category category) {
        categoryRepository.save(category);
    }

    public PostCommonRes create(PostCategoryReq request) {
        validate(request);
        Category category = insertCategory(request);
        return PostCommonRes.builder()
                .code(0)
                .result(PostCommonRes.Result.builder()
                        .id(category.getId())
                        .build())
                .build();
    }

    @Transactional
    public Category insertCategory(PostCategoryReq request) {
        Category category = Category.builder()
                .name(request.getName())
                .build();
        save(category);
        return category;
    }

    @Transactional
    public GetCategoriesRes getCategories() {
        List<Category> allCategories = categoryRepository.findAll();
        List<CategoryRes> categories = new ArrayList<>();
        for (Category category : allCategories) {
            categories.add(CategoryRes.builder()
                    .id(category.getId())
                    .name(category.getName())
                    .count(category.getCount())
                    .build());
        }
        return GetCategoriesRes.builder()
                .size(categories.size())
                .categories(categories)
                .build();
    }

    @Transactional
    public void validate(PostCategoryReq request) {
        if (categoryRepository.existsByName(request.getName())) {
            throw new IllegalArgumentException("이미 존재하는 카테고리입니다.");
        }
    }
}