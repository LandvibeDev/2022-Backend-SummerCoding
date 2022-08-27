package com.landvibe.week3.BookServiceSystem.repository;

import com.landvibe.week3.BookServiceSystem.entity.Category;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public class MemoryCategoryRepository implements CategoryRepository {

    private static Map<Long, Category> categoryDb = new HashMap<>();

    private static Long categorySeq = 0L;

    @Override
    public Category save(Category category) {
        category.setId(++categorySeq);
        category.setCount(0);
        categoryDb.put(category.getId(), category);
        return category;
    }

    @Override
    public Optional<Category> findByCategoryId(Long id) {
        return categoryDb.values().stream()
                .filter(category -> id.equals(category.getId()))
                .findAny();
    }

    @Override
    public Optional<Category> findByCategoryName(String name) {
        return categoryDb.values().stream()
                .filter(category -> name.equals(category.getName()))
                .findAny();
    }

    @Override
    public Optional<String> findNameByCategoryId(Long id) {
        return categoryDb.values().stream()
                .filter(category -> id.equals(category.getId()))
                .map(Category::getName)
                .findAny();
    }
}
