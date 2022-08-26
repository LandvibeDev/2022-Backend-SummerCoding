package com.landvibe.summer.hw.hw.repository;

import com.landvibe.summer.hw.hw.dto.response.ProductListResponse;
import com.landvibe.summer.hw.hw.entity.Category;

import java.util.List;
import java.util.Optional;

public interface CategoryRepository {
    Category save(Category category);
    Optional<Category> findById(Long id);
    Optional<Category> findByName(String name);
    Optional<List<Category>> getCategoryList();
    Integer getCategoryListSize();
    void addProductCnt(Long id);
}
