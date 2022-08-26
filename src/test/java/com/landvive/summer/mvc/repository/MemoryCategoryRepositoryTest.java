package com.landvive.summer.mvc.repository;

import com.landvive.summer.mvc.entity.Category;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

class MemoryCategoryRepositoryTest {

    CategoryRepository categoryRepository = new MemoryCategoryRepository();

    @Test
    void save() {
        //given
        Category category = new Category(null,"카테고리", 1L);

        //when
        categoryRepository.save(category);
        Optional<Category> savedCategory = categoryRepository.findByName(category.getName());

        //then
        Assertions.assertThat(savedCategory.get()).isEqualTo(savedCategory.get());
    }
}