package com.landvibe.summer.reservation.repository;

import com.landvibe.summer.reservation.entity.Category;
import com.landvibe.summer.reservation.entity.Product;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public class MemoryCategoryRepository implements CategoryRepository {
    private static List<Category> db = new ArrayList<Category>();
    private static Long sequence = 0L;

    @Override
    public Category save(Category category) {
        category.setCateId(++sequence);
        db.add(category);
        return category;
    }

    @Override
    public ArrayList lookUp() {
        return (ArrayList) db;
    }

    @Override
    public Optional<Category> findByName(String name) {
        return db.stream()
                .filter(product -> name.equals(product.getCateName()))
                .findAny();
    }

    @Override
    public Optional<Category> findById(Long id) {
        return db.stream()
                .filter(product -> id.equals(product.getCateId()))
                .findAny();
    }

    @Override
    public void clearDb() {
        db.clear();
    }

    @Override
    public void plusCategoryCount(Long cateId) {
        for (Category category : db) {
            if (category.getCateId().equals(cateId)) {
                category.setCount(category.getCount() + 1);
            }
        }
    }
}
