package com.landvibe.summer.reservation.service;

import com.landvibe.summer.reservation.dto.request.CategoryRequest;
import com.landvibe.summer.reservation.entity.Category;
import com.landvibe.summer.reservation.dto.response.CategoryDetail;
import com.landvibe.summer.reservation.repository.CategoryRepository;
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
    public void save(Category request) {
        categoryRepository.save(request);
    }

    public Long create(CategoryRequest request) {
        Category category = Category.builder()
                .cateName(request.getName())
                .build();
        validate(category);
        save(category);
        return category.getCateId();
    }

    public List<CategoryDetail> getCategories() {
        List<Category> categories = categoryRepository.findAll();
        List<CategoryDetail> cateDetails = new ArrayList<>();
        for (int i = 0; i < categories.size(); i++) {
            Category category = categories.get(i);
            CategoryDetail categoryDetail = CategoryDetail.builder()
                    .id(category.getCateId())
                    .name(category.getCateName())
                    .count(category.size())
                    .build();
            cateDetails.add(categoryDetail);
        }
        return cateDetails;
    }

    public void validate(Category category) throws IllegalStateException {
        List<Category> categories = categoryRepository.findAll();
        for (int i = 0; i < categories.size(); i++) {
            if (categories.get(i).getCateName().equals(category.getCateName())) {
                throw new IllegalStateException("이미 존재하는 카테고리입니다.");
            }
        }
    }
}
