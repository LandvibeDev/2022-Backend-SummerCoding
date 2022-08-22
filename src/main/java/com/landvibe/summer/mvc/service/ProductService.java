package com.landvibe.summer.mvc.service;

import com.landvibe.summer.mvc.dto.request.ProductRequest;
import com.landvibe.summer.mvc.entity.Category;
import com.landvibe.summer.mvc.entity.Product;
import com.landvibe.summer.mvc.repository.CategoryRepository;
import com.landvibe.summer.mvc.repository.ProductRepository;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
public class ProductService {
    private final CategoryRepository categoryRepository;
    private final ProductRepository productRepository;

    public Long register(ProductRequest request) {
        if (isExistProduct(request)) {
            return -1L;
        }
        Category category = categoryRepository.findById(request.getCategoryId()).orElse(null);
        if(category == null) {
            throw new IllegalStateException("존재하지 않는 카테고리입니다.");
        }
        Product product = createProduct(request, category);
        productRepository.save(product);
        increaseProductCount(category);

        return product.getId();
    }

    private Product createProduct(ProductRequest request, Category category) {
        Product product = new Product();
        product.setId(null);
        product.setCategoryId(request.getCategoryId());
        product.setName(request.getName());
        product.setCategoryName(category.getName());
        product.setDescription(request.getDescription());
        product.setCreatedAt(null);
        return product;
    }

    private void increaseProductCount(Category category) {
        Integer count = category.getCount();
        category.setCount(count + 1);
    }

    private Boolean isExistProduct(ProductRequest request) {
        return productRepository.findByName(request.getName())
                .isPresent();
    }

    public List<Product> getProducts() {
        return productRepository.findAll();
    }

    public Product findById(Long id) {
        return productRepository.findById(id)
                .orElseThrow(() -> new IllegalStateException("존재하지 않는 상품입니다."));
    }
}