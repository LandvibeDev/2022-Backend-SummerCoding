package com.landvive.summer.mvc.repository;

import com.landvive.summer.mvc.entity.Category;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public class MemoryCategoryRepository implements CategoryRepository {
    private static List<Category> db = new ArrayList<>();
    private static Long sequence = 0L;

    @Override
    public Category save(Category category) {
        category.setId(++sequence);
        db.add(category);
        return category;
    }

    @Override
    public Optional<Category> findById(Long id) {
        return db.stream()
                .filter(category -> id.equals(category.getId()))
                .findAny(); //찾으면 던져라
    }

    @Override
    public Optional<Category> findByName(String name) {
        return db.stream()
                .filter(category -> name.equals(category.getName()))
                .findAny(); //찾으면 던져라
    }

    @Override
    public List<Category> findAll() {
        return (List) db;
    }

    @Override
    public void clearDb() {
        db.clear();
    }

    @Override
    public void plusProductCount(Long id) {
        for (Category category : db) {
            if (category.getId().equals(id)) {
                category.setCount(category.getCount() + 1);
            }
        }
    }

}
