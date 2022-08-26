package com.landvive.summer.mvc.repository;

import com.landvive.summer.mvc.entity.Category;

import java.util.List;
import java.util.Optional;

public interface CategoryRepository {

    Category save(Category category);
    Optional<Category> findById(Long id);
    Optional<Category> findByName(String name);
    List<Category> findAll();
    void clearDb();
    void plusProductCount(Long id);
}
