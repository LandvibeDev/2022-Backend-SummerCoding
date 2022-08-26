package com.landvive.summer.mvc.repository;

import com.landvive.summer.mvc.entity.Category;
import com.landvive.summer.mvc.entity.Product;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;


import static org.junit.jupiter.api.Assertions.*;

class MemoryProductRepositoryTest {

    ProductRepository productRepository = new MemoryProductRepository();

    @Test
    void save() {

    }

    @Test
    void 상품목록_조회() {
        //given
        Product product1 = new Product(1L, 1L, "인간 전시회", "전시회이다", LocalDateTime.now());
        Product product2 = new Product(2L, 1L, "인간 박람회", "박람회이다", LocalDateTime.now());

        //when
        productRepository.save(product1);
        productRepository.save(product2);

        List<Product> savedProducts = new ArrayList<>();
        savedProducts.add(product1);
        savedProducts.add(product2);

        List<Product> products = productRepository.findAll();

        //then
        Assertions.assertThat(savedProducts.equals(products));
    }
}