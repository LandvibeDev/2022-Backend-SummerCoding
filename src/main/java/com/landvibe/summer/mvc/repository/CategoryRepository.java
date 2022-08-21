package com.landvibe.summer.mvc.repository;

import com.landvibe.summer.mvc.entity.Category;

import java.util.List;
import java.util.Optional;

public interface CategoryRepository {
    void save(Category category);

    Optional<Category> findById(Long id);

    Optional<Category> findByName(String name);

    List<Category> findAll();
}