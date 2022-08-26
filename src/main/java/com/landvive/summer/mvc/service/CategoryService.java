package com.landvive.summer.mvc.service;

import com.landvive.summer.mvc.dto.request.CategoryRequest;
import com.landvive.summer.mvc.dto.response.CategoriesResponse;
import com.landvive.summer.mvc.entity.Category;
import com.landvive.summer.mvc.repository.CateRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CategoryService {

    private final CateRepository repository;

    @Transactional
    public void save(Category category) {
        repository.save(category);
    }

    public Long create(CategoryRequest request) {
        if( !validateCategory(request) ) {
            return -1L;
        }

        Category newCategory = Category.builder()
                .id(null)
                .name(request.getName())
                .count(0L)
                .build();

        save(newCategory);

        return newCategory.getId();
    }

    private boolean validateCategory(CategoryRequest request) {
        repository.findByName2(request.getName()).ifPresent(u -> {
            throw new IllegalStateException("이미 존재하는 카테고리입니다.");
        });
        return true;
    }

    public List<Category> getCategoryList() {
        return repository.findAll();
    }

    //name을 통해서 카테고리를 가져옴
    public Category findByName(String name) {
        return repository.findByName2(name)
                .orElseThrow(() -> new IllegalStateException("존재하지 않는 카테고리입니다."));
        // 만약 null이면 예외로 던지겠다

    }

    //id를 통해서 카테고리를 가져옴
    public Category findById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new IllegalStateException("존재하지 않는 카테고리입니다."));
    }

}