package com.landvibe.summer.hw.hw.repository;

import com.landvibe.summer.hw.hw.dto.response.ProductDetailResponse;
import com.landvibe.summer.hw.hw.entity.Category;
import com.landvibe.summer.hw.hw.entity.Product;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.*;

@RequiredArgsConstructor
@Repository
public class MemoryProductRepository implements ProductRepository{
    private static Map<Long, Product> db = new HashMap<>();
    private final MemoryCategoryRepository categoryRepository;
    private static Long sequence = 0L;

    @Override
    public Product save(Product product) {
        product.setId(sequence++);
        product.setCreatedAt(LocalDateTime.now());

        db.put(product.getId(), product);

        categoryRepository.addProductCnt(product.getCategoryId());

        return product;
    }

    @Override
    public Optional<Product> findById(Long id) {
        return Optional.ofNullable(db.get(id));
    }

    @Override
    public Optional<Product> findByName(String name) {
        return db.values().stream().filter(product -> name.equals(product.getName())).findAny();
    }

    @Override
    public Optional<ProductDetailResponse> getProductDetail(Product product) {
        Optional<Category> category = categoryRepository.findById(product.getCategoryId());
        String catName = category.get().getName();
        return Optional.of(new ProductDetailResponse(product.getId(), product.getCategoryId(), catName, product.getName(), product.getDescription(), product.getCreatedAt()));
    }

    @Override
    public Optional<List<Product>> getProductList() {
        List<Product> list = new ArrayList<>();
        db.forEach((key, value) -> list.add(value));
        return Optional.of(list);
    }

    @Override
    public Integer getProductListSize() {
        return db.size();
    }
}
