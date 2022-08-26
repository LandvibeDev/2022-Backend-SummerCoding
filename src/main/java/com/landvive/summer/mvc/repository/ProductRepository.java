package com.landvive.summer.mvc.repository;

import com.landvive.summer.mvc.entity.Category;
import com.landvive.summer.mvc.entity.Product;

import java.util.List;
import java.util.Optional;

public interface ProductRepository {

    Product save(Product product);
    Optional<Product> findById(Long id);
    Optional<Product> findByName(String name);
    Optional<Product> findByCategoryId(Long categoryId);
    List<Product> findAll();
    void clearDb();
}

