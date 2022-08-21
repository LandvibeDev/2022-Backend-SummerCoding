package com.landvibe.summer.mvc.controller;

import com.landvibe.summer.mvc.dto.request.CategoryRequest;
import com.landvibe.summer.mvc.dto.response.CategoriesResponse;
import com.landvibe.summer.mvc.dto.response.CategoryResponse;
import com.landvibe.summer.mvc.entity.Category;
import com.landvibe.summer.mvc.service.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/api")
public class CategoryController {
    private final CategoryService categoryService;

    @PostMapping("/category")
    public CategoryResponse create(@RequestBody CategoryRequest request) {
        Long categoryId = categoryService.register(request);
        if (categoryId.equals(-1L)) {
            return new CategoryResponse(-1, null);
        }
        Map<String, Long> map = new HashMap<>();
        map.put("id", categoryId);
        return new CategoryResponse(1, map);
    }

    @GetMapping("/categories")
    public CategoriesResponse read() {
        Integer size = categoryService.getCategories().size();
        List<Category> categories = categoryService.getCategories();
        return new CategoriesResponse(size, categories);
    }
}