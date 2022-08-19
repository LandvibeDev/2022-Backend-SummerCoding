package com.landvibe.summer.reservation.repository;

import com.landvibe.summer.reservation.entity.Category;
import com.landvibe.summer.reservation.entity.Product;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Optional;

@Repository
public interface CategoryRepository {
    Category save(Category category);

    ArrayList lookUp();

    Optional<Category> findByName(String name);

    void clearDb();

    void plusCategoryCount(Long cateId);

}
