package com.landvibe.week3.repository;

import com.landvibe.week3.entity.Category;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CategoryRepository {

    Category save(Category category);

    Optional<Category> findById(Long id);

    List<Category> getAll();

    boolean existName(String name);
}
