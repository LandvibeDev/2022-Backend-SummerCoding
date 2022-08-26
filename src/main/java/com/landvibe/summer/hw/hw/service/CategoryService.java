package com.landvibe.summer.hw.hw.service;

import com.landvibe.summer.hw.hw.dto.request.CategoryRequest;
import com.landvibe.summer.hw.hw.entity.Category;
import com.landvibe.summer.hw.hw.repository.CategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CategoryService {


    private final CategoryRepository categoryRepository;

    public Long register(CategoryRequest request){

        validateCategory(request);

        Category newCategory = new Category(null, request.getName(), 0);
        categoryRepository.save(newCategory);
        return newCategory.getId();
    }

    private void validateCategory(CategoryRequest request) {
        Optional<Category> category = categoryRepository.findByName(request.getName());
        if(!category.isEmpty()){
            throw new IllegalStateException("이미 존재하는 카테고리입니다.");
        }
    }

    public Category findByName(String name){
        return categoryRepository.findByName(name)
                .orElseThrow(() -> new IllegalStateException("존재하지 않는 카테고리입니다."));
    }

    public Category findOne(Long id){
        return categoryRepository.findById(id)
                .orElseThrow(() -> new IllegalStateException("존재하지 않는 카테고리입니다."));
    }

    public Integer getCategoryListSize(){
        return categoryRepository.getCategoryListSize();
    }

    public Optional<List<Category>> getCategoryList(){
        return categoryRepository.getCategoryList();
    }
}
