package com.landvibe.week3.repository;

import com.landvibe.week3.entity.Product;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProductRepository {

    Product save(Product product);

    Optional<Product> findById(Long id);

    List<Product> getAll();

    boolean existName(String name);
}
