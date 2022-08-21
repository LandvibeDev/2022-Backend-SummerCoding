package com.landvibe.week3.repository;

import com.landvibe.week3.entity.Product;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public class MemoryProductRepository implements ProductRepository {

    private final Map<Long, Product> db = new HashMap<>();
    private Long sequence = 0L;

    @Override
    public Product save(Product product) {
        product.setId(++sequence);
        db.put(sequence, product);
        return product;
    }

    @Override
    public Optional<Product> findById(Long id) {
        return Optional.of(db.get(id));
    }

    @Override
    public List<Product> getAll() {
        return new ArrayList<>(db.values());
    }

    @Override
    public boolean existName(String name) {
        return db.values().stream()
                .anyMatch(product -> name.equals(product.getName()));
    }
}
