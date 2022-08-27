package com.landvibe.week3.BookServiceSystem.repository;

import com.landvibe.week3.BookServiceSystem.entity.ProductDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductDetailRepository extends JpaRepository<ProductDetail, Long> {
}
