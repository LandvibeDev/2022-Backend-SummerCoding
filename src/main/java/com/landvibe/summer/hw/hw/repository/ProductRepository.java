package com.landvibe.summer.hw.hw.repository;

import com.landvibe.summer.hw.hw.dto.response.ProductDetailResponse;
import com.landvibe.summer.hw.hw.dto.response.ProductListResponse;
import com.landvibe.summer.hw.hw.entity.Category;
import com.landvibe.summer.hw.hw.entity.Product;

import java.util.List;
import java.util.Optional;

public interface ProductRepository {
    Product save(Product product);
    Optional<List<Product>> getProductList();
    Integer getProductListSize();
    Optional<Product> findById(Long id);
    Optional<Product> findByName(String name);
    Optional<ProductDetailResponse> getProductDetail(Product product);
}
