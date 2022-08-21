package com.landvibe.week3.repository;

import com.landvibe.week3.entity.Category;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public class MemoryCategoryRepository implements CategoryRepository{

    private static Map<Long, Category> db = new HashMap<>();
    private static Long sequence = 0L;

    @Override
    public Category save(Category category) {
        category.setId(++sequence);
        db.put(sequence, category);
        return category;
    }

    @Override
    public Optional<Category> findById(Long id) {
        return Optional.ofNullable(db.get(id));
    }

    @Override
    public List<Category> getAll() {
        return new ArrayList<>(db.values());
    }

    @Override
    public boolean existName(String name) {
        return db.values().stream()
                .anyMatch(category -> name.equals(category.getName()));
    }
}
