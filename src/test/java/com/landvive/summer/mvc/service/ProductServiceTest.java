package com.landvive.summer.mvc.service;

import com.landvive.summer.mvc.dto.request.ProductRequest;
import com.landvive.summer.mvc.entity.Product;
import com.landvive.summer.mvc.repository.MemoryProductRepository;
import com.landvive.summer.mvc.repository.ProductRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ProductServiceTest {

    ProductRepository productRepository;
    ProductService productService;

    @BeforeEach
    public void beforeEach() {
        this.productRepository = new MemoryProductRepository();
    }

    @AfterEach
    public void afterEach() {
        productRepository.clearDb();
    }


    @Test
    void create() {

        //given
        ProductRequest request = new ProductRequest(null, "유지수", "설명");

        //when
        Long id = productService.create(request);

        //then
        Product product = productService.findByName("유지수");

        Assertions.assertThat(product.getName()).isEqualTo(request.getName());

    }
}