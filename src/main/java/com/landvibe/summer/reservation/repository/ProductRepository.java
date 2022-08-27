package com.landvibe.summer.reservation.repository;

import com.landvibe.summer.reservation.entity.Product;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Optional;

@Repository
public interface ProductRepository {
    Product save(Product product);

    Optional<Product> findById(Long id);

    Optional<Product> findByName(String name);

    ArrayList lookUp();

    void clearDb();

}
