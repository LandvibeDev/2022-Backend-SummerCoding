package com.landvive.summer.mvc.repository;

import com.landvive.summer.mvc.entity.Category;
import com.landvive.summer.mvc.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface ProRepository extends JpaRepository<Product, Long> {

    @Query(value = "SELECT p FROM Product p WHERE p.name = : name")
    Optional<Product> findByName2(String name);
}