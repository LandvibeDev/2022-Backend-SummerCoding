package com.landvibe.summer.reservation.repository;

import com.landvibe.summer.reservation.entity.Category;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

class MemoryCategoryRepositoryTest {
    CategoryRepository repository = new MemoryCategoryRepository();

    @Test
    void save() {
        //given
        Category category = new Category("카테고리1", 1L, 1);
        //when
        repository.save(category);
        Optional<Category> savedCategory = repository.findByName(category.getCateName());

        //then
        Assertions.assertThat(savedCategory.get()).isEqualTo(savedCategory.get());
    }


}