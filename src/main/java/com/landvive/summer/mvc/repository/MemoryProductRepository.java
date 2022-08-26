package com.landvive.summer.mvc.repository;

import com.landvive.summer.mvc.entity.Category;
import com.landvive.summer.mvc.entity.Product;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public class MemoryProductRepository implements ProductRepository {
    private static List<Product> db = new ArrayList<>();
    private static Long sequence = 0L;

    @Override
    public Product save(Product product) {
        product.setId(++sequence);
        db.add(product);
        return product;
    }

    @Override
    public Optional<Product> findById(Long id) {
        return db.stream()
                .filter(product -> id.equals(product.getId()))
                .findAny();
    }

    @Override
    public Optional<Product> findByName(String name) {
        return db.stream()
                .filter(product -> name.equals(product.getName()))
                .findAny(); //찾으면 던져라

    }

    @Override
    public Optional<Product> findByCategoryId(Long categoryId) {
        return db.stream()
                .filter(product -> categoryId.equals(product.getCategoryId()))
                .findAny(); //찾으면 던져라

    }

    @Override
    public List<Product> findAll() {
        return (List)db;
    }

    @Override
    public void clearDb() {
        db.clear();
    }
}
