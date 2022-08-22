package com.landvibe.summer.mvc.repository;

import com.landvibe.summer.mvc.entity.Product;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.*;

@Repository
public class MemoryProductRepository implements ProductRepository {
    private static final Map<Long, Product> products = new HashMap<>();
    private static long sequence = 0L;

    @Override
    public void save(Product product) {
        product.setId(++sequence);
        product.setCreatedAt(LocalDateTime.now());
        products.put(product.getId(), product);
    }

    @Override
    public Optional<Product> findById(Long id) {
        return Optional.ofNullable(products.get(id));
    }

    @Override
    public Optional<Product> findByName(String name) {
        return products.values().stream()
                .filter(product -> product.getName().equals(name))
                .findAny();
    }

    @Override
    public List<Product> findAll() {
        return new ArrayList<>(products.values());
    }
}