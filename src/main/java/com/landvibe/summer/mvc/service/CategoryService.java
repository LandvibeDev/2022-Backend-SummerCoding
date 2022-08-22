package com.landvibe.summer.mvc.service;

import com.landvibe.summer.mvc.dto.request.PostCategoryReq;
import com.landvibe.summer.mvc.entity.Category;
import com.landvibe.summer.mvc.repository.CategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CategoryService {
    private final CategoryRepository categoryRepository;

    public Long register(PostCategoryReq request) {
        if (isExistCategory(request)) {
            return -1L;
        }
        Category category = createCategory(request);
        categoryRepository.save(category);
        return category.getId();
    }

    private Category createCategory(PostCategoryReq request) {
        return new Category(null, request.getName(), null);
    }

    private Boolean isExistCategory(PostCategoryReq request) {
        return categoryRepository.findByName(request.getName())
                .isPresent();
    }

    public List<Category> getCategories() {
        return categoryRepository.findAll();
    }
}