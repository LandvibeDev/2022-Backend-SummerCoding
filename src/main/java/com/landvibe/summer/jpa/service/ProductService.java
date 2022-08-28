package com.landvibe.summer.jpa.service;

import com.landvibe.summer.jpa.dto.request.PostProductReq;
import com.landvibe.summer.jpa.dto.response.GetProductDetailRes;
import com.landvibe.summer.jpa.dto.response.GetProductsRes;
import com.landvibe.summer.jpa.dto.response.PostProductRes;
import com.landvibe.summer.jpa.dto.response.ProductsRes;
import com.landvibe.summer.jpa.entity.Category;
import com.landvibe.summer.jpa.entity.Product;
import com.landvibe.summer.jpa.repository.CategoryRepository;
import com.landvibe.summer.jpa.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
    public PostProductRes create(PostProductReq request) {
        Category category = getCategory(request);
        if (category == null) {
            throw new IllegalStateException("존재하지 않는 카테고리입니다.");
        }
        if (isDuplicateName(request)) {
            return new PostProductRes(-1, null);
        }
        Product product = insertProduct(request, category);

        Map<String, Long> result = new HashMap<>();
        result.put("id", product.getId());
        return new PostProductRes(0, result);
    }

    @Transactional
    public Category getCategory(PostProductReq request) {
        return categoryRepository.findById(request.getCategoryId())
                .orElse(null);
    }

    @Transactional
    public Product insertProduct(PostProductReq request, Category category) {
        Product product = Product.builder()
                .categoryId(request.getCategoryId())
                .categoryName(category.getName())
                .name(request.getName())
                .description(request.getDescription())
                .createdAt(LocalDateTime.now().withNano(0))
                .build();
        save(product);

        category.addProduct(product);
        product.mappingCategory(category);
        category.updateCount();
        return product;
    }

    @Transactional
    public Boolean isDuplicateName(PostProductReq request) {
        return productRepository.existsByName(request.getName());
    }

    @Transactional
    public GetProductsRes getProducts() {
        List<Product> allProducts = productRepository.findAll();
        List<ProductsRes> products = new ArrayList<>();
        for (Product product : allProducts) {
            ProductsRes productsRes = new ProductsRes(
                    product.getId(),
                    product.getCategoryId(),
                    product.getName(),
                    product.getCreatedAt()
            );
            products.add(productsRes);
        }
        return new GetProductsRes(products.size(), products);
    }

    public GetProductDetailRes getProductDetail(Product product) {
        return new GetProductDetailRes(
                product.getId(),
                product.getName(),
                product.getId(),
                product.getCategoryName(),
                product.getDescription(),
                product.getCreatedAt()
        );
    }

    @Transactional
    public Product findById(Long id) {
        return productRepository.findById(id)
                .orElseThrow(() -> new IllegalStateException("존재하지 않는 상품입니다."));
    }
}