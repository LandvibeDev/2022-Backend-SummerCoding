package com.landvibe.week3.BookServiceSystem.repository;

import com.landvibe.week3.BookServiceSystem.entity.Category;
import com.landvibe.week3.BookServiceSystem.entity.Product;
import com.landvibe.week3.BookServiceSystem.entity.ProductDetail;
import org.springframework.stereotype.Repository;

import java.rmi.registry.LocateRegistry;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@Repository
public class MemoryProductRepository implements ProductRepository {

    private static Map<Long, Product> productDb = new HashMap<>();
    private static Map<Long, ProductDetail> productDetailDb = new HashMap<>();
    private static Long productSeq = 0L;

    @Override
    public Product save(Product product) {
        product.setId(++productSeq);
        product.setCreatedAt(LocalDateTime.now().withNano(0));
        productDb.put(product.getId(), product);
        return product;
    }

    @Override
    public ProductDetail saveDetail(ProductDetail productDetail) {
        productDetail.setId(productSeq);
        productDetail.setCreatedAt(LocalDateTime.now().withNano(0));
        productDetailDb.put(productDetail.getId(), productDetail);
        return productDetail;
    }

    @Override
    public Optional<ProductDetail> findByProductId(Long id) {
        return productDetailDb.values().stream()
                .filter(productDetail -> id.equals(productDetail.getId()))
                .findAny();
    }

    @Override
    public Optional<Product> findByProductName(String name) {
        return productDb.values().stream()
                .filter(product -> name.equals(product.getName()))
                .findAny();
    }
}
