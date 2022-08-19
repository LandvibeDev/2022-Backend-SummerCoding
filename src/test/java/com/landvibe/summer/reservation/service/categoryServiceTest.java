package com.landvibe.summer.reservation.service;

import com.landvibe.summer.reservation.dto.request.CategoryRequest;
import com.landvibe.summer.reservation.dto.request.ProductRequest;
import com.landvibe.summer.reservation.entity.Category;
import com.landvibe.summer.reservation.entity.Product;
import com.landvibe.summer.reservation.repository.CategoryRepository;
import com.landvibe.summer.reservation.repository.MemoryCategoryRepository;
import com.landvibe.summer.reservation.repository.MemoryProductRepository;
import com.landvibe.summer.reservation.repository.ProductRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class categoryServiceTest {

    CategoryService service;
    CategoryRepository repository;

    @BeforeEach
    public void beforEach() {
        this.repository = new MemoryCategoryRepository();
        this.service = new CategoryService(repository);
    }

    @AfterEach
    public void afterEach() {
        repository.clearDb();
    }

    @Test
    void 카테고리등록() {
        //given
        CategoryRequest request = new CategoryRequest(-1, "1번 카테고리", -1);
        //when
        Long id = service.join(request);
        //then

        Category category = service.findByName(request.getName());

        Assertions.assertThat(category.getCateName()).isEqualTo(request.getName());
    }
}