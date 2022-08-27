package com.landvibe.week3.BookServiceSystem.service;

import com.landvibe.week3.BookServiceSystem.dto.Req.ProductReq;
import com.landvibe.week3.BookServiceSystem.entity.Category;
import com.landvibe.week3.BookServiceSystem.entity.Product;
import com.landvibe.week3.BookServiceSystem.entity.ProductDetail;
import com.landvibe.week3.BookServiceSystem.repository.CategoryRepository;
import com.landvibe.week3.BookServiceSystem.repository.ProductDetailRepository;
import com.landvibe.week3.BookServiceSystem.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDateTime;
import java.util.*;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final CategoryRepository categoryRepository;
    private final ProductRepository productRepository;

    private Long sequence = 0L;

    private final ProductDetailRepository productDetailRepository;

    private final List<Product> productList
            = new ArrayList<>();


    @Transactional
    public void saveToDb(Product product) {
        productRepository.save(product);
    }

    @Transactional
    public void saveToDb2(ProductDetail productDetail) {
        productDetailRepository.save(productDetail);
    }

    @Transactional
    public Map<Integer, Long> join(ProductReq productReq) {

        Integer successCode = validateDuplicatedProduct(productReq);

        Map<Integer, Long> productCodeAndResult1 = IsPossiblePost(successCode);
        if (productCodeAndResult1 != null) return productCodeAndResult1;

        Product product = Product.builder()
                .id(++sequence)
                .categoryId(productReq.getCategoryId())
                .name(productReq.getName())
                .createdAt(LocalDateTime.now().withNano(0))
                .build();
        saveToDb(product);

        ProductDetail productDetail = ProductDetail.builder()
                .id(sequence)
                .categoryId(productReq.getCategoryId())
                .categoryName(findCategoryNameById(productReq.getCategoryId()))
                .name(productReq.getName())
                .description(productReq.getDescription())
                .createdAt(LocalDateTime.now().withNano(0))
                .build();
        saveToDb2(productDetail);

        categoryCountIncrement(product);
        Map<Integer, Long> productCodeAndResult = new HashMap<>() {{
            put(successCode, product.getId());
        }};
        productList.add(product);

        return productCodeAndResult;
    }

    @Transactional
    public Integer validateDuplicatedProduct(ProductReq productReq) {

        if (productRepository.getReferenceByName(productReq.getName())
                .isPresent())
            return -1;
        else
            return 0;
    }

    @Transactional
    public Map<Integer, Long> IsPossiblePost(Integer successCode) {
        if (successCode == -1) {
            return new HashMap<>() {{
                put(successCode, null);
            }};
        }
        return null;
    }

    public String findCategoryNameById(Long id) {

        return categoryRepository.getReferenceById(id).getName();

    }

    public ProductDetail findById(Long id) {

        return productDetailRepository.getReferenceById(id);

    }

    public void categoryCountIncrement(Product product) {

        Category category = categoryRepository.getReferenceById(product.getCategoryId());
        category.setCount(category.getCount() + 1);

    }

    @Transactional
    public List<Product> getProductList() {
        return productList;
    }

    @Transactional
    public Integer getProductSize() {
        return productList.size();
    }
}
