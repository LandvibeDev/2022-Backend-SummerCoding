package com.landvibe.summer.hw.hw.repository;

import com.landvibe.summer.hw.hw.entity.Category;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public class MemoryCategoryRepository implements CategoryRepository {
    private static Map<Long, Category> db = new HashMap<>();
    private static Long sequence = 0L;

    @Override
    public Category save(Category category) {
        category.setId(++sequence);
        category.setCount(0);
        db.put(category.getId(), category);
        return category;
    }

    @Override
    public Optional<Category> findById(Long id) {
        return Optional.ofNullable(db.get(id));
    }

    @Override
    public Optional<Category> findByName(String name) {
        return db.values().stream().filter(category -> name.equals(category.getName())).findAny();
    }

    @Override
    public Optional<List<Category>> getCategoryList() {
        List<Category> list = new ArrayList<>();
        db.forEach((key, value) -> list.add(value));
        return Optional.of(list);
    }

    @Override
    public Integer getCategoryListSize() {
        return db.size();
    }

    @Override
    public void addProductCnt(Long id) {
        if(db.get(id) == null){
            throw new IllegalStateException("존재하지 않는 카테고리 ID입니다.");
        }
        db.get(id).setCount(db.get(id).getCount() + 1);
    }
}
