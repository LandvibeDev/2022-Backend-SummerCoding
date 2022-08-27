package com.landvibe.summer.mvc.repository;

import com.landvibe.summer.mvc.entity.Product;

import java.util.List;
import java.util.Optional;

public interface ProductRepository {
    void save(Product product);

    Optional<Product> findById(Long id);

    Optional<Product> findByName(String name);

    List<Product> findAll();
}