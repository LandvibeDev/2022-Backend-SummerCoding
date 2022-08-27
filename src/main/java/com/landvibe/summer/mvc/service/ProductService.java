package com.landvibe.summer.mvc.service;

import com.landvibe.summer.mvc.dto.request.PostProductReq;
import com.landvibe.summer.mvc.dto.response.ProductInfoExceptDescription;
import com.landvibe.summer.mvc.entity.Category;
import com.landvibe.summer.mvc.entity.Product;
import com.landvibe.summer.mvc.repository.CategoryRepository;
import com.landvibe.summer.mvc.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductService {
    private final CategoryRepository categoryRepository;
    private final ProductRepository productRepository;

    public Long register(PostProductReq request) {
        if (isExistProduct(request)) {
            return -1L;
        }
        Category category = categoryRepository.findById(request.getCategoryId()).orElse(null);
        if (category == null) {
            throw new IllegalStateException("존재하지 않는 카테고리입니다.");
        }
        Product product = createProduct(request, category);
        productRepository.save(product);
        increaseProductCount(category);

        return product.getId();
    }

    private Product createProduct(PostProductReq request, Category category) {
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

    private Boolean isExistProduct(PostProductReq request) {
        return productRepository.findByName(request.getName())
                .isPresent();
    }

    public List<ProductInfoExceptDescription> getProducts() {
        List<Product> products = productRepository.findAll();
        List<ProductInfoExceptDescription> list = new ArrayList<>();
        for (Product product : products) {
            list.add(createProductInfoExceptDescription(product));
        }
        return list;
    }

    public Product findById(Long id) {
        return productRepository.findById(id)
                .orElseThrow(() -> new IllegalStateException("존재하지 않는 상품입니다."));
    }

    private ProductInfoExceptDescription createProductInfoExceptDescription(Product product) {
        ProductInfoExceptDescription productInfoExceptDescription = new ProductInfoExceptDescription();
        productInfoExceptDescription.setId(product.getId());
        productInfoExceptDescription.setCategoryId(product.getCategoryId());
        productInfoExceptDescription.setCategoryName(product.getCategoryName());
        productInfoExceptDescription.setName(product.getName());
        productInfoExceptDescription.setCreatedAt(product.getCreatedAt());
        return productInfoExceptDescription;
    }
}