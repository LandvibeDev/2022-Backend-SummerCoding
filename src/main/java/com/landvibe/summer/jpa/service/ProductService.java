package com.landvibe.summer.jpa.service;

import com.landvibe.summer.jpa.dto.request.PostProductReq;
import com.landvibe.summer.jpa.dto.response.*;
import com.landvibe.summer.jpa.entity.Category;
import com.landvibe.summer.jpa.entity.Product;
import com.landvibe.summer.jpa.repository.CategoryRepository;
import com.landvibe.summer.jpa.repository.ProductRepository;
import com.landvibe.summer.jpa.util.SecurityUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ProductService {
    private final CategoryRepository categoryRepository;
    private final ProductRepository productRepository;

    @Transactional
    public void save(Product product) {
        productRepository.save(product);
    }

    @Transactional
    public PostCommonRes create(PostProductReq request) {
        Category category = validate(request);
        Product product = insertProduct(request, category);
        return PostCommonRes.builder()
                .code(0)
                .result(PostCommonRes.Result.builder()
                        .id(product.getId())
                        .build())
                .build();
    }

    @Transactional
    public Product insertProduct(PostProductReq request, Category category) {
        String name = SecurityUtil.getCurrentUserId().orElseThrow(() -> new IllegalStateException("user not found"));
        Product product = Product.builder()
                .categoryId(request.getCategoryId())
                .categoryName(category.getName())
                .name(request.getName())
                .description(request.getDescription())
                .sellerId(name)
                .createdAt(LocalDateTime.now().withNano(0))
                .build();
        save(product);

        category.addProduct(product);
        product.mappingCategory(category);
        category.updateCount();
        return product;
    }

    @Transactional
    public GetProductsRes getProducts() {
        List<Product> allProducts = productRepository.findAll();
        List<ProductsRes> products = new ArrayList<>();
        for (Product product : allProducts) {
            ProductsRes productsRes = ProductsRes.builder()
                    .id(product.getId())
                    .categoryId(product.getCategoryId())
                    .name(product.getName())
                    .createdAt(product.getCreatedAt())
                    .build();
            products.add(productsRes);
        }
        return GetProductsRes.builder()
                .size(products.size())
                .products(products)
                .build();
    }

    public GetProductDetailRes getProductDetail(Product product) {
        return GetProductDetailRes.builder()
                .id(product.getId())
                .name(product.getName())
                .categoryId(product.getCategoryId())
                .categoryName(product.getCategoryName())
                .sellerId(product.getSellerId())
                .description(product.getDescription())
                .createdAt(product.getCreatedAt())
                .build();
    }

    @Transactional
    public Product findById(Long id) {
        return productRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("존재하지 않는 상품입니다."));
    }

    @Transactional
    public Category validate(PostProductReq request) {
        if (productRepository.existsByName(request.getName())) {
            throw new IllegalArgumentException("이미 존재하는 상품입니다.");
        }
        Optional<Category> category = categoryRepository.findById(request.getCategoryId());
        if (category.isEmpty()) {
            throw new IllegalArgumentException("존재하지 않는 카테고리입니다.");
        }
        return category.get();
    }
}