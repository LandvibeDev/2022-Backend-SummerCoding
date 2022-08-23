package com.landvibe.summer.reservation.service;

import com.landvibe.summer.reservation.dto.request.CategoryRequest;
import com.landvibe.summer.reservation.entity.Category;
import com.landvibe.summer.reservation.entity.Product;
import com.landvibe.summer.reservation.repository.CategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.ArrayList;

@Service
@RequiredArgsConstructor
public class CategoryService {
    private final CategoryRepository categoryRepository;

    public Long join(CategoryRequest request) {
        if (!validateProduct(request)) {
            return -1L;
        }
        Category newCategory = new Category(request.getName(), null, 0);
        categoryRepository.save(newCategory);
        return newCategory.getCateId();
    }

    public boolean validateProduct(CategoryRequest request) {
        ArrayList<Category> categories = categoryRepository.lookUp();
        for (Category category : categories) {
            if (category.getCateName().equals(request.getName())) {
                return false;
            }
        }
        return true;
    }

    public Category findByName(String name) {
        return categoryRepository.findByName(name)
                .orElseThrow(() -> new IllegalStateException("존재하지 않는 카테고리입니다."));
    }

    public Category findById(Long id){
        return categoryRepository.findById(id)
                .orElseThrow(() -> new IllegalStateException("존재하지 않는 카테고리입니다."));
    }

    public ArrayList lookUp() {
        return categoryRepository.lookUp();
    }
}
