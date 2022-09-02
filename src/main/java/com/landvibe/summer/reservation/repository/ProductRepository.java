package com.landvibe.summer.reservation.repository;

import com.landvibe.summer.reservation.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
