package com.landvibe.summer.reservation.service;

import com.landvibe.summer.reservation.dto.request.ProductRequest;
import com.landvibe.summer.reservation.entity.Product;
import com.landvibe.summer.reservation.repository.CategoryRepository;
import com.landvibe.summer.reservation.repository.MemoryProductRepository;
import com.landvibe.summer.reservation.repository.ProductRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ProductServiceTest {
    ProductService service;
    ProductRepository repository;
    CategoryRepository categoryRepository;

    @BeforeEach
    public void beforEach() {
        this.repository = new MemoryProductRepository();
        this.service = new ProductService(repository, categoryRepository);
    }

    @AfterEach
    public void afterEach() {
        repository.clearDb();
    }

    @Test
    void join() {
        //given
        ProductRequest request = new ProductRequest(null, "심찬희", "찬희입니다", null);
        //when
        Long id = service.join(request);
        //then
        Product product = service.findByName("심찬희");

        Assertions.assertThat(product.getName()).isEqualTo(request.getName());

    }

    @Test
    public void 중복작품_예외() {
        //given
        ProductRequest request1 = new ProductRequest(null, "함석원", "함석원입니다", null);
        ProductRequest request2 = new ProductRequest(null, "함석원", "함입니다", null);
        //when
        service.join(request1);
        //then
        assertThrows(IllegalStateException.class, () -> {
            service.join(request2);
        });
    }
}