package com.landvive.summer.mvc.service;

import com.landvive.summer.mvc.dto.request.CategoryRequest;
import com.landvive.summer.mvc.entity.Category;
import com.landvive.summer.mvc.repository.CategoryRepository;
import com.landvive.summer.mvc.repository.MemoryCategoryRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CategoryServiceTest {

    CategoryRepository categoryRepository;
    CategoryService categoryService;

    @BeforeEach
    public void beforeEach() {
        this.categoryRepository = new MemoryCategoryRepository();
        this.categoryService = new CategoryService(categoryRepository);
    }

    @AfterEach
    public void afterEach() {
        categoryRepository.clearDb();
    }

    @Test
    void create() {

        //given
        CategoryRequest request = new CategoryRequest("카테고리");

        //when
        Long id = categoryService.create(request);

        //then
        Category category = categoryService.findByName("카테고리");

        Assertions.assertThat(category.getName()).isEqualTo(request.getName());
    }
}