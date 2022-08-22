package com.landvibe.summer.mvc.repository;

import com.landvibe.summer.mvc.entity.Product;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.*;

@Repository
public class MemoryProductRepository implements ProductRepository {
    private static final Map<Long, Product> productDb = new HashMap<>();
    private static long sequence = 0L;

    @Override
    public void save(Product product) {
        product.setId(++sequence);
        product.setCreatedAt(LocalDateTime.now().withNano(0));
        productDb.put(product.getId(), product);
    }

    @Override
    public Optional<Product> findById(Long id) {
        return Optional.ofNullable(productDb.get(id));
    }

    @Override
    public Optional<Product> findByName(String name) {
        return productDb.values().stream()
                .filter(product -> product.getName().equals(name))
                .findAny();
    }

    @Override
    public List<Product> findAll() {
        return new ArrayList<>(productDb.values());
    }
}