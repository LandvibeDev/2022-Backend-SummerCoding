package com.landvibe.summer.reservation.repository;

import com.landvibe.summer.reservation.entity.Product;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public class MemoryProductRepository implements ProductRepository {
    private static Map<Long, Product> db = new HashMap<>();
    private static Long sequence = 0L;

    @Override
    public Product save(Product product) {
        product.setId(++sequence);
        db.put(product.getId(), product);
        return product;
    }

    @Override
    public Optional<Product> findById(Long id) {
        return Optional.ofNullable(db.get(id));
    }

    @Override
    public Optional<Product> findByName(String name) {
        return db.values().stream()
                .filter(product -> name.equals(product.getName()))
                .findAny();
    }

    @Override
    public ArrayList lookUp() {
        List<Product> productList = new ArrayList<>(db.values());
        return (ArrayList) productList;
    }

    @Override
    public void clearDb() {
        db.clear();
    }
}
