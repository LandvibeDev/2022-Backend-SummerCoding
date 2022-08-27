package com.landvibe.week3.BookServiceSystem.repository;

import com.landvibe.week3.BookServiceSystem.entity.Product;
import com.landvibe.week3.BookServiceSystem.entity.ProductDetail;

import java.util.Optional;

public interface ProductRepository {

    Product save(Product product);

    ProductDetail saveDetail(ProductDetail productDetail);

    Optional<Product> findByProductName(String name);

    Optional<ProductDetail> findByProductId(Long id);

}
