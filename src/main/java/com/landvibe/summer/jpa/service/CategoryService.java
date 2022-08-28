package com.landvibe.summer.jpa.service;

import com.landvibe.summer.jpa.dto.request.PostCategoryReq;
import com.landvibe.summer.jpa.dto.response.CategoryRes;
import com.landvibe.summer.jpa.dto.response.GetCategoriesRes;
import com.landvibe.summer.jpa.dto.response.PostCategoryRes;
import com.landvibe.summer.jpa.entity.Category;
import com.landvibe.summer.jpa.repository.CategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class CategoryService {
    private final CategoryRepository categoryRepository;

    @Transactional
    public void save(Category category) {
        categoryRepository.save(category);
    }

    public PostCategoryRes create(PostCategoryReq request) {
        if (isDuplicateName(request)) {
            return new PostCategoryRes(-1, null);
        }
        Category category = insertCategory(request);
        Map<String, Long> result = new HashMap<>();
        result.put("id", category.getId());
        return new PostCategoryRes(0, result);
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
    public Boolean isDuplicateName(PostCategoryReq request) {
        return categoryRepository.existsByName(request.getName());
    }

    @Transactional
    public GetCategoriesRes getCategories() {
        List<Category> allCategories = categoryRepository.findAll();
        List<CategoryRes> categories = new ArrayList<>();
        for (Category category : allCategories) {
            categories.add(new CategoryRes(
                    category.getId(),
                    category.getName(),
                    category.getCount())
            );
        }
        return new GetCategoriesRes(categories.size(), categories);
    }
}