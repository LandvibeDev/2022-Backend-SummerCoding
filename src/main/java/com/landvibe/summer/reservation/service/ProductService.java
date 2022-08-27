package com.landvibe.summer.reservation.service;

import com.landvibe.summer.reservation.dto.request.ProductRequest;
import com.landvibe.summer.reservation.entity.Product;
import com.landvibe.summer.reservation.repository.CategoryRepository;
import com.landvibe.summer.reservation.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;

@Service
@RequiredArgsConstructor
public class ProductService {
    private final ProductRepository productRepository;
    private final CategoryRepository categoryRepository;

    public Long join(ProductRequest request) {
        if (!validateProduct(request)) {
            return -1L;
        }
        Product newProduct = Product.builder()
                .categoryId(request.getCategoryId())
                .name(request.getName())
                .description(request.getDescription())
                .createdAt(LocalDateTime.now())
                .build();
        productRepository.save(newProduct);
        categoryRepository.plusCategoryCount(request.getCategoryId());
        return newProduct.getId();
    }

    public boolean validateProduct(ProductRequest request) {
        ArrayList<Product> products = productRepository.lookUp();
        for (Product product : products) {
            if (product.getName().equals(request.getName())) {
                return false;
            }
        }
        return true;
    }

    public Product findByName(String name) {
        return productRepository.findByName(name)
                .orElseThrow(() -> new IllegalStateException("존재하지 않는 회원입니다."));
    }

    public Product findById(Long id) {
        return productRepository.findById(id)
                .orElseThrow(() -> new IllegalStateException("존재하지 않는 회원입니다."));
    }

    public ArrayList lookUp() {
        return productRepository.lookUp();
    }
}
