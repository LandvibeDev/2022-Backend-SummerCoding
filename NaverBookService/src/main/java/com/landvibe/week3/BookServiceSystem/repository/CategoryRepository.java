package com.landvibe.week3.BookServiceSystem.repository;

import com.landvibe.week3.BookServiceSystem.entity.Category;

import java.util.Optional;

public interface CategoryRepository {

    Category save(Category category);

    Optional<Category> findByCategoryId(Long id);

    Optional<Category> findByCategoryName(String name);

    Optional<String> findNameByCategoryId(Long id);


}
