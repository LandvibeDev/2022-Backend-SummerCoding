package com.landvibe.summer.hw.hw.controller;

import com.landvibe.summer.hw.hw.dto.request.CategoryRequest;
import com.landvibe.summer.hw.hw.dto.response.CategoryListResponse;
import com.landvibe.summer.hw.hw.dto.response.CategoryResponse;
import com.landvibe.summer.hw.hw.entity.Category;
import com.landvibe.summer.hw.hw.repository.CategoryRepository;
import com.landvibe.summer.hw.hw.repository.MemoryCategoryRepository;
import com.landvibe.summer.hw.hw.service.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class CategoryController {

    private final CategoryService categoryService;

    @PostMapping("/category")
    public CategoryResponse create(@RequestBody CategoryRequest request){
        Long categoryId = categoryService.register(request);
        return new CategoryResponse(categoryId, null, null);
    }

    @GetMapping("/categories")
    public CategoryListResponse getCategoryList(){
        Integer sz = categoryService.getCategoryListSize();
        Optional<List<Category>> list = categoryService.getCategoryList();
        CategoryListResponse categoryListResponse = new CategoryListResponse();
        categoryListResponse.setSz(sz);
        categoryListResponse.setCategoryList(list);
        return categoryListResponse;
    }

}
